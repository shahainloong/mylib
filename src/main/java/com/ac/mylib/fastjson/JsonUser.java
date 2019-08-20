package com.ac.mylib.fastjson;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @Description 这是我自己用来测试alibaba的fastjson的User类
 * @Author Created by Echo on 2018/04/24
 */
public class JsonUser implements Serializable {

	/**
	 * @Fields serialVersionUID : -8366740939489378414L
	 */
	private static final long serialVersionUID = -8366740939489378414L;

	/**
	 * 注意：1、若属性是私有的，必须有set*方法。否则无法反序列化。
	 * 2、必须配置在getter/setter两个方法上，否则json的key不是指定的name，比如@JSONField(name="ID")就是小写的id
	 */
	private Integer id;

	@JSONField(name = "name", ordinal = 2)
	private String name;

	@JSONField(name = "date", format = "yyyy/MM/dd", ordinal = 3)
	private String date;

	@JSONField(name = "id", ordinal = 1)
	public Integer getId() {
		return id;
	}

	@JSONField(name = "id", ordinal = 1)
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public JsonUser() {
		super();
	}

	public JsonUser(Integer id, String name, String date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}

}
