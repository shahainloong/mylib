package com.ac.mylib.java.guava;

import com.google.common.collect.HashBasedTable;

import java.util.Map;

public class MyTable {
    public static void main(String[] args) {
        HashBasedTable<Object, Object, Object> table = HashBasedTable.create();
        table.put("Language", "Java", "1.8");
        table.put("Language", "Scala", "2.3");
        table.put("Database", "Mysql", "7.0");
        System.out.println(table);
        Map<Object, Object> row = table.row("Language");
        System.out.println(row);
    }
}
