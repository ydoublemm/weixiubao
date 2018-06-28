package per.ymm.weixiubao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import per.ymm.weixiubao.dto.PageDTO;
import per.ymm.weixiubao.exception.MessageException;
import per.ymm.weixiubao.pojo.User;
import per.ymm.weixiubao.service.UserService;
import per.ymm.weixiubao.utils.ReturnMessage;

import java.util.Map;

/**
 * @Author: ymm
 * @Date: 2018/4/23 14:39
 * @Description:
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    //上传用户信息保存到服务器
    @RequestMapping(value = "/submitUserInfo.action")
    @ResponseBody
    public ReturnMessage submitUserInfo(@RequestBody User user) throws MessageException {
        return  ReturnMessage.isOk(userService.submitUserInfo(user));
    }

    //分页查询用户的信息
    @RequestMapping(value = "/getUserInfoByPage.action")
    @ResponseBody
    public ReturnMessage getUserInfoByPage(PageDTO pageDTO) throws MessageException {
        Map info = userService.getUserInfoByPage(pageDTO);
        ReturnMessage ok = ReturnMessage.ok();
        ok.setData(info);
        return  ok;
    }


}
