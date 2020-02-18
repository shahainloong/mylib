package com.ac.mylib.java.java8;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Hello {
    public static void main(String[] args) {
        List<String> names = Lists.newArrayListWithCapacity(16);
        names.add("Ada");
        names.add("Bob");
        names.add("Cat");
        System.out.println(names.toString());

        Runnable runnable = () -> System.out.println("hello world");
        runnable.run();
        List<String> collect = names.stream().filter(it -> "Ada".equals(it)).collect(toList());
        names.stream().filter(it -> !"Ada".equals(it)).forEach(System.out::println);

        System.out.println(collect);
    }
}
