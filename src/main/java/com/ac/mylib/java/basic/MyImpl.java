package com.ac.mylib.java.basic;

import java.util.ArrayList;
import java.util.List;

public class MyImpl implements MyInterface {

  public static final String HELLO = "Hello";

  private final int i;

  public MyImpl() {
    i = 0;
  }

  @Override
  public List<String> getName(List<String> name) {
    List<String> names = new ArrayList<>();
    names.add("hello");
    names.add("world");
    return name.subList(i, 1);
  }

  public String getItem(int item, String name, boolean flag) {
    return getItem(item, name);
  }

  public String getItem(int item, String name) {
    return getItem(item, true);
  }

  public String getItem(int item, boolean state){
    return "";
  }

  public String getItems(){
    return getItem(100, "Hello", true);
  }

  public String getName(String index){
    String value = null;
    value = getString(index, value);
    return value;
  }

  private String getString(String index, String value) {
    boolean flag = index.length() >= 6;
    if (flag) {
      value = "six";
    }
    if (HELLO.equals(index)) {
      value = "Hello";
    }
    return value;
  }
}
