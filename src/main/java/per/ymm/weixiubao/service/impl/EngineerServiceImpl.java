package per.ymm.weixiubao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.ymm.weixiubao.dao.EngineerMapper;
import per.ymm.weixiubao.exception.MessageException;
import per.ymm.weixiubao.pojo.Engineer;
import per.ymm.weixiubao.pojo.EngineerExample;
import per.ymm.weixiubao.service.EngineerService;
import per.ymm.weixiubao.utils.EngineerUtils;
import per.ymm.weixiubao.vo.PageVo;

import javax.xml.stream.events.EndDocument;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ymm
 * @Date: 2018/4/14 21:43
 * @Description:
 */
@Service
public class EngineerServiceImpl implements EngineerService {

    @Autowired
    EngineerMapper engineerMapper;

    @Override
    public List<Engineer> findAll() {
        return engineerMapper.selectByExample(null);
    }

    @Override
    public void save(Engineer engineer) throws MessageException {
        //设置一些基本属性
        engineer.setGrade(0f);
        engineer.setReceiveNumber(0);
        engineer.setEndNumber(0);
        engineer.setBackNumber(0);
        engineer.setStatus(8);


        //查询和传进来engineer phoneNumber相等的人
        EngineerExample ee2 = new EngineerExample();
        ee2.createCriteria().andPhoneNumberEqualTo(engineer.getPhoneNumber());
        List<Engineer> engineers2 = engineerMapper.selectByExample(ee2);
        if (engineers2.size() != 0) {
            throw new MessageException("该手机号已被注册");/*如果手机号已存在 抛出异常*/
        }

        //查询和传进来engineer idCard相等的人
        EngineerExample ee1 = new EngineerExample();
        ee1.createCriteria().andIdCardEqualTo(engineer.getIdCard());
        List<Engineer> engineers1 = engineerMapper.selectByExample(ee1);
        if (engineers1.size() != 0) {
            throw new MessageException("该身份证号已被注册！");/*如果身份证已存在 抛出异常*/
        }


        //没有异常
        engineerMapper.insertSelective(engineer);
    }

    @Override
    public Engineer findInfoByPhoneNumber(final String phoneNumber) throws MessageException {
        List<Engineer> engineers = null;
        try {
            EngineerExample ee = new EngineerExample();
            ee.createCriteria().andPhoneNumberEqualTo(phoneNumber);
            engineers = engineerMapper.selectByExample(ee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //如果没有查到
        if (engineers.size() == 0) {
            throw new MessageException("没有这个工程师！");
        }
        return engineers.get(0);
    }

    @Override
    public Map<String, Object> getInfoByPage(PageVo page) {
        System.out.println(page.getPageSize());
        if (page.getPageSize() == null || page.getPageSize() <= 0) {
            page.setPageSize(7);
        }
        //这里page不用判断，pagehelper会帮忙判断
        Page<Object> newPage = PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<Engineer> engineers = engineerMapper.selectByExample(null);

        //设置密码为空
        for (Engineer e : engineers) {
            e.setPassword("");
        }

        Map<String, Object> map = new HashMap<>();
        page.setTotalCount((int) newPage.getTotal());
        page.setTotalPage(newPage.getPages());
        map.put("page", page);
        map.put("engineers", engineers);

        return map;
    }

    @Override
    public boolean updateInfoById(final Engineer engineer) throws MessageException {
        //判断数据的正确性
        if (!(EngineerUtils.isSpecialty(engineer.getSpecialty())
                && EngineerUtils.isStstus(engineer.getStatus()))) {
            throw new MessageException("数据不正确！！");
        }

        //改变记录的条数
        int n = engineerMapper.updateByPrimaryKeySelective(engineer);
        if (n == 0) {
            throw new MessageException("不存在此工程师！！");
        } else {
            return true;
        }
    }

    @Override
    public boolean deleteEngineerByid(final Integer id) {
        int i = engineerMapper.deleteByPrimaryKey(id);
        return i>0?true:false;
    }


}
