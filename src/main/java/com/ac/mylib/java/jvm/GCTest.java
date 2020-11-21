package com.ac.mylib.java.jvm;

public class GCTest {
  public static void main(String[] args) {
    byte[] allocation1, allocation2;
    allocation1 = new byte[30960 * 1024];
    allocation2 = new byte[900*1024];
  }
}
