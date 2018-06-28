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
import per.ymm.weixiubao.DTO.PageVo;

import java.util.Map;

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
    public ReturnMessage getInfoByPhone(@RequestBody Engineer engineer) throws MessageException {
        Engineer currEngineer = engineerService.findInfoByPhoneNumber(engineer.getPhoneNumber());
        ReturnMessage<Engineer> meg = new ReturnMessage(true);
        meg.setData(currEngineer);
        return meg;
    }

    //分页查询工程师信息
    @RequestMapping(value = "/getInfo.action")
    @ResponseBody
    public ReturnMessage getInfo(PageVo page){
        Map info = engineerService.getInfoByPage(page);
        ReturnMessage ok = ReturnMessage.ok();
        ok.setData(info);
        return ok ;
    }

    //修改工程师信息
    @RequestMapping(value = "/updateInfo.action")
    @ResponseBody
    public ReturnMessage updateInfo(Engineer engineer) throws MessageException {
        boolean b = engineerService.updateInfoById(engineer);
        return ReturnMessage.isOk(b);
    }

    //删除一个工程师
    @RequestMapping(value = "/deleteEngineer.action")
    @ResponseBody
    public ReturnMessage updateInfo(Integer id) throws MessageException {
        boolean b = engineerService.deleteEngineerByid(id);
        ReturnMessage message = ReturnMessage.isOk(b);
        if(b==false){
            message.setMessage("删除失败");
        }
        return message;
    }

/*
    //异常测试
    @RequestMapping(value = "/test")
    public  ReturnMessage test() throws MessageException {
       if(null==null){
           throw new MessageException("信息不能为空");
       }
        return ReturnMessage.ok();
    }
*/

}
