package com.ac.mylib.controller;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test2 {
  public static void main(String[] args) {
    //
      Lock lock = new ReentrantLock();
    int nine = 2_000;
    String id;
    String name = String.join(",", "hello", "world");
    System.out.println(name);
    long sleepTime = 1000;
    Runnable runnable =
        () -> {
          for (int i = 90; i < 100; i++) {
            //
            System.out.println(i);
          }
        };
    Runnable sleep =
        () -> {
          for (int i = 0; i < 10; i++) {
            //
            System.out.println(i);
            try {
              Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        };
    Thread thread = new Thread(runnable);
    Thread sleepThread = new Thread(sleep);
    Thread third =
        new Thread(
            () -> {
              for (int i = 10; i < 20; i++) {
                System.out.println(i);
              }
            });
    third.start();
    thread.start();
    sleepThread.start();

  }
}
