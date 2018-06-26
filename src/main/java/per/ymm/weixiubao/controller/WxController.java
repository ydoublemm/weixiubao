package per.ymm.weixiubao.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import per.ymm.weixiubao.utils.ReturnMessage;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ymm
 * @Date: 2018/6/20 10:15
 * @Description:
 */
@Controller
@RequestMapping(value = "/wx")
public class WxController {
    @ResponseBody
    @RequestMapping("/getOpenId.action")//此处填自己要用到的项目名。
    public ReturnMessage getOpenid(@RequestParam(value="code",required=false)String wxCode) {//接收用户传过来的code，required=false表明如果这个参数没有传过来也可以。
         String code=wxCode;
        //接收从客户端获取的code
        //向微信后台发起请求获取openid的url
        String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
        //这三个参数就是之后要填上自己的值。
        //替换appid，appsecret，和code
        String requestUrl = WX_URL.
                replace("APPID", "wx108acd1bd3a50833").//填写自己的appid
                replace("SECRET", "fbcd8ffb9c39bf52003411ee49b65391").//填写自己的appsecret，
                replace("JSCODE", code). //code
                replace("authorization_code", "authorization_code");

        //调用get方法发起get请求，并把返回值赋值给returnvalue
        String  returnvalue=GET(requestUrl);
        System.out.println(requestUrl);//打印发起请求的url
        System.out.println(returnvalue);//打印调用GET方法返回值
        //定义一个json对象。
        JSONObject convertvalue=new JSONObject();

        //将得到的字符串转换为json
        convertvalue=(JSONObject) JSON.parse(returnvalue);
        System.out.println(convertvalue);

        //把openid和sessionkey分别赋值给openid和sessionkey
        String openId=(String) convertvalue.get("openid");
        String sessionKey=(String) convertvalue.get("session_key");//定义两个变量存储得到的openid和session_key.

        //放进map
        Map<String,String> map = new HashMap<>();
        map.put("openId",openId);
        map.put("sessionKey",sessionKey);

        ReturnMessage rm = new ReturnMessage(true,null,map);

        return rm;//返回openid
    }
    //发起get请求的方法。
    public static String GET(String url) {
        String result = "";
        BufferedReader in = null;
        InputStream is = null;
        InputStreamReader isr = null;
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.connect();
            Map<String, List<String>> map = conn.getHeaderFields();
            is = conn.getInputStream();
            isr = new InputStreamReader(is);
            in = new BufferedReader(isr);
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            // 异常记录
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (is != null) {
                    is.close();
                }
                if (isr != null) {
                    isr.close();
                }
            } catch (Exception e2) {
                // 异常记录
            }
        }
        return result;
    }



}
