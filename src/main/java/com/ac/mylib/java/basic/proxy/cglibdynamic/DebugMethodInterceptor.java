package com.ac.mylib.java.basic.proxy.cglibdynamic;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * <p>在 CGLIB 动态代理机制中 `MethodInterceptor` 接口和 `Enhancer` 类是核心</p>
 * <pre>
 * 2. 自定义{@link net.sf.cglib.proxy.MethodInterceptor MethodInterceptor}并重写{@link net.sf.cglib.proxy.MethodInterceptor#intercept intercept}方法，
 *    intercept用于拦截增强被代理类的方法，和JDK动态代理中的{@link java.lang.reflect.InvocationHandler#invoke invoke}方法类似；
 * </pre>
 *
 * @see net.sf.cglib.proxy.MethodInterceptor
 * @see java.lang.reflect.InvocationHandler#invoke
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
