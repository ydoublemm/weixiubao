package per.ymm.weixiubao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.ymm.weixiubao.dao.EngineerMapper;
import per.ymm.weixiubao.exception.MessageException;
import per.ymm.weixiubao.pojo.Engineer;
import per.ymm.weixiubao.pojo.EngineerExample;
import per.ymm.weixiubao.service.EngineerService;

import java.util.List;

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
        if(engineers2.size()!=0){
            throw new MessageException("该手机号已被注册");/*如果手机号已存在 抛出异常*/
        }

        //查询和传进来engineer idCard相等的人
        EngineerExample ee1 = new EngineerExample();
        ee1.createCriteria().andIdCardEqualTo(engineer.getIdCard());
        List<Engineer> engineers1 = engineerMapper.selectByExample(ee1);
        if(engineers1.size()!=0){
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
        if(engineers.size()==0){
            throw new MessageException("没有这个工程师！");
        }
        return engineers.get(0);
    }
}
