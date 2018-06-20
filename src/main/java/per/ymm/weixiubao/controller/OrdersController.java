package per.ymm.weixiubao.controller;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import per.ymm.weixiubao.pojo.Orders;
import per.ymm.weixiubao.service.OrdersService;
import per.ymm.weixiubao.utils.ReturnMessage;
import per.ymm.weixiubao.utils.SaveFile;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

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

        return ReturnMessage.Ok();
    }
}
