package com.ac.mylib.java.basic.proxy.cglibdynamic;

import net.sf.cglib.proxy.Enhancer;

/**
 * [CGLIB](https://github.com/cglib/cglib)(Code Generation Library)是一个基于[ASM](http://www.baeldung.com/java-asm)的字节码生成库，它允许我们在运行时对字节码进行修改和动态生成。
 * CGLIB 通过继承方式实现代理。
 * 很多知名的开源框架都使用到了[CGLIB](https://github.com/cglib/cglib)， 例如 Spring 中的 AOP 模块中.
 * 注意：如果目标对象实现了接口，则默认采用 JDK 动态代理，否则采用 CGLIB 动态代理。
 * 在 CGLIB 动态代理机制中 `MethodInterceptor` 接口和 `Enhancer` 类是核心
 * <p>CGLIB 动态代理类使用步骤</p>
 * 1. 定义一个类；
 * 2. 自定义 `MethodInterceptor` 并重写 `intercept` 方法，`intercept` 用于拦截增强被代理类的方法，和 JDK 动态代理中的 `invoke` 方法类似；
 * 3. 通过 `Enhancer` 类的 `create()`创建代理类；
 */
public class CglibProxyFactory {
  public static Object getProxy(Class<?> clazz) {
    // 创建动态代理增强类，通过 `Enhancer`类来动态获取被代理类，当代理类调用方法的时候，实际调用的是 `MethodInterceptor` 中的 `intercept` 方法
    Enhancer enhancer = new Enhancer();
    // 设置类加载器
    enhancer.setClassLoader(clazz.getClassLoader());
    // 设置被代理类
    enhancer.setSuperclass(clazz);
    // 设置方法拦截器
    enhancer.setCallback(new DebugMethodInterceptor());
    // 创建代理类
    return enhancer.create();
  }

  public static void main(String[] args) {
    AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
    aliSmsService.send("Hello Ali");
  }
}
