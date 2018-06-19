package per.ymm.weixiubao.utils;

import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: ymm
 * @Date: 2018/6/14 14:29
 * @Description:
 */
public class DateConveter implements Converter<String,Date> {
    @Override
    public Date convert(final String s) {
        try {
            if(s!=null){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM");
                return sdf.parse(s);
                /*return new Timestamp(sdf.parse(s).getTime());*/
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
