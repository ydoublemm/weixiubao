package per.ymm.weixiubao.service;

import org.springframework.stereotype.Service;
import per.ymm.weixiubao.exception.MessageException;
import per.ymm.weixiubao.pojo.Orders;
import per.ymm.weixiubao.vo.PageVo;

import java.util.Map;

/**
 * @Author: ymm
 * @Date: 2018/5/13 20:31
 * @Description:
 */
@Service
public interface OrdersService {


    //新增一个订单
     String save(Orders orders);

     //分页查询订单
    Map receiveOrders(PageVo page ,Integer status) throws MessageException;

    //确认订单
    boolean confirmOrder(String orderId);


}
