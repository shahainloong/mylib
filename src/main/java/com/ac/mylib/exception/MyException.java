package com.ac.mylib.exception;

public class MyException extends RuntimeException {
  public static void main(String[] args) {
    //
    try {
      int a = 1;
      int b = 0;
      int c = a / b;
      System.out.println(c);
    } catch (Exception e) {
      //          e.printStackTrace();
      System.out.println(e.getMessage());
      if (e instanceof ArithmeticException) {
        System.out.println(e.getClass().getName());
      }
    }
  }
}
