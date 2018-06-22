package per.ymm.weixiubao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import per.ymm.weixiubao.exception.MessageException;
import per.ymm.weixiubao.pojo.Orders;
import per.ymm.weixiubao.service.OrdersService;
import per.ymm.weixiubao.utils.ReturnMessage;
import per.ymm.weixiubao.utils.SaveFile;
import per.ymm.weixiubao.vo.PageVo;

import java.io.IOException;
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
        if(mf.length!=0) {
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
    public ReturnMessage receiveOrders(PageVo page,Integer status) throws IOException, MessageException {

        Map map = ordersService.receiveOrders(page,status);

        ReturnMessage message = ReturnMessage.ok();
        message.setData(map);

        return message;
    }

    //确认订单
    @RequestMapping(value = "/confirmOrder.action")
    @ResponseBody
    public ReturnMessage confirmOrder(String OrderId) throws IOException {

        boolean b = ordersService.confirmOrder(OrderId);
        ReturnMessage message = ReturnMessage.isOk(b);
        if(b==false){
            message.setMessage("请输入正确的订单号！！");
        }
        return message;
    }



}
