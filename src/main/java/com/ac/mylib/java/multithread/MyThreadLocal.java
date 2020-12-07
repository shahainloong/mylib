package com.ac.mylib.java.multithread;

import java.lang.reflect.Field;
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

  private static void test(String s,boolean isGC)  {
    try {
//      new ThreadLocal<>().set(s);
      ThreadLocal<Object> threadLocal = new ThreadLocal<>();
      threadLocal.set(s);
      if (isGC) {
        System.gc();
      }
      Thread t = Thread.currentThread();
      Class<? extends Thread> clz = t.getClass();
      Field field = clz.getDeclaredField("threadLocals");
      field.setAccessible(true);
      Object ThreadLocalMap = field.get(t);
      Class<?> tlmClass = ThreadLocalMap.getClass();
      Field tableField = tlmClass.getDeclaredField("table");
      tableField.setAccessible(true);
      Object[] arr = (Object[]) tableField.get(ThreadLocalMap);
      for (Object o : arr) {
        if (o != null) {
          Class<?> entryClass = o.getClass();
          Field valueField = entryClass.getDeclaredField("value");
          Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
          valueField.setAccessible(true);
          referenceField.setAccessible(true);
          System.out.println(String.format("弱引用key:%s,值:%s", referenceField.get(o), valueField.get(o)));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {
//    MyThreadLocal.add("一枝花算不算浪漫");
//    System.out.println(holder.get().messages);
//    MyThreadLocal.clear();

//    if (threadLocal.get() == null) {
//      System.out.println("Never set value");
//      threadLocal.set("My Value");
//    }
//    System.out.println(threadLocal.get());
//    System.out.println(threadLocal.get());

    Thread t = new Thread(()->test("abc",false));
    t.start();
    t.join();
    System.out.println("--gc后--");
    Thread t2 = new Thread(() -> test("def", true));
    t2.start();
    t2.join();
  }
  
}
