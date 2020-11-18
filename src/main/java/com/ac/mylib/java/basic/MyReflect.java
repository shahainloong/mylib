package com.ac.mylib.java.basic;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.ac.mylib.spring4.Car;

/**
 * 获取 Class 对象的四种方式
 * 1. 知道具体类的情况下
 * Class alunbarClass = TargetObject.class;
 * 2. 通过 `Class.forName()`传入类的路径获取：
 * Class alunbarClass1 = Class.forName("com.ac.mylib.java.basic.MyReflect");
 * 3. 通过对象实例`instance.getClass()`获取
 * Employee e = new Employee();
 * Class alunbarClass2 = e.getClass();
 * 4. 通过类加载器`xxxClassLoader.loadClass()`传入类路径获取
 * class clazz = ClassLoader.LoadClass("com.ac.mylib.java.basic.MyReflect");
 */
public class MyReflect {
  private String value;

  public MyReflect() {
    value = "Hello ECHO";
  }

  public void publicMethod(String str) {
    System.out.println("Hello, " + str);
  }

  private void privateMethod() {
    System.out.println("value is:" + value);
  }

  Class car = Car.class;

  public static void main(String[] args)
    throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException,
    InvocationTargetException, NoSuchFieldException {
    Class<?> reflectClass = Class.forName("com.ac.mylib.java.basic.MyReflect");
    MyReflect reflectObject = (MyReflect) reflectClass.newInstance();

    /**
     * 获取所有类中所有定义的方法
     */
    Method[] declaredMethods = reflectClass.getDeclaredMethods();
    for (Method method : declaredMethods) {
      System.out.println(method.getName());
    }

    /**
     * 获取指定public方法并调用
     */
    Method publicMethod = reflectClass.getDeclaredMethod("publicMethod", String.class);
    publicMethod.invoke(reflectObject, "this is a public method.");

    Field field = reflectClass.getDeclaredField("value");
    // 为了对类中的参数进行修改我们取消安全检查
    field.setAccessible(true);
    field.set(reflectObject, "private value");

    /**
     * 获取指定private方法并调用
     */
    Method privateMethod = reflectClass.getDeclaredMethod("privateMethod");
    // 为了调用private方法我们取消安全检查
    privateMethod.setAccessible(true);
    privateMethod.invoke(reflectObject);

  }

}
