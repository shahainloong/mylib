package com.ac.mylib.java.jvm;

public class Singleton {
    private static Singleton ourInstance = new Singleton();
    private static int count1;
    private static int count2 = 0;

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
        count1++;
        count2++;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("count1 is:" + count1);
        System.out.println("count2 is:" + count2);
    }
}
