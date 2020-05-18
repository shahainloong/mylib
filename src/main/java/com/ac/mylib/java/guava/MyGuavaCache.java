package com.ac.mylib.java.guava;

import com.ac.mylib.dao.UserDao;
import com.ac.mylib.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyGuavaCache  {

    @Autowired
    private static UserDao userDao;

    public static void main(String[] args) {

    }
}
