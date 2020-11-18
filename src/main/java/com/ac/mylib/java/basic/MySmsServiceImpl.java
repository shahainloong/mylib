package com.ac.mylib.java.basic;

public class MySmsServiceImpl implements MySmsService {
  @Override
  public String send(String message) {
    System.out.println("Send message:" + message);
    return message;
  }
}
