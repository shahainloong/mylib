package com.ac.mylib.fastjson;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ac.mylib.domain.User;
import com.ac.mylib.util.CommonsUtil;
import com.ac.mylib.util.DateUtil;
import com.alibaba.fastjson.JSON;

public class MyJson {
	
	// spring官方提供的log写法
	private static final Logger logger = LoggerFactory.getLogger(MyJson.class);
	
	public static final Integer ID = 101;
	public static final String NAME = "Echo";
	public static final String DATE = DateUtil.dateExchange("2018-04-22");
	public static final String PASSWORD = "123456";
	public static final String NICKNAME = "echo";
	public static final Integer AGE = 18;
	public static final String PHONENUMBER = "12345678901";
	public static final String EMAILADDRESS = "echo@qq.com";
	
	
	public static void main(String[] args) {
		JsonUser user = new JsonUser(MyJson.ID, MyJson.NAME, MyJson.DATE);

		String json = JSON.toJSONString(user);
		logger.info(json);
	}
}
