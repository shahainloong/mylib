package com.ac.mylib.java.multithread;

import com.ac.mylib.util.ThreadPoolExecutorUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(
//                CORE_POOL_SIZE,
//                MAX_POOL_SIZE,
//                KEEP_ALIVE_TIME,
//                TimeUnit.SECONDS,
//                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
//                new ThreadPoolExecutor.CallerRunsPolicy());

        ThreadPoolExecutor executor = ThreadPoolExecutorUtil.getInstance().getExecutor();


        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("CurrentThread name:" + Thread.currentThread().getName() + " date：" + LocalDateTime.now());
            });
        }
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->"SAP");
        System.out.println(future.get());
        //终止线程池
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished all threads");
    }
}
