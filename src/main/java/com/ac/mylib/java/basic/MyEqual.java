package com.ac.mylib.java.basic;

import com.ac.mylib.spring4.Car;

public class MyEqual {
  public static void main(String[] args) {
    int one = 1;
    int two = 1;
    Car car1 = new Car();
    Car car2 = new Car();
    Car car1_1 = car1;
    Car car1_11 = car1;
    System.out.println(car1.equals(car1_1));
    System.out.println(car1.equals(car1_11));
    car1.setBrand("Ford");
    car2.setBrand("Ford");
    System.out.println(car1_1.getBrand());
    System.out.println(car1_11.getBrand());
    System.out.println(car1.hashCode());
    System.out.println(car2.hashCode());

    String a = "a";
    String b = "a";

    System.out.println(one == two); // true

    System.out.println(car1.equals(car2)); // false
    System.out.println(car1 == car2); // false
    System.out.println(a.equals(b)); // true
  }
}
