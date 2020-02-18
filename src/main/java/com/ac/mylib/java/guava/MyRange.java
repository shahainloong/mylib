package com.ac.mylib.java.guava;

import com.google.common.collect.Maps;
import com.google.common.collect.Range;

public class MyRange
{
    public static void main(String[] args) {
        Range<Integer> range = Range.openClosed(0, 10);
        System.out.println(range);

        Maps.newHashMapWithExpectedSize(16);

    }
}
