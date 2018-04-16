package com.ac.mylib.java.collection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
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

		HashMap<String, String> tvs = new HashMap<>();
		tvs.put(NAME_AMY, NAME_AMY);
		tvs.put(NAME_BOB, NAME_BOB);
		tvs.put(NAME_CLERA,NAME_CLERA);
		for (Entry<String, String> tv : tvs.entrySet()) {
			System.out.println(tv.getValue());
			System.out.println(tv.getKey());
		}
	}
    

}
