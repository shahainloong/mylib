package com.ac.mylib.java.guava;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicates;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class MyFunctionalProgram {
    public static void main(String[] args) {

        Predicate<String> length = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 0;
            }
        };
        Predicate<String> len = it -> it.length() > 0;
        com.google.common.base.Predicate<String> googleLength = new com.google.common.base.Predicate<String>() {
            @Override
            public boolean apply(@Nullable String s) {
                return s.length() > 0;
            }
        };

        com.google.common.base.Predicate<String> googleLen = it -> it.length() > 0;
        Function<String, String> functions = new Function<String, String>() {
            @Nullable
            @Override
            public String apply(@Nullable String s) {
                return "Hello " + s;
            }
        };
    }
}
