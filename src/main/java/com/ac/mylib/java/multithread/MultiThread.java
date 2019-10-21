package com.ac.mylib.java.multithread;

import com.ac.mylib.util.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@Slf4j
public class MultiThread {
    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            System.out.println("--This is Runnable1--");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("--This is Runnable2--");
        });
        Thread thread3 = new Thread(() -> {
            System.out.println("--This is Runnable3--");
        });
        Thread thread4 = new Thread(() -> {
            System.out.println("--This is Runnable4--");
        }, "name4");

        Callable<String> callable = () -> "hello world";
        try {
            String value = callable.call();
            log.info(value);
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("System Date is:" + DateUtil.getSysDate());
        thread1.start();
        log.info("thread1 start");
        thread2.start();
        log.info("");
        thread3.start();
        log.info("");
        thread4.start();
        log.info("");
    }
}
