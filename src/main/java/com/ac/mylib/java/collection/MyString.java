package com.ac.mylib.java.collection;

public class MyString {
	private Integer id;
	private String name;
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		System.out.println(sb.append(" hello ").append("world ").toString().trim());
	}

}
