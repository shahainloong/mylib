package com.ac.mylib.java.others;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LoginInfo {
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public static void main(String[] args) {

		Set<String> tokens = new HashSet<>(16);
		tokens.add("xyz");
		tokens.add("abc");
		tokens.add("opq");
		System.out.println(Objects.nonNull("xyz") && tokens.contains("xyz"));
//		System.out.println(tokens);
		String str = "<p><img src=\"\" onerror=\"alert(4)\"></p>";
		System.out.println(str.contains("onerror=\"alert"));
		System.out.println(":");


	}

	

}
