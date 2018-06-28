package per.ymm.weixiubao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import per.ymm.weixiubao.exception.MessageException;
import per.ymm.weixiubao.pojo.Orders;
import per.ymm.weixiubao.service.OrdersService;
import per.ymm.weixiubao.utils.ReturnMessage;
import per.ymm.weixiubao.utils.SaveFile;
import per.ymm.weixiubao.dto.OrdersDTO;
import per.ymm.weixiubao.dto.PageDTO;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author: ymm
 * @Date: 2018/5/5 20:46
 * @Description:
 */
@Controller
@RequestMapping(value = "/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    //生成一个订单
    @RequestMapping(value = "/save.action")
    @ResponseBody
    public ReturnMessage createOrders(
            Orders orders, @RequestParam(value = "file", required = false) MultipartFile[] mf) throws IOException {

        //orders.setId(UUID.randomUUID().toString());
        //图片名字
        if (mf.length != 0) {
            String fileName = SaveFile.save(mf);
            orders.setPicInfo(fileName);
        }
        System.out.println(orders);
        ordersService.save(orders);

        return ReturnMessage.ok();
    }

    //分页查询订单
    @RequestMapping(value = "/receiveOrders.action")
    @ResponseBody
    public ReturnMessage receiveOrders(PageDTO page, Integer status) throws IOException, MessageException {

        Map map = ordersService.receiveOrders(page, status);

        ReturnMessage message = ReturnMessage.ok();
        message.setData(map);

        return message;
    }

    //后台确认订单
    @RequestMapping(value = "/confirmOrder.action")
    @ResponseBody
    public ReturnMessage confirmOrder(String OrderId) throws IOException {

        boolean b = ordersService.confirmOrder(OrderId);
        ReturnMessage message = ReturnMessage.isOk(b);
        if (b == false) {
            message.setMessage("请输入正确的订单号！！");
        }
        return message;
    }

    //工程师抢单
    @RequestMapping(value = "/ordersTaking.action")
    @ResponseBody
    public ReturnMessage ordersTaking(@RequestBody OrdersDTO otv) throws IOException {

        boolean b = ordersService.ordersTaking(otv);
        ReturnMessage message = ReturnMessage.isOk(b);
        if (b == false) {
            message.setMessage("信息错误！！");
        }
        return message;
    }

    //获取订单信息
    @RequestMapping(value = "/getOrdersForEngineer.action")
    @ResponseBody
    public ReturnMessage getOrdersForEngineer() throws IOException {

        List<Orders> orders = ordersService.getOrdersForEngineer();
        ReturnMessage message = ReturnMessage.ok();
        message.setData(orders);
        return message;
    }

    //获取工程师相关的订单信息
    @RequestMapping(value = "/getOrdersByStatusForEngineer.action")
    @ResponseBody
    public ReturnMessage getOrdersByStatusForEngineer(@RequestBody OrdersDTO otv) throws IOException, MessageException {
        List<Orders> orders = ordersService.getOrdersByStatusForEngineer(otv);
        ReturnMessage message = ReturnMessage.ok();
        message.setData(orders);
        return message;
    }

    //用户查询订单相关信息
    @RequestMapping(value = "/getOrdersByStatusForUser.action")
    @ResponseBody
    public ReturnMessage getOrdersByStatusForUser(OrdersDTO otv) throws IOException, MessageException {
        List<Orders> orders = ordersService.getOrdersByStatusForUser(otv);
        ReturnMessage message = ReturnMessage.ok();
        message.setData(orders);
        return message;
    }

    //后台拒收订单
    @RequestMapping(value = "/rejectOrder.action")
    @ResponseBody
    public ReturnMessage rejectOrder(String orderId) throws IOException, MessageException {

        boolean b = ordersService.rejectOrder(orderId);
        ReturnMessage message = ReturnMessage.isOk(b);
        if(b==false){
            message.setMessage("修改失败，可能不存在这个订单！！");
        }
        return message;
    }

    //后台查询退单查询
    @RequestMapping(value = "/getBackOrders.action")
    @ResponseBody
    public ReturnMessage getBacktOrders(PageDTO pageDTO) {

        Map backtOrders = ordersService.getBacktOrders(pageDTO);
        ReturnMessage message = ReturnMessage.ok();
        message.setData(backtOrders);
        return message;
    }

    //查询退单人的信息(可能是工程师或者用户)
    @RequestMapping(value = "/getBackPersonInfo.action")
    @ResponseBody
    public ReturnMessage getBackPersonInfo(String backPersonId) {
        Object backPersonInfo = ordersService.getBackPersonInfo(backPersonId);
        ReturnMessage message = ReturnMessage.ok();
        message.setData(backPersonInfo);
        return message;
    }

    //用户退单
    @RequestMapping(value = "/backOrderForUser.action")
    @ResponseBody
    public ReturnMessage backOrderForUser(OrdersDTO ordersDTO) throws MessageException {
        boolean b = ordersService.backOrder(ordersDTO);
        ReturnMessage message = ReturnMessage.isOk(b);
        if (b==false){
            message.setMessage("操作失败！！");
        }
        return message;
    }

}
