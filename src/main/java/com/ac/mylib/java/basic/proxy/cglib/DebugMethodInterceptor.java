package com.ac.mylib.java.basic.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class DebugMethodInterceptor implements MethodInterceptor {
  /**
   *
   * @param o            被代理的对象（需要增强的对象）
   * @param method       被拦截的方法（需要增强的方法）
   * @param objects      方法入参
   * @param methodProxy  用于调用原始方法
   * @return
   * @throws Throwable
   */
  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
    //
    System.out.println("Before method, the method name is:" + method.getName());
    Object object = methodProxy.invokeSuper(o, objects);
    System.out.println("After method, the method name is:" + method.getName());
    return null;
  }
}
