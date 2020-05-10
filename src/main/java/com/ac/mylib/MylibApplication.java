package com.ac.mylib;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ac.mylib.dao")
public class MylibApplication {

	public static void main(String[] args) {
		SpringApplication.run(MylibApplication.class, args);
	}
}
