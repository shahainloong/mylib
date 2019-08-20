package com.ac.mylib.cv.edenred;

public class Test01 {
  public static void main(String[] args) {
    //
      Out o = new Out();
      new Out();

  }
}

class Out {
    static {
    System.out.println("I am a static block");
    }
    static {
    System.out.println("hello world");
    }
  public Out() {
    System.out.println("I am from inner class");
  }
}
