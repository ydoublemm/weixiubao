package per.ymm.weixiubao.service;

import per.ymm.weixiubao.exception.MessageException;
import per.ymm.weixiubao.pojo.Admin;
import per.ymm.weixiubao.utils.ReturnMessage;

/**
 * @Author: ymm
 * @Date: 2018/6/20 13:55
 * @Description:
 */
public interface AdminService {
    //管理员登陆
    boolean login(Admin admin) throws MessageException;
    //获取管理管信息
    Admin getAdminInfoByUser(String adminName) throws Exception;
}
