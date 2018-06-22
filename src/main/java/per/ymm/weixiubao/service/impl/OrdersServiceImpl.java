package per.ymm.weixiubao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.ymm.weixiubao.dao.OrdersMapper;
import per.ymm.weixiubao.exception.MessageException;
import per.ymm.weixiubao.pojo.Engineer;
import per.ymm.weixiubao.pojo.Orders;
import per.ymm.weixiubao.pojo.OrdersExample;
import per.ymm.weixiubao.service.OrdersService;
import per.ymm.weixiubao.utils.PageVoUtils;
import per.ymm.weixiubao.vo.PageVo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        orders.setReceiveTime(new Date());
        orders.setBackPerson("0");
        orders.setPayMode(0);
        //插入到数据库
        ordersMapper.insertSelective(orders);
        return orders.getId();
    }

    @Override
    public Map receiveOrders(final PageVo page, Integer status) throws MessageException {
        //page健壮性检查
        PageVoUtils.check(page);
        if (status == null || status > 3 || status < 0) {
            throw new MessageException("订单状态不符合！！");
        }
        //用pagehelper进行分页
        Page<Object> newPage = PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        OrdersExample or = new OrdersExample();
        or.createCriteria().andStatusEqualTo(status);
        List<Orders> orders = ordersMapper.selectByExample(or);

        //装进map
        Map<String, Object> map = new HashMap<>();
        page.setTotalCount((int) newPage.getTotal());
        page.setTotalPage(newPage.getPages());
        map.put("page", page);
        map.put("orders", orders);

        return map;
    }

    @Override
    public boolean confirmOrder(final String orderId) {
        Orders o = new Orders();
        o.setId(orderId);
        o.setStatus(1);
        int i = ordersMapper.updateByPrimaryKeySelective(o);
        System.out.println(i);
        return i >= 1 ? true : false;
    }


}
