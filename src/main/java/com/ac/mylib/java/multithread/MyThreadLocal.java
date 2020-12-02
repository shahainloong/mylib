package com.ac.mylib.java.multithread;

import java.util.List;

import com.google.common.collect.Lists;

public class MyThreadLocal {
  private List<String> messages = Lists.newArrayList();

  public static final ThreadLocal<MyThreadLocal> holder = ThreadLocal.withInitial(MyThreadLocal::new);
  public static ThreadLocal threadLocal = new ThreadLocal();

  public static void add(String message) {
    holder.get().messages.add(message);
  }

  public static List<String> clear() {
    List<String> messages = holder.get().messages;
    holder.remove();

    System.out.println("size: " + holder.get().messages.size());
    return messages;
  }

  public static void main(String[] args) {
//    MyThreadLocal.add("一枝花算不算浪漫");
//    System.out.println(holder.get().messages);
//    MyThreadLocal.clear();
    if (threadLocal.get() == null) {
      System.out.println("Never set value");
      threadLocal.set("My Value");
    }
    System.out.println(threadLocal.get());
    System.out.println(threadLocal.get());
  }
  
}
