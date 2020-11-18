package com.ac.mylib.java.basic.proxy.statical;

import com.ac.mylib.java.basic.proxy.MySmsService;
import com.ac.mylib.java.basic.proxy.MySmsServiceImpl;

/**
 * 静态代理
 */
public class MySmsProxy implements MySmsService {
  private final MySmsService smsService;

  public MySmsProxy(MySmsService smsService) {
    this.smsService = smsService;
  }

  @Override
  public String send(String message) {
    // This is a method before sending message
    System.out.println("Before method send()");
    smsService.send(message);
    System.out.println("After method send()");
    return null;
  }

  public static void main(String[] args) {
    MySmsService smsService = new MySmsServiceImpl();
    MySmsProxy smsProxy = new MySmsProxy(smsService);
    smsProxy.send("Hello JAVA");

  }
}
