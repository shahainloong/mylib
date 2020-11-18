package com.ac.mylib.java.basic.proxy.jdkdynamic;

import java.lang.reflect.Proxy;

import com.ac.mylib.java.basic.proxy.MySmsService;
import com.ac.mylib.java.basic.proxy.MySmsServiceImpl;
import com.google.common.base.Function;

/**
 * 这个是获取代理对象的工厂类
 * JDK 动态代理类使用步骤
 * 1. 定义一个接口及其实现类；
 * 2. 自定义 `InvocationHandler` 并重写`invoke`方法，在 `invoke` 方法中我们会调用原生方法（被代理类的方法）并自定义一些处理逻辑；
 * 3. 通过 `Proxy.newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)` 方法创建代理对象；
 * JDK 动态代理有一个最致命的问题是其只能代理实现了接口的类!
 */
public class JdkProxyFactory {
  /**
   * 主要通过`Proxy.newProxyInstance（）`方法获取某个类的代理对象
   * @param target
   * @return
   */
  public static Object getProxy(Object target) {
    return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
      new DebugInvocationHandler(target));
  }

  public static void main(String[] args) {
    MySmsService smsService = (MySmsService) JdkProxyFactory.getProxy(new MySmsServiceImpl());
    smsService.send("Hello, JDK Dynamic Proxy.");

    // 使用java8的函数式接口来改写
    Function<Object, Object> proxyObject = (Object target) -> {
      return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
        new DebugInvocationHandler(target));
    };
    MySmsService smsServiceProxy = (MySmsService) proxyObject.apply(new MySmsServiceImpl());
    smsServiceProxy.send("Hello, JDK Dynamic Proxy With Java 8");
  }
}
