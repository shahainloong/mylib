package com.ac.mylib.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

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
     * @Description: 时间格式的转化：2018-04-22-->>2018/04/22
     * @param timeFormat
     * @return String 返回类型
     */
    public static String dateExchange(String timeFormat) {
        Date date = null;
        try {
            SimpleDateFormat simpleDateFormatMatcher = new SimpleDateFormat("yyyy-MM-dd");
            date = simpleDateFormatMatcher.parse(timeFormat);
        } catch (ParseException e) {
            // 在logger中可以使用"{}"来做占位符，替代后面的参数，即用{}替代参数e，最终显示的还是e
            logger.info("ERROR is here: {}",e);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return simpleDateFormat.format(date);
    }
    
    public static String getSysDate() {
    	LocalDateTime today = LocalDateTime.now();
        System.out.println(today.toString().replaceAll("T", " "));
		return today.toString().replaceAll("T", " ");
    }

  /**
   * 获取下一天的时间，输出时间格式是YYYYMMDD
   *
   * @return
   */
  public static String getNextDate(String time) {
    //        不管时间格式是"20180730"还是"2018-07-30"，输出的originalDate格式都是2018-07-30
    LocalDate originalDateYMD = LocalDate.parse("20180730", DateTimeFormatter.BASIC_ISO_DATE);
    LocalDate originalDateY_M_D = LocalDate.parse("2018-08-30", DateTimeFormatter.ISO_LOCAL_DATE);

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    LocalDate nextDay = originalDateYMD.plusDays(1);
    System.out.println(nextDay.format(dateTimeFormatter));
    return nextDay.format(dateTimeFormatter);
  }

    /**
     * Utility classes should not have public constructors 
     */
    private DateUtil() {
        super();
    }
    
    public static void main(String[] args) {
    System.out.println(LocalDate.now());
	}
}
