package per.ymm.weixiubao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import per.ymm.weixiubao.exception.MessageException;
import per.ymm.weixiubao.pojo.Admin;
import per.ymm.weixiubao.service.AdminService;
import per.ymm.weixiubao.utils.ReturnMessage;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: ymm
 * @Date: 2018/6/20 13:48
 * @Description:
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    //登陆
    @RequestMapping(value = "/login.action")
    @ResponseBody
    public ReturnMessage login( Admin admin ,HttpServletRequest request) throws MessageException {
        boolean login = adminService.login(admin);
        if(login){
            request.getSession().setAttribute("admin",admin.getUser());
        }
        return ReturnMessage.isOk(login);
    }

    //获取管理员信息
    @RequestMapping(value = "/getAdminInfo.action")
    @ResponseBody
    public ReturnMessage getAdminInfo(HttpServletRequest request) throws Exception {
       //从session拿到用户名
        String adminName = (String)request.getSession().getAttribute("admin");

        Admin admin = adminService.getAdminInfoByUser(adminName);
        //密码不能传哦
        admin.setPassword("");
        ReturnMessage rm = new ReturnMessage(true,null,admin);

        return rm;
    }




}
