package com.ac.mylib.java.others;

import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpPost;

import java.net.MalformedURLException;
import java.net.URL;
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

	public static void main(String[] args) throws MalformedURLException {

		Set<String> tokens = new HashSet<>(16);
		tokens.add("xyz");
		tokens.add("abc");
		tokens.add("opq");
		System.out.println(Objects.nonNull("xyz") && tokens.contains("xyz"));
//		System.out.println(tokens);
		String str = "<p><img src=\"\" onerror=\"alert(4)\"></p>";
		System.out.println(str.contains("onerror=\"alert"));
		System.out.println(":");

		URL url = new URL("https://accounts.sap.com/service/users/password");
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getProtocol());
		System.out.println(url.getPath());
		HttpHost target = new HttpHost(url.getHost(), url.getPort(), url.getProtocol());
		HttpPost httppost = new HttpPost(url.getPath());


	}

	

}
