package per.ymm.weixiubao.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: ymm
 * @Date: 2018/5/7 20:47
 * @Description:
 */
public class PropertiesInfo {

    /*
     * @author: ymm
     * @date: 2018/5/7 20:51
     * @param: [propertiesNmae, field]
     *         propertie文件   字段名
     * @return: java.lang.String
     * @Description: 获取propertie文件的信息
     */
    public String getPropertiesInfo(String propertiesNmae, String field) throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propertiesNmae);
        Properties properties = new Properties();
        try{
            properties.load(inputStream);
        }catch (IOException ioE){
            ioE.printStackTrace();
        }finally{
            inputStream.close();
        }
        return  properties.getProperty(field);
    }
}
