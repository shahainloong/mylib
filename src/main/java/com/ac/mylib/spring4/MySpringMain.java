package com.ac.mylib.spring4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringMain {

    public static void main(String[] args) throws ClassNotFoundException {

    ClassLoader loader = Thread.currentThread().getContextClassLoader();
    Class clazz = loader.loadClass("com.ac.mylib.spring4.Car");

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"conf/bean.xml"});
    }
}

