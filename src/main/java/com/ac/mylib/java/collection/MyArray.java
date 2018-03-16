package com.ac.mylib.java.collection;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyArray {
	private static final String NAME_AMY = "AMY";
	private static final String NAME_Bob = "BOB";
	private static final String NAME_CLERA = "CLERA";
	
	public static void main(String[] args) {
		
		Queue<String> names = new ArrayDeque<>();
		names.add(NAME_AMY);
		names.add(NAME_Bob);
		names.add(NAME_CLERA);
		names.add("Docker");
		names.poll();
		System.out.println(names);
	}

}
