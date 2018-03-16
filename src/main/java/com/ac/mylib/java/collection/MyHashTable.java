package com.ac.mylib.java.collection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;

public class MyHashTable {
	// spring官方提供的log写法
    private final static Logger logger = LoggerFactory.getLogger(MyHashTable.class);
    
    private static final String NAME_AMY = "AMY";
	private static final String NAME_BOB = "BOB";
	private static final String NAME_CLERA = "CLERA";
	private static final String NAME_DOCK = "DOCK";
	private static final String NAME_ELLE = "ELLE";
	
	
	
	
	
	public static void main(String[] args) {
		String ford = "ford";
		String ford2 = "ford";
		String ford3 = new String("ford");
		String ford4 = new String("ford");
		
		List<String> names = new ArrayList<>();
		names.add(NAME_AMY);
		names.add(NAME_BOB);
		names.add(NAME_CLERA);
		names.add(NAME_DOCK);
		names.add(NAME_ELLE);
		for (String name : names) {
			System.out.println(name.hashCode());
		}
		System.out.println(ford==ford3);
		System.out.println(ford.equals(ford3));
		System.out.println(ford.hashCode());
		System.out.println(ford3.hashCode());
	}
    

}
