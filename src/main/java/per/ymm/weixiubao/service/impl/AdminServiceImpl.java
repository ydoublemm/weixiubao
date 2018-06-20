package per.ymm.weixiubao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.ymm.weixiubao.dao.AdminMapper;
import per.ymm.weixiubao.exception.MessageException;
import per.ymm.weixiubao.pojo.Admin;
import per.ymm.weixiubao.pojo.AdminExample;
import per.ymm.weixiubao.service.AdminService;
import per.ymm.weixiubao.utils.ReturnMessage;

import java.util.List;

/**
 * @Author: ymm
 * @Date: 2018/6/20 15:18
 * @Description:
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean login(final Admin admin) throws MessageException {
        //没有用户名和密码
        if(admin==null||admin.getUser()==null){
            throw  new MessageException("请输入用户名和密码！！");
        }

        //按用户名查询 然后比较
        AdminExample ae = new AdminExample();
        ae.createCriteria().andUserEqualTo(admin.getUser());
        List<Admin> admins = adminMapper.selectByExample(ae);
        if(admins==null || admins.size()==0){
            throw  new MessageException("用户不存在！！");
        }else if(!admins.get(0).getPassword().equals(admin.getPassword())){
            throw  new MessageException("密码不正确！！");
        }else {
            return true;
        }


    }

    @Override
    public Admin getgetAdminInfoByUser(final String adminName) throws Exception {
        if(adminName==null){
            throw new Exception("请先登录！！");
        }
        AdminExample ae = new AdminExample();
        ae.createCriteria().andUserEqualTo(adminName);
        List<Admin> admins = adminMapper.selectByExample(ae);
        return admins.get(0);
    }
}
