package com.ac.mylib.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Hello {
  public static List<String> addList(List<String> a, List<String> b) {
    List<String> temp = a;
    temp.add("temp");
    System.out.println("a is :" + a);
    System.out.println("temp is :" + temp);
    return a;
  }
    public static String add(String a, String b) {
        String temp = a;
        temp = "temp";
        System.out.println("a is :" + a);
        System.out.println("temp is :" + temp);
        return a + b;
    }

  public static void main(String[] args) {
    //
      List<String> a = new ArrayList<>();
      a.add("a");
      List<String> b = new ArrayList<>();
      b.add("b");

    List<String> value = addList(a, b);
    String str = add("a","b");
    System.out.println(value);
    System.out.println(str);
  }
}
