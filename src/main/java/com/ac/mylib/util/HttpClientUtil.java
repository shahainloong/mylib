package com.ac.mylib.util;

import org.apache.http.client.methods.HttpUriRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
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
public class HttpClientUtil {
	// spring官方提供的log写法
	private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);


	private HttpUriRequest buildRequestHeaders(HttpUriRequest request){
		request.addHeader("Accept-Language", "en-US,en;q=0.8");
		request.addHeader("Accept", "application/json");
		request.addHeader("Content-Type", "application/json");
		return  request;
	}

    /**
     * Utility classes should not have public constructors
     */
    private HttpClientUtil() {
        super();
    }

  public static void main(String[] args) {
  }
}
