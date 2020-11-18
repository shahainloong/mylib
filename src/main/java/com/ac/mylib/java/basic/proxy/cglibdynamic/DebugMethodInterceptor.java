package com.ac.mylib.java.basic.proxy.cglibdynamic;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 在 CGLIB 动态代理机制中 `MethodInterceptor` 接口和 `Enhancer` 类是核心
 * 2. 自定义 `MethodInterceptor` 并重写 `intercept` 方法，`intercept` 用于拦截增强被代理类的方法，和 JDK 动态代理中的 `invoke` 方法类似；
 */
public class DebugMethodInterceptor implements MethodInterceptor {
  /**
   * 拦截被代理类中的方法
   *
   * @param o           被代理的对象（需要增强的对象）
   * @param method      被拦截的方法（需要增强的方法）
   * @param objects     方法入参
   * @param methodProxy 用于调用原始方法
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
