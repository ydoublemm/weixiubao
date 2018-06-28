package per.ymm.weixiubao.service;

import org.springframework.stereotype.Service;
import per.ymm.weixiubao.dto.OrdersDTO;
import per.ymm.weixiubao.exception.MessageException;
import per.ymm.weixiubao.pojo.Orders;
import per.ymm.weixiubao.dto.PageDTO;

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
    Map receiveOrders(PageDTO page , Integer status) throws MessageException;

    //确认订单
    boolean confirmOrder(String orderId);

    //工程师接收订单
    boolean ordersTaking(OrdersDTO ordersDTO);

    //工程师获取订单信息（等待工程师接收的订单）
    List<Orders> getOrdersForEngineer();

    //工程师更具订单状态获取订单信息
    List<Orders> getOrdersByStatusForEngineer(OrdersDTO ordersVo) throws MessageException;

    //用户根据订单状态查询订单信息
     List<Orders> getOrdersByStatusForUser(OrdersDTO ordersDTO) throws MessageException;

     //后台拒绝接受订单
     boolean rejectOrder(String orderId) throws MessageException;

     //后台订单查询
    Map getBacktOrders(PageDTO pageDTO);

    //查询退单人的信息
     Object getBackPersonInfo(String backPersonId);

     //退单与对单原因
    boolean backOrder(OrdersDTO ordersDTO) throws MessageException;
}
