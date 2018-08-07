package com.ac.mylib.java.collection;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

import org.hibernate.engine.transaction.jta.platform.internal.BorlandEnterpriseServerJtaPlatform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyLinkedList {
	// spring官方提供的log写法
    private static final Logger logger = LoggerFactory.getLogger(MyQueue.class);
    
	private static final String NAME_AMY = "AMY";
	private static final String NAME_BOB = "BOB";
	private static final String NAME_CLERA = "CLERA";
	private static final String NAME_DOCK = "DOCK";
	private static final String NAME_ELLE = "ELLE";
	private static final String NAME_JULIET = "JULIET";
	
	public static void main(String[] args) {
		
		List<String> staff = new LinkedList<>();
		staff.add(MyLinkedList.NAME_AMY);
		staff.add(MyLinkedList.NAME_BOB);
		staff.add(MyLinkedList.NAME_CLERA);
		staff.add(MyLinkedList.NAME_DOCK);
		staff.add(MyLinkedList.NAME_ELLE);
		
		Iterator<String> iterator = staff.iterator();
		String first = iterator.next();
		String second = iterator.next();
		System.out.println("first element is : " + first);
		System.out.println("second element is : " + second);
		
		ListIterator<String> listIterator = staff.listIterator();
		listIterator.next();
		listIterator.add(MyLinkedList.NAME_JULIET);
		System.out.println(staff);
		
		// 。get(index)很花时间，不要使用
		String obj = staff.get(1);
		System.out.println(obj);
		logger.info("end info");
	}

}
