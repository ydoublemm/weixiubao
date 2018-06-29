package per.ymm.weixiubao.constant;

/**
 * @Author: ymm
 * @Date: 2018/6/29 9:44
 * @Description:
 */
public class OrderConstant {
    //定单的四个状态
    public static final Integer STATUS_ORDER_RECEIVED=0;
    public static final Integer STATUS_ORDER_WAITENGINEER=1;
    public static final Integer STATUS_ORDER_ACCEPT=2;
    public static final Integer STATUS_ORDER_END=3;

    //工程师的有效状态
    public static final Integer ENGINEER_EFFECTIVE=8;
    public static final Integer ENGINEER_INVALID=9;

    //是否退单
    public static final Integer MODE_ONGOING=1;
    public static final Integer MODE_BACK=2;

    //支付方式
    public static final Integer PAYMODE_UNKNOW=0;
    public static final Integer PAYMODE_WEIXIN=1;
    public static final Integer PAYMODE_CASH=2;

    //是否是当前订单
    public static final Integer CURRENT_ORDER_YES=1;
    public static final Integer CURRENT_ORDER_NO=2;

}
