package com.ac.mylib.java.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyString {
//	private Integer id;
	private  static String name = "hello";
	public static void main(String[] args) {
//		StringBuilder sb = new StringBuilder();
//		sb.append(" hello ").append("world ").toString().trim();
//		System.out.println(sb.append(" hello ").append("world ").toString().trim());
//		System.out.println(name);
		String s1 = new String("计算机");
		String s2 = s1.intern();
		String s3 = "计算机";
		System.out.println(s2);//计算机
		System.out.println(s1 == s2);//false，因为一个是堆内存中的 String 对象一个是常量池中的 String 对象，
		System.out.println(s3 == s2);//true，因为两个都是常量池中的 String 对象

		String str1 = "str";
		String str2 = "ing";

		String str3 = "str" + "ing";//常量池中的对象
		String str4 = str1 + str2; //在堆上创建的新的对象
		String str5 = "string";//常量池中的对象
		System.out.println(str3 == str4);//false
		System.out.println(str3 == str5);//true
		System.out.println(str4 == str5);//false

		Integer i1 = 33;
		Integer i2 = 33;
		System.out.println(i1 == i2);// 输出 true
		Integer i11 = 333;
		Integer i22 = 333;
		System.out.println(i11 == i22);// 输出 false
		Double i3 = 1.2;
		Double i4 = 1.2;
		System.out.println(i3 == i4);// 输出 false
	}

}
