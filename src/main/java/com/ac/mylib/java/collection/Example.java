package com.ac.mylib.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ac.mylib.domain.Daletou;

public class Example {

	public static void main(String [] args) 
    {
		Daletou daletou = new Daletou();
		daletou.setNumberId("18029");
		List<String> frontFiveNumber = new ArrayList<>();
		frontFiveNumber.add("02");
		frontFiveNumber.add("04");
		frontFiveNumber.add("12");
		frontFiveNumber.add("18");
		frontFiveNumber.add("26");
		List<String> backTwoNumber = new ArrayList<>();
		backTwoNumber.add("02");
		backTwoNumber.add("04");
		daletou.setFrontFiveNumber(frontFiveNumber);
		daletou.setBackTwoNumber(backTwoNumber);
		System.out.println(daletou.toString());
		int no = 123;
		String s = String.valueOf(no);
		System.out.println(String.valueOf(no));
		System.out.println(s.length());
		String value = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			value += s.charAt(i);
		}
		System.out.println(value);
		System.out.println(Collections.reverseOrder());
    }
}
