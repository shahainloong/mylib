package com.ac.mylib.util;

public class JVMUtil {
  public static String getMemoryInfo() {
    Runtime runtime = Runtime.getRuntime();
    int freeMemory = (int) (runtime.freeMemory() / 1024 / 1024);
    int totalMemory = (int) (runtime.totalMemory() / 1024 / 1024);
    return "Memery info :" + freeMemory + "M/" + totalMemory + "M(free/total)";
  }

  private JVMUtil() {
  }
}
