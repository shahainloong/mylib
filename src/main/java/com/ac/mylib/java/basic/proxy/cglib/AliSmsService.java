package com.ac.mylib.java.basic.proxy.cglib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AliSmsService {
  // spring官方提供的log写法
  private static final Logger logger = LoggerFactory.getLogger(AliSmsService.class);
  public String send(String message){
    System.out.println("Send message:" + message);
    return null;
  }
}
