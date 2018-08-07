package com.ac.mylib.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 自己的通用工具包
 * 1、增加对String类型的非空处理函数getNonNullStr(String str)
 * 
 * @author hailong.sha
 *
 */
public class CommonsUtil {
	// spring官方提供的log写法
	private static final Logger logger = LoggerFactory.getLogger(CommonsUtil.class);

	// string类型的非空处理
	public static String getNonNullStr(String str) {
		return null == str ? "" : str;
	}

	// 获取文件的名称以及后缀名
	public static String getFileNameSuffix() {
	String fileName = "";
	String fileNameSuffix = "";
	//		在Windows中HelloWorld.java的路径是E:\test\HelloWorld.java，必须使用反斜杠"\"来代替斜杠"/"，Linux直接使用反斜杠"\"
	File file = new File("E:/test/HelloWorld.java");
	if (file.exists()) {
	  fileName = file.getName();
	  fileNameSuffix = file.getName().substring(file.getName().lastIndexOf(".") + 1);
	  logger.info(fileName);
	  logger.info(fileNameSuffix);
	}
	return fileNameSuffix;
	}

	// Java判断远程服务器上文件是否存在（跨服务器）
	public static Boolean isURLExisted(String url) {
	Boolean existed = Boolean.TRUE;
	try {
	  URL serverUrl = new URL(url);
	  HttpURLConnection urlcon = (HttpURLConnection) serverUrl.openConnection();

	  String message = urlcon.getHeaderField(0);
	  if (StringUtils.hasText(message) && message.startsWith("HTTP/1.1 404")) {
		  existed = Boolean.FALSE;
		System.out.println("不存在");
	  } else {
		System.out.println("存在" + message);
	  }
	} catch (MalformedURLException e) {
		logger.error(e.getMessage(), e);
	} catch (IOException e) {
		logger.error(e.getMessage(), e);
	}
	return existed;
	}

    /**
     * Utility classes should not have public constructors
     */
    private CommonsUtil() {
        super();
    }

  public static void main(String[] args) {
	  isURLExisted("http://172.16.10.30:8001/ntk_report_20180702.xls");
  }
}
