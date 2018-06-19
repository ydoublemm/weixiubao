package per.ymm.weixiubao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.ymm.weixiubao.dao.UserMapper;
import per.ymm.weixiubao.pojo.User;
import per.ymm.weixiubao.service.UserService;

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
    public boolean submitUserInfo(final User user) {
        return userMapper.insertSelective(user)>0?true:false;
    }
}
