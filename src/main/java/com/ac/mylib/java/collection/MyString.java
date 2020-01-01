package com.ac.mylib.java.collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyString {
	private Integer id;
	private String name;
	private static final Logger LOGGER = LoggerFactory.getLogger(MyString.class);
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append(" hello ").append("world ").toString().trim();
		LOGGER.info("hello my first log : {}", sb);
		System.out.println(sb.append(" hello ").append("world ").toString().trim());
	}

}
