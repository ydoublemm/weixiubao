package per.ymm.weixiubao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.ymm.weixiubao.dao.UserMapper;
import per.ymm.weixiubao.dto.PageDTO;
import per.ymm.weixiubao.exception.MessageException;
import per.ymm.weixiubao.pojo.Engineer;
import per.ymm.weixiubao.pojo.User;
import per.ymm.weixiubao.pojo.UserExample;
import per.ymm.weixiubao.service.UserService;
import per.ymm.weixiubao.utils.PageVoUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map getUserInfoByPage(final PageDTO pageDTO) {
        //健壮性检查
        PageVoUtils.check(pageDTO);
        //pagehelper分页
        Page<Object> newPage = PageHelper.startPage(pageDTO.getCurrentPage(), pageDTO.getPageSize());
        List<User> users = userMapper.selectByExample(null);


        //等装到map中
        Map<String, Object> map = new HashMap<>();
        pageDTO.setTotalCount((int) newPage.getTotal());
        pageDTO.setTotalPage(newPage.getPages());
        map.put("users", users);
        map.put("page", pageDTO);
        return map;

    }
}
