package per.ymm.weixiubao.service;

import org.springframework.stereotype.Service;
import per.ymm.weixiubao.exception.MessageException;
import per.ymm.weixiubao.pojo.Orders;
import per.ymm.weixiubao.vo.OrdersVo;
import per.ymm.weixiubao.vo.PageVo;

import java.util.List;
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

    //工程师接收订单
    boolean ordersTaking(OrdersVo ordersVo);

    //工程师获取订单信息（等待工程师接收的订单）
    List<Orders> getOrdersForEngineer();

    //工程师更具订单状态获取订单信息
    List<Orders> getOrdersByStatusForEngineer(OrdersVo ordersVo) throws MessageException;

    //用户根据订单状态查询订单信息
     List<Orders> getOrdersByStatusForUser(OrdersVo ordersVo) throws MessageException;
}
