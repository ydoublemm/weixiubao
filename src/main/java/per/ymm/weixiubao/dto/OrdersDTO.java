package per.ymm.weixiubao.dto;

/**
 * @Author: ymm
 * @Date: 2018/6/26 9:49
 * @Description:
 */
public class OrdersDTO {
    private Integer engineerId;
    private String orderId;
    private Integer status;
    private String openId;
    private String reason;
    private  Double price;
    private Integer payMode;
    private String evaluate;

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(final String evaluate) {
        this.evaluate = evaluate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public Integer getPayMode() {
        return payMode;
    }

    public void setPayMode(final Integer payMode) {
        this.payMode = payMode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(final String reason) {
        this.reason = reason;
    }

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
        return "OrdersDTO{" +
                "engineerId=" + engineerId +
                ", orderId='" + orderId + '\'' +
                ", status=" + status +
                ", openId='" + openId + '\'' +
                ", reason='" + reason + '\'' +
                ", price=" + price +
                ", payMode=" + payMode +
                '}';
    }
}
