package per.ymm.weixiubao.service;

import per.ymm.weixiubao.pojo.User;

/**
 * @Author: ymm
 * @Date: 2018/6/6 20:48
 * @Description:
 */
public interface UserService {
    ////上传用户信息保存到服务器
    boolean submitUserInfo(User user);
}
