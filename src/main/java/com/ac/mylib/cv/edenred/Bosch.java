package com.ac.mylib.cv.edenred;

class A{
    static {
    System.out.println("a");
    }

  public static void main(String[] args) {
    //
    System.out.println("b");
  }
}

class B extends A{
    static {
    System.out.println("c");
    }

  public static void main(String[] args) {
    //
    System.out.println("d");
  }
}

public class Bosch {
  public static void main(String[] args) {
    //
      A ab = new B();
      ab=new B();
  }
}
