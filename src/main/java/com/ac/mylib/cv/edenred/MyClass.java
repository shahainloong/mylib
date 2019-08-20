package com.ac.mylib.cv.edenred;

public class MyClass {
    static private int myCount =0;
    int yourNumber;
    private static synchronized int nextCount(){
        return ++myCount;
    }
    public void getYourNumber(){
        yourNumber = nextCount();
    }
}
