package com.ac.mylib.java.multithread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class MyAQS {
  private String id;
  private String nickName;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public static void main(String[] args) {

    AbstractQueuedSynchronizer abstractQueuedSynchronizer = new AbstractQueuedSynchronizer() {
      @Override
      public String toString() {
        return super.toString();
      }
    };
  }
}
