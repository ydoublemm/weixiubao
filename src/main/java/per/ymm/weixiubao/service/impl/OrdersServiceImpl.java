package per.ymm.weixiubao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.ymm.weixiubao.dao.OrdersMapper;
import per.ymm.weixiubao.pojo.Orders;
import per.ymm.weixiubao.service.OrdersService;

/**
 * @Author: ymm
 * @Date: 2018/5/13 20:33
 * @Description:
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public String save(final Orders orders) {
        //设置初始化信息
        orders.setStatus(0);//订单状态 需要前端确认
        orders.setMode(1);//是否要服务：1是，2退单
        orders.setCurrentOrder(1);//是否是当前订单 1是，2不是

        //插入到数据库
        ordersMapper.insertSelective(orders);
        return orders.getId();
    }
}
