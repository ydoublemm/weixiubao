package per.ymm.weixiubao.service;

import per.ymm.weixiubao.dto.PageDTO;
import per.ymm.weixiubao.exception.MessageException;
import per.ymm.weixiubao.pojo.User;

import java.util.Map;

/**
 * @Author: ymm
 * @Date: 2018/6/6 20:48
 * @Description:
 */
public interface UserService {
    //上传用户信息保存到服务器
    boolean submitUserInfo(User user) throws MessageException;

    //分页查询用户的信息
    Map getUserInfoByPage(PageDTO pageDTO);
}
