package com.ac.mylib.controller;

import javax.swing.*;
import java.util.*;

public class Test implements SwingConstants {

private int name = CENTER;
  public static int[] twoSum(int[] nums, int target) {
    List<String> names = new ArrayList<>();
    List<String> name2 = new LinkedList<>();
    int[] retVal = new int[2];
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          retVal[0] = i;
          retVal[1] = j;
        }
      }
    }
    return retVal;
  }

  public static void test(){
    List<String> list1 = new ArrayList<>();
    list1.add("ada");
    list1.add("ben");
    list1.add("cat");
    list1.add("ada");
    System.out.println(list1.toString());

    List<String> list2 = new LinkedList<>();
    list2.add("ada");
    list2.add("ben");
    list2.add("cat");
    list2.add("ada");
  }

  static {
    for (int i = 0; i < 10; ++i) {
    }
  }

  static {
    for (int i = 0; i < 10; ++i) {
    }
  }

  public static void main(String[] args) {

    //    ApplicationContext context =
    //        new ClassPathXmlApplicationContext("classpath:applicationfile.xml");
    long ct01 = System.currentTimeMillis();
    List<String> list1 = new ArrayList<String>();
    list1.add("ada");
    list1.add("ben");
    list1.add("cat");
    list1.add("ada");
    ((ArrayList<String>) list1).trimToSize();
    long ct02 = System.currentTimeMillis();
    System.out.println(list1.size());
    System.out.println(list1.get(0));

    long ct11 = System.currentTimeMillis();
    List<String> list2 = new LinkedList<>();
    list2.add("ada");
    list2.add("ben");
//    list2.add("cat");
//    list2.add("ada");
    long ct12 = System.currentTimeMillis();
    System.out.println(ct12-ct11);
    Map<String,String> map = new HashMap<>();
//    list1.remove(list2);
    list1.addAll(list2);
    System.out.println(list1);
  }
}
