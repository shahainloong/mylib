package com.ac.mylib.java.basic.proxy.cglibdynamic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CGLIB 可以代理未实现任何接口的类
 */
public class AliSmsService {
  // spring官方提供的log写法
  private static final Logger logger = LoggerFactory.getLogger(AliSmsService.class);

  public String send(String message) {
    System.out.println("Send message:" + message);
    return null;
  }
}
