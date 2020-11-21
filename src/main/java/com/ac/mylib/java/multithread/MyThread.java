package com.ac.mylib.java.multithread;

public class MyThread extends Thread {
  @Override
  public void run() {
    super.run();
    System.out.println("hello thread.");
  }

  public static void main(String[] args) {
    MyThread thread = new MyThread();
    thread.start();
    System.out.println("hello main");
  }
}
