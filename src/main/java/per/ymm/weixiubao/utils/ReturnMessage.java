package per.ymm.weixiubao.utils;

/**
 * @Author: ymm
 * @Date: 2018/4/16 19:06
 * @Description:
 */
public class ReturnMessage<T> {
    boolean success;
    String message;
    T data;

    public static ReturnMessage Ok(){
        return new ReturnMessage(true,null,null);
    }

    public static ReturnMessage isOk(boolean isOk){
        return new ReturnMessage(isOk,null,null);
    }

    public static ReturnMessage isOk(boolean isOk,String message){
        return new ReturnMessage(isOk,message,null);
    }

    public ReturnMessage(final boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(final boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public ReturnMessage(final boolean success, final String message, final T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
}
