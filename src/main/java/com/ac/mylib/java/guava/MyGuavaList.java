package com.ac.mylib.java.guava;

import com.google.common.collect.Lists;

import java.util.List;

public class MyGuavaList {
    public static void main(String[] args) {
        List<String> names = Lists.newArrayList();
        names.add("Ada");
        names.add("Bob");
        names.add("Chris");
        names.forEach(System.out::println);
    }
}
