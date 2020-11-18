package com.ac.mylib.java.basic.proxy.statical;

import com.ac.mylib.java.basic.proxy.MySmsService;
import com.ac.mylib.java.basic.proxy.MySmsServiceImpl;

/**
 * 静态代理需要针对每个目标类都单独创建一个代理类.
 * <p>静态代理实现步骤:</p>
 * <pre>
 * 1. 定义一个接口及其实现类；
 * 2. 创建一个代理类同样实现这个接口
 * 3. 将目标对象注入进代理类，然后在代理类的对应方法调用目标类中的对应方法。这样的话，我们就可以通过代理类屏蔽对目标对象的访问，并且可以在目标方法执行前后做一些自己想做的事情。
 * </pre>
 *
 * @see com.ac.mylib.java.basic.proxy.MySmsService
 */
public class MySmsProxy implements MySmsService {
  private final MySmsService smsService;

  // 3.1 将目标对象注入进代理类
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
    // 3.1 将目标对象注入进代理类
    MySmsProxy smsProxy = new MySmsProxy(smsService);
    // 3.2 然后在代理类的对应方法调用目标类中的对应方法
    smsProxy.send("Hello, Static Proxy");
  }
}
