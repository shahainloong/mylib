package com.ac.mylib.java.java8;

import com.ac.mylib.java.guava.MyStopWatch;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Hello {
    private static final Logger logger = LoggerFactory.getLogger(Hello.class);
    public static void main(String[] args) {
//        List<String> names = Lists.newArrayListWithCapacity(16);
//        names.add("Ada");
//        names.add("Bob");
//        names.add("Cat");
//        System.out.println(names.toString());
//
//        Runnable runnable = () -> System.out.println("hello world");
//        runnable.run();
//        List<String> collect = names.stream().filter(it -> "Ada".equals(it)).collect(toList());
//        names.stream().filter(it -> !"Ada".equals(it)).forEach(System.out::println);
//
//        System.out.println(collect);
//        String domain = "null";
//        boolean hello = domain.contains("hello");
//        System.out.println(hello);
//
//        String name = "rjvjci.bss.net.sap";
//        if (name.contains("rjvjci.bss.net.sap")) {
//            System.out.println("hello");
//        }
//        String localName = "request.getLocalName().toLowerCase()";
//        if (localName.contains("rjvjci.bss.net.sap") || localName.contains("spwdfvml2764.bss.net.sap") || localName.contains("rjxjci.bss.net.sap") || localName.contains("spwdfvml2782.bss.net.sap")) {
//
//        }


        Stopwatch stopwatch = Stopwatch.createStarted();
//        try {
            Shop shop = new Shop();
            String prefix = "Hello, ";
            Future<Double> price = shop.getPriceAsyncBySupplyAsync("hello world");
            
//            System.out.println(price.get(1000, TimeUnit.SECONDS));
//            logger.info(prefix + price.get().toString());
            logger.info("It takes about {} minites.", stopwatch.stop());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }
    }
}
