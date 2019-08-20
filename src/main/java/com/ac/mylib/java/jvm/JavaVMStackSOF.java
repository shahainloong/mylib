package com.ac.mylib.java.jvm;

/**
 * 使用-Xss参数减少栈内存容量
 * VM args: -Xss128k
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Exception e) {
            System.out.println("javaVMStackSOF.stackLength is :" + javaVMStackSOF.stackLength);
//            e.printStackTrace();
            throw e;
        }
    }
}
