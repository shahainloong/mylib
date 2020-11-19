package com.ac.mylib.java.basic;

public enum MyPizzaStatus {
  ORDERED,
  READY,
  DELIVERD;

  public static void main(String[] args) {
    System.out.println(MyPizzaStatus.ORDERED);
    System.out.println(MyPizzaStatus.ORDERED.name());
    System.out.println(MyPizzaStatus.ORDERED.name().getClass());
    System.out.println(MyPizzaStatus.ORDERED.getClass());
  }
}
