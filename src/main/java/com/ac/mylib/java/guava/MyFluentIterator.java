package com.ac.mylib.java.guava;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

public class MyFluentIterator {
    public static void main(String[] args) {
        List<String> names = Lists.newArrayList("Ada","Bob","Cat");
        FluentIterable<String> stream = FluentIterable.from(names);
        ImmutableList<String> list = stream.filter(it -> "Bob".equals(it)).toList();
        stream.filter(it -> "Bob".equals(it)).toList().forEach(System.out::println);
    }
}
