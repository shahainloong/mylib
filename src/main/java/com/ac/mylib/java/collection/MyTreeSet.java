package com.ac.mylib.java.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTreeSet {
	// spring官方提供的log写法
    private final static Logger logger = LoggerFactory.getLogger(MyTreeSet.class);
    
    private static final String NAME_AMY = "AMY";
	private static final String NAME_BOB = "BOB";
	private static final String NAME_CLERA = "CLERA";
	private static final String NAME_DOCK = "DOCK";
	private static final String NAME_ELLE = "ELLE";
	
	public static void main(String[] args) {

		SortedSet<String> staff = new TreeSet<>();
		staff.add(MyTreeSet.NAME_ELLE);
		staff.add(MyTreeSet.NAME_BOB);
		staff.add(MyTreeSet.NAME_CLERA);
		staff.add(MyTreeSet.NAME_AMY);
		staff.add(MyTreeSet.NAME_DOCK);
		System.out.println(staff);
		
		
	}
    

}
