package com.ac.mylib.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自己的通用工具包
 * 1、增加对String类型的非空处理函数getNonNullStr(String str)
 * 
 * @author hailong.sha
 *
 */
public class CommonsUtil {
    // spring官方提供的log写法
    private final static Logger logger = LoggerFactory.getLogger(CommonsUtil.class);

    // string类型的非空处理
    public static String getNonNullStr(String str) {
        return null == str ? "" : str;
    }

    /**
     * Utility classes should not have public constructors
     */
    private CommonsUtil() {
        super();
    }

}
