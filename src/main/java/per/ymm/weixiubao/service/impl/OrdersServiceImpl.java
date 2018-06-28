package per.ymm.weixiubao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.ymm.weixiubao.dao.EngineerMapper;
import per.ymm.weixiubao.dao.OrdersMapper;
import per.ymm.weixiubao.dao.UserMapper;
import per.ymm.weixiubao.dto.OrdersDTO;
import per.ymm.weixiubao.dto.PageDTO;
import per.ymm.weixiubao.exception.MessageException;
import per.ymm.weixiubao.pojo.Orders;
import per.ymm.weixiubao.pojo.OrdersExample;
import per.ymm.weixiubao.pojo.UserExample;
import per.ymm.weixiubao.service.OrdersService;
import per.ymm.weixiubao.utils.PageVoUtils;

import javax.sound.midi.Soundbank;
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

    @Autowired
    private EngineerMapper engineerMapper;

    @Autowired
    private UserMapper userMapper;

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
    public Map receiveOrders(final PageDTO page, Integer status) throws MessageException {
        //page健壮性检查
        PageVoUtils.check(page);
        if (status == null || status > 3 || status < 0) {
            throw new MessageException("订单状态不符合！！");
        }
        //用pagehelper进行分页
        Page<Object> newPage = PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        OrdersExample or = new OrdersExample();
        or.createCriteria().andStatusEqualTo(status)
                .andModeEqualTo(1);
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
        o.setStatus(1);//等待工程师受理
        int i = ordersMapper.updateByPrimaryKeySelective(o);
        return i >= 1 ? true : false;
    }

    @Override
    public boolean ordersTaking(OrdersDTO ordersDTO) {
        Orders o = new Orders();
        o.setId(ordersDTO.getOrderId());
        o.setEngineerId(ordersDTO.getEngineerId());
        o.setStatus(2);//工程师已受理
        int i = ordersMapper.updateByPrimaryKeySelective(o);

        return i >= 1 ? true : false;
    }

    @Override
    public List<Orders> getOrdersForEngineer() {
        OrdersExample oe = new OrdersExample();
        oe.createCriteria().andStatusEqualTo(1).andModeEqualTo(1);
        List<Orders> orders = ordersMapper.selectByExample(oe);
        return orders;
    }

    @Override
    public List<Orders> getOrdersByStatusForEngineer(OrdersDTO ordersDTO) throws MessageException {
        //判断查询的信息是否合法
        if (ordersDTO.getStatus() > 3 || ordersDTO.getStatus() < 2) {
            throw new MessageException("无法查询该状态的订单！！");
        }
        OrdersExample oe = new OrdersExample();
        //查询工程师自己的 已受理订单 和已结束订单
        oe.createCriteria().andStatusEqualTo(ordersDTO.getStatus())
                .andEngineerIdEqualTo(ordersDTO.getEngineerId())
                .andModeEqualTo(1);
        List<Orders> orders = ordersMapper.selectByExample(oe);
        return orders;
    }

    @Override
    public List<Orders> getOrdersByStatusForUser(final OrdersDTO ordersDTO) throws MessageException {
        //判断查询的信息是否合法
        if (ordersDTO.getStatus() > 3 || ordersDTO.getStatus() < 0) {
            throw new MessageException("无法查询该状态的订单！！");
        }
        OrdersExample oe = new OrdersExample();
        //查询工程师自己的 已受理订单 和已结束订单
        oe.createCriteria().andStatusEqualTo(ordersDTO.getStatus())
                .andUserOpenidEqualTo(ordersDTO.getOpenId())
                .andModeEqualTo(1);
        List<Orders> orders = ordersMapper.selectByExample(oe);
        return orders;
    }

    @Override
    public boolean rejectOrder(final String orderId) throws MessageException {
        //先查出来看订单的状态
        Orders existOrder = ordersMapper.selectByPrimaryKey(orderId);
        if (existOrder.getStatus() != 0) {
            throw new MessageException("不能进行这个操作！！");
        }
        Orders o = new Orders();
        o.setId(orderId);
        o.setStatus(-1);//拒绝接受订单
        int i = ordersMapper.updateByPrimaryKeySelective(o);
        return i >= 1 ? true : false;
    }

    @Override
    public Map<String, Object> getBacktOrders(final PageDTO pageDTO) {
        //pageDTO健壮性检查
        PageVoUtils.check(pageDTO);
        //用pagehelper进行分页
        Page<Object> newPage = PageHelper.startPage(pageDTO.getCurrentPage(), pageDTO.getPageSize());
        OrdersExample or = new OrdersExample();
        or.createCriteria().andModeEqualTo(2)
                .andModeEqualTo(1);
        List<Orders> orders = ordersMapper.selectByExample(or);

        //装进map
        Map<String, Object> map = new HashMap<>();
        pageDTO.setTotalCount((int) newPage.getTotal());
        pageDTO.setTotalPage(newPage.getPages());
        map.put("page", pageDTO);
        map.put("orders", orders);

        return map;
    }

    @Override
    public Object getBackPersonInfo(final String backPersonId) {
        Object BackPersonInfo;
        if (backPersonId.length() == 28 && (!"0".equals(backPersonId))) {//openid一般为28个字符
            UserExample ue = new UserExample();
            ue.createCriteria().andOpenidEqualTo(backPersonId);
            BackPersonInfo = userMapper.selectByExample(ue).get(0);
        } else {
            BackPersonInfo = engineerMapper.selectByPrimaryKey(Integer.parseInt(backPersonId));
        }
        return BackPersonInfo;

    }

    @Override
    public boolean backOrder(final OrdersDTO ordersDTO) throws MessageException {//这个方法应该加锁
        //先查出来看订单的状态
        Orders existOrder = ordersMapper.selectByPrimaryKey(ordersDTO.getOrderId());
        if (!existOrder.getMode().equals(1)) {//不是1 说明已经推过单了
            throw new MessageException("不能进行这个操作！！");
        }
        Orders order = new Orders();
        order.setId(ordersDTO.getOrderId());
        order.setMode(2);
        //取两者中有值得一方
        order.setBackPerson(ordersDTO.getOpenId()!=null?
                                ordersDTO.getOpenId():
                                ordersDTO.getEngineerId()+"");
        order.setReason(ordersDTO.getReason());
        int i = ordersMapper.updateByPrimaryKeySelective(order);
        return i==1?true:false;
    }

    @Override
    public boolean setOrderPrice(final OrdersDTO ordersDTO) throws MessageException {
        //先查出来看订单的状态
        Orders existOrder = ordersMapper.selectByPrimaryKey(ordersDTO.getOrderId());
        //不是2 不能设置金额
        if ((!existOrder.getStatus().equals(2))) {
            throw new MessageException("不能进行这个操作！！");
        }
        Orders order = new Orders();
        order.setId(ordersDTO.getOrderId());
        //order.setPayMode(ordersDTO.getPayMode());
        order.setPrice(ordersDTO.getPrice());
        int i = ordersMapper.updateByPrimaryKeySelective(order);
        return i==1?true:false;
    }

    @Override
    public boolean endingOrder(final String OrderId) throws MessageException {
        //先查出来看订单的状态
        Orders existOrder = ordersMapper.selectByPrimaryKey(OrderId);
        //不是2 不能结束
        if (!existOrder.getStatus().equals(2)) {
            throw new MessageException("不能进行这个操作！！");
        }
        Orders order = new Orders();
        order.setId(OrderId);
        //把订单状态设置为3，结束
        order.setStatus(3);
        //设置结束时间
        order.setEndTime(new Date());
        int i = ordersMapper.updateByPrimaryKeySelective(order);
        return i==1?true:false;
    }

    @Override
    public boolean evaluateOrder(final OrdersDTO ordersDTO) throws MessageException {
        //先查出来看订单的状态
        Orders existOrder = ordersMapper.selectByPrimaryKey(ordersDTO.getOrderId());
        //不是3 不能评价
        if (!existOrder.getStatus().equals(3)) {
            throw new MessageException("不能进行这个操作！！");
        }

        if(ordersDTO.getEvaluate().length()>=255){
            throw new MessageException("评价太长啦！！");
        }
        Orders order = new Orders();
        order.setId(ordersDTO.getOrderId());
        order.setEvaluate(ordersDTO.getEvaluate());
        int i = ordersMapper.updateByPrimaryKeySelective(order);
        return i==1?true:false;
    }


}
