package com.ac.mylib.java.guava;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

@Slf4j
public class MyImmutableCollections {

    public static void main(String[] args) {
        ImmutableList<Integer> list = ImmutableList.of(1, 2, 3);
        try {
            list.add(4);
        } catch (UnsupportedOperationException e) {
            log.info(e.getMessage());
        }
        System.out.println(list);
        ImmutableMap<String, String> map = ImmutableMap.<String, String>builder().put("Java", "1.8").put("Mysql", "7.0").build();
    }
}
