package com.ac.mylib.java.collection;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyHashSet {
	// spring官方提供的log写法
    private final static Logger logger = LoggerFactory.getLogger(MyHashSet.class);
    
    private static final String NAME_AMY = "AMY";
	private static final String NAME_BOB = "BOB";
	private static final String NAME_CLERA = "CLERA";
	private static final String NAME_DOCK = "DOCK";
	private static final String NAME_ELLE = "ELLE";
	
	public static void main(String[] args) {

		String Lee = "Lee";
		String lee = "lee";
		String eel = "eel";
		System.out.println(Lee.hashCode());
		System.out.println(lee.hashCode());
		System.out.println(eel.hashCode());
		
		Set<String> staff = new HashSet<>();
		staff.add(MyHashSet.NAME_AMY);
		staff.add(MyHashSet.NAME_BOB);
		staff.add(MyHashSet.NAME_CLERA);
		staff.add(MyHashSet.NAME_DOCK);
		staff.add(MyHashSet.NAME_ELLE);
		System.out.println(staff);
		
		
	}
    

}
