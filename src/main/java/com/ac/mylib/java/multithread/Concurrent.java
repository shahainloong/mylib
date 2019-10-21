package com.ac.mylib.java.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Concurrent {

    public static final ExecutorService curl = Executors.newFixedThreadPool(5);

    // 构造一个ThreadPoolExecutor线程池
    ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3),
            new ThreadPoolExecutor.DiscardOldestPolicy());
    public static void main(String[] args) {
        Runnable a = () -> {
            System.out.println("--hello a--");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("--goodbye a--");};
        Runnable b = () -> {
            System.out.println("--hello b--");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("--goodbye b--");};
        Runnable c = () -> {
            System.out.println("--hello c--");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("--goodbye c--");};
        Callable<String> callableA = ()->{
            System.out.println("--hello a--");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("--goodbye a--");
            return "A";
        };
        Callable<String> callableB = ()->{
            System.out.println("--hello b--");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("--goodbye b--");
            return "B";
        };
        Callable<String> callableC = ()->{
            System.out.println("--hello c--");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("--goodbye c--");
            return "C";
        };
//        Thread aThread = new Thread(a);
//        Thread bThread = new Thread(b);
//        Thread cThread = new Thread(c);

        // 构造一个线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3),
                new ThreadPoolExecutor.DiscardOldestPolicy());
//        threadPool.execute(new ThreadPoolTask(task));

//        aThread.start();
//        bThread.start();
//        cThread.start();

        List<Future<String>> futures = new ArrayList<>();


//        threadPool.execute(a);
//        threadPool.execute(b);
//        threadPool.execute(c);

        futures.add(curl.submit(callableA));
        futures.add(curl.submit(callableB));
        futures.add(curl.submit(callableC));
        String output = "";
        try {
            for (int i = 0; i < futures.size(); i++) {

                System.out.println(futures.get(i).get());
                output += futures.get(i).get();
            }
            System.out.println(output);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        curl.shutdown();

    }
}
