package com.ac.mylib.java.basic.proxy.jdkdynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>JDK 动态代理类</p>
 * 2. 自定义{@link InvocationHandler InvocationHandler}并重写{@link InvocationHandler#invoke invoke}方法，在{@link InvocationHandler#invoke invoke}方法中我们会调用原生方法（被代理类的方法）并自定义一些处理逻辑；
 *
 * @see java.lang.reflect.InvocationHandler#invoke
 */
public class DebugInvocationHandler implements InvocationHandler {
  /**
   * 代理类中的真实对象，也就是被代理的类，非代理类
   */
  private final Object target;

  public DebugInvocationHandler(Object target) {
    this.target = target;
  }

  /**
   * 当我们的动态代理对象调用原生方法的时候，最终实际上调用到的是 `invoke()` 方法，然后 `invoke()` 方法代替我们去调用了被代理对象的原生方法。
   *
   * @param proxy  动态生成的代理类
   * @param method 与代理类对象调用的方法相对应的方法
   * @param args   当前method方法的参数
   * @return
   * @throws Throwable
   */
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("Before method, the method name is:" + method.getName());
    Object result = method.invoke(target, args);
    System.out.println("After method, the method name is:" + method.getName());
    return result;
  }
}
