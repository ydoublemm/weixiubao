package per.ymm.weixiubao.DTO;

/**
 * @Author: ymm
 * @Date: 2018/6/26 9:49
 * @Description:
 */
public class OrdersVo {
    private Integer engineerId;
    private String orderId;
    private Integer status;
    private String openId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(final String openId) {
        this.openId = openId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(final Integer status) {
        this.status = status;
    }

    public Integer getEngineerId() {
        return engineerId;
    }

    public void setEngineerId(final Integer engineerId) {
        this.engineerId = engineerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(final String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrdersVo{" +
                "engineerId=" + engineerId +
                ", orderId='" + orderId + '\'' +
                ", status=" + status +
                ", openId='" + openId + '\'' +
                '}';
    }
}
