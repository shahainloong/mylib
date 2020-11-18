package com.ac.mylib.java.basic.proxy.dynamic;

import java.lang.reflect.Proxy;

import com.ac.mylib.java.basic.proxy.MySmsService;
import com.ac.mylib.java.basic.proxy.MySmsServiceImpl;
import com.google.common.base.Function;

/**
 * JDK 动态代理有一个最致命的问题是其只能代理实现了接口的类!
 */
public class JdkProxyFactory {
  public static Object getProxy(Object target) {
    return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
      new DebugInvocationHandler(target));
  }

  public static void main(String[] args) {
    MySmsService smsService = (MySmsService) JdkProxyFactory.getProxy(new MySmsServiceImpl());
    smsService.send("Hello Dynamic Java");
    // 使用java8的函数式接口来改写
    Function<Object, Object> objectObjectFunction = (Object target) -> {
      return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
        new DebugInvocationHandler(target));
    };
    MySmsService smsServiceProxy = (MySmsService) objectObjectFunction.apply(new MySmsServiceImpl());
    smsServiceProxy.send("Hey");
  }
}
