package com.ac.mylib.java.basic.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DebugInvocationHandler implements InvocationHandler {
  private final Object target;

  public DebugInvocationHandler(Object target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("Before method, the method name is:" + method.getName());
    Object result = method.invoke(target, args);
    System.out.println("After method, the method name is:" + method.getName());
    return result;
  }
}
