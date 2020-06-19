package com.ac.mylib.java.guava;

import ch.qos.logback.core.util.TimeUtil;
import com.ac.mylib.controller.Employee;
import com.ac.mylib.dao.UserDao;
import com.ac.mylib.entity.User;
import com.google.common.cache.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class MyGuavaCache {

    @Autowired
    private static UserDao userDao;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建一个cacheLoader，必须
        CacheLoader<String, Employee> loader = new CacheLoader<String, Employee>() {
            @Override
            public Employee load(String s) throws Exception {
                System.out.println("Hello Ada");
                return new Employee(s, 1000, LocalDate.now());
            }
        };
        // 可选的，失效时退出策略
        RemovalListener<String, Employee> removalListener = new RemovalListener<String, Employee>() {
            @Override
            public void onRemoval(RemovalNotification<String, Employee> removal) {
                System.out.println("Shuting down------");
            }
        };
        LoadingCache<String, Employee> cache = CacheBuilder.newBuilder().maximumSize(5).expireAfterAccess(10, TimeUnit.MILLISECONDS).removalListener(removalListener).build(loader);
        Employee Ada01 = cache.get("Ada");
        System.out.println("Employee01 is:" + Ada01);
        TimeUnit.MILLISECONDS.sleep(11);
        Employee ada02 = cache.get("Ada");
        System.out.println("Employee02 is:" + cache.asMap());

        Employee ada3 = cache.get("Bob");
        System.out.println("Employee03 is:" + cache.asMap());
        Employee ada04 = cache.get("Ada");
        System.out.println("Employee04 is:" + cache.stats());
        Employee ada05 = cache.get("Ada");
        System.out.println("Employee is:" + ada05);
        Employee ada06 = cache.get("Ada");
        System.out.println("Employee is:" + ada06);
        Employee ada07 = cache.get("Ada");
        System.out.println("Employee is:" + ada07);
        Employee ada08 = cache.get("Ada");
        System.out.println("Employee is:" + ada08);
        Employee ada09 = cache.get("Ada");
        System.out.println("Employee is:" + ada09);
        Employee ada10 = cache.get("Ada");
        System.out.println("Employee is:" + cache.asMap());


    }
}
