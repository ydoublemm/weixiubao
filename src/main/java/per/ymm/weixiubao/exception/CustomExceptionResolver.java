package per.ymm.weixiubao.exception;

import com.sun.javafx.image.BytePixelSetter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: ymm
 * @Date: 2018/4/16 15:43
 * @Description:
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(final HttpServletRequest request,
                                         final HttpServletResponse response,
                                         final Object o,
                                         final Exception e) {


        ModelAndView mv = new ModelAndView();
        /*  使用response返回    */
        response.setStatus(HttpStatus.OK.value()); //设置状态码
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
        response.setCharacterEncoding("UTF-8"); //避免乱码
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        if(e instanceof MessageException){
            try {
                //强转
                MessageException me = (MessageException)e;
                response.getWriter().write("{\"success\":false,\"msg\":\"" + me.getMsg() + "\",\"data\":null}");
            } catch (IOException ex) {
               //记录异常，发短信，邮件
            }
        }else{
            try {
                response.getWriter().write("{\"success\":false,\"msg\":\"Unknow Exception\",\"data\":null}");
            } catch (IOException ex) {
                //记录异常，发短信，邮件
            }
        }

        return mv;
    }
}
