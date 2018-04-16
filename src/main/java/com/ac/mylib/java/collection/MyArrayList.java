package com.ac.mylib.java.collection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyArrayList {
	// spring官方提供的log写法
    private final static Logger logger = LoggerFactory.getLogger(MyHashSet.class);

	private static final String NAME_AMY = "AMY";
	private static final String NAME_BOB = "BOB";
	private static final String NAME_CLERA = "CLERA";
	private static final String NAME_DOCK = "DOCK";
	private static final String NAME_ELLE = "ELLE";
	
	public static void main(String[] args) {

		List<String> names = new ArrayList<>();
		names.add(MyArrayList.NAME_AMY);
		names.add(MyArrayList.NAME_BOB);
		names.add(MyArrayList.NAME_CLERA);
		names.add(MyArrayList.NAME_DOCK);
		names.add(MyArrayList.NAME_ELLE);
		System.out.println(names.toString());
		
		String obj = names.get(0);
		System.out.println(obj);

	}

}
