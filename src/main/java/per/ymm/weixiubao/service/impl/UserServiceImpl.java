package per.ymm.weixiubao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.ymm.weixiubao.dao.UserMapper;
import per.ymm.weixiubao.exception.MessageException;
import per.ymm.weixiubao.pojo.User;
import per.ymm.weixiubao.pojo.UserExample;
import per.ymm.weixiubao.service.UserService;

import java.util.List;

/**
 * @Author: ymm
 * @Date: 2018/6/6 20:50
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean submitUserInfo(final User user) throws MessageException {
        System.out.println(user.getOpenid());
        if (user.getOpenid() == null || user.getOpenid()=="") {
            throw new MessageException("openid不存在！！");
        }
        //查询是否已经存在
        UserExample ue = new UserExample();
        ue.createCriteria().andOpenidEqualTo(user.getOpenid());
        List<User> users = userMapper.selectByExample(ue);


        //没查到
        if (users.size() == 0 || users == null) {
        userMapper.insertSelective(user);
            return true;
        }

        return false;
    }
}
