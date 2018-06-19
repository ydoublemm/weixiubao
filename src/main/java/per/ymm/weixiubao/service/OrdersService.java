package per.ymm.weixiubao.service;

import org.springframework.stereotype.Service;
import per.ymm.weixiubao.pojo.Orders;

/**
 * @Author: ymm
 * @Date: 2018/5/13 20:31
 * @Description:
 */
@Service
public interface OrdersService {


    //新增一个订单
    public String save(Orders orders);

}
