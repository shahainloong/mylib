package com.ac.mylib.java.guava;

import com.google.common.base.*;

import java.util.ArrayList;

public class GuavaTester {
	   public static void main(String args[]){
		   final long startTime = System.nanoTime();
		   GuavaTester guavaTester = new GuavaTester();

	      Integer value1 =  null;
	      Integer value2 =  new Integer(10);
	      //Optional.fromNullable - allows passed parameter to be null.
	      Optional<Integer> a = Optional.fromNullable(value1);
	      //Optional.of - throws NullPointerException if passed parameter is null
	      Optional<Integer> b = Optional.of(value2);		

	      System.out.println(guavaTester.sum(a,b));

		   ArrayList<String> list = new ArrayList<>();
		   Runnable runnable = () -> System.out.println("hello");
		   String s = Functions.toStringFunction().apply("hello".length());
		   System.out.println(s);
		   Function<String, Integer> function = (String it) -> it.length();
		   System.out.println(function.apply("hello"));
		   final long endTime = System.nanoTime();
		   System.out.println("The total time is: " + (endTime - startTime));
	   }

	   public Integer sum(Optional<Integer> a, Optional<Integer> b){
	      //Optional.isPresent - checks the value is present or not
	      System.out.println("First parameter is present: " + a.isPresent());

	      System.out.println("Second parameter is present: " + b.isPresent());

	      //Optional.or - returns the value if present otherwise returns
	      //the default value passed.
	      Integer value1 = a.or(new Integer(0));	

	      //Optional.get - gets the value, value should be present
	      Integer value2 = b.get();

	      return value1 + value2;
	   }	
	}