package com.ac.mylib.java.collection;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ac.mylib.util.CommonsUtil;

public class MyQueue {
	// spring官方提供的log写法
    private final static Logger logger = LoggerFactory.getLogger(MyQueue.class);
    
    private static final String NAME_AMY = "AMY";
	private static final String NAME_BOB = "BOB";
	private static final String NAME_CLERA = "CLERA";
	private static final String NAME_DOCK = "DOCK";
	private static final String NAME_ELLE = "ELLE";
	
	
	public static void main(String[] args) {
		String namePeek = null;
		// 需要一个循环数组队列，使用ArrayDeque类，ArrayDeque是一种循环数组实现的双端队列
		Queue<String> namesArrayDeque = new ArrayDeque<>();
		namesArrayDeque.add(MyQueue.NAME_AMY);
		namesArrayDeque.add(MyQueue.NAME_BOB);
		namesArrayDeque.add(MyQueue.NAME_CLERA);
		namesArrayDeque.add(MyQueue.NAME_DOCK);
		namesArrayDeque.add(MyQueue.NAME_ELLE);
		System.out.println(namesArrayDeque);
		
		// 需要一个链表队列，使用LinkedList类，LinkedList是一种可以在任何位置进行高效插入和删除操作的有序序列
		Queue<String> namesLinkedList = new LinkedList<>();
		namesLinkedList.add(MyQueue.NAME_AMY);
		namesLinkedList.add(MyQueue.NAME_BOB);
		namesLinkedList.add(MyQueue.NAME_CLERA);
		namesLinkedList.add(MyQueue.NAME_DOCK);
		namesLinkedList.add(MyQueue.NAME_ELLE);
		// poll()会删除队头的数据AMY，余下的是以BOB开头的四个数据
		namesLinkedList.poll();
		// peek()会得到队列头部的数据
		namePeek = namesLinkedList.peek();

		System.out.println(namePeek);
		
	}
	
}
