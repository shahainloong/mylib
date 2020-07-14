package com.ac.mylib.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author C5294803
 */
public class ThreadPoolExecutorUtil {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    private ThreadPoolExecutor executor = new ThreadPoolExecutor(
            CORE_POOL_SIZE,
            MAX_POOL_SIZE,
            KEEP_ALIVE_TIME,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(QUEUE_CAPACITY),
            new ThreadPoolExecutor.CallerRunsPolicy());
    // 实现方式1. 延迟加载/懒汉模式
    private static volatile ThreadPoolExecutorUtil threadPoolExecutorUtils;

    private ThreadPoolExecutorUtil() {
    }

    public static ThreadPoolExecutorUtil getInstance() {
        if (threadPoolExecutorUtils != null) {

        } else {
            synchronized (ThreadPoolExecutorUtil.class) {
                if (threadPoolExecutorUtils == null) {
                    threadPoolExecutorUtils = new ThreadPoolExecutorUtil();
                }
            }

        }
        return threadPoolExecutorUtils;
    }

    public ThreadPoolExecutor getExecutor() {
        return executor;
    }

    // 实现方式2. 立即加载/饿汉模式
//    private static ThreadPoolExecutorUtil threadPoolExecutorUtil = new ThreadPoolExecutorUtil();
//
//    public ThreadPoolExecutorUtil() {
//    }
//    public static ThreadPoolExecutorUtil getInstance(){
//        缺点是不能有实例变量，因为getInstance没有同步，会出现非线程安全问题
//        return threadPoolExecutorUtil;
//    }
}

