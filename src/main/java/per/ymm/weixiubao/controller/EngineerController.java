package per.ymm.weixiubao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import per.ymm.weixiubao.exception.MessageException;
import per.ymm.weixiubao.pojo.Engineer;
import per.ymm.weixiubao.service.EngineerService;
import per.ymm.weixiubao.utils.ReturnMessage;

/**
 * @Author: ymm
 * @Date: 2018/4/16 15:14
 * @Description:工程师的controller
 */
@Controller
@RequestMapping(value = "/engineer")
public class EngineerController {
    @Autowired
    EngineerService engineerService;

    //工程师注册
    @RequestMapping(value = "/register.action", method = RequestMethod.POST)
    @ResponseBody
    public ReturnMessage register(@RequestBody Engineer engineer) throws MessageException {
        engineerService.save(engineer);
        ReturnMessage<Engineer> meg = new ReturnMessage(true);
        return meg;
    }

    //根据电话查询工程师的信息
    @RequestMapping(value = "/findInfoByPhoneNumber.action", method = RequestMethod.POST)
    @ResponseBody
    public ReturnMessage findInfo(@RequestBody Engineer engineer) throws MessageException {
        Engineer currEngineer = engineerService.findInfoByPhoneNumber(engineer.getPhoneNumber());
        ReturnMessage<Engineer> meg = new ReturnMessage(true);
        meg.setData(currEngineer);
        return meg;
    }

}
