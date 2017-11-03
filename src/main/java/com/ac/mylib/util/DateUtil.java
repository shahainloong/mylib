package com.ac.mylib.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 这是我自己的工具包下面的时间包类
 *  1，为MMB增加时间转换函数实现以下功能
 *      "2017-12-22"---->>>>"22 Dec 2017, Fri"
 *  
 * @author hailong.sha
 *
 */
public class DateUtil {
    // spring官方提供的log写法
    private final static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    /**
     * 这个时间转换方法是为MMB发送邮件的航班信息写的，获取的信息是："departureDate":"2017-12-22",
     * 需要转换成"22 Dec 2017, Fri"
     * 
     * @param departureTime
     * @return
     * @return String
     */
    public static String mmbTimeFormat(String departureTime) {
        Date date = null;
        try {
            SimpleDateFormat simpleDateFormatMatcher = new SimpleDateFormat("yyyy-MM-dd");
            date = simpleDateFormatMatcher.parse(departureTime);
        } catch (ParseException e) {
            // 在logger中可以使用"{}"来做占位符，替代后面的参数，即用{}替代参数e，最终显示的还是e
            logger.info("ERROR is here: {}",e);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy', 'E");
        return simpleDateFormat.format(date);
    }
    
    /**
     * Utility classes should not have public constructors 
     */
    private DateUtil() {
        super();
    }
    
}
