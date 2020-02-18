package com.ac.mylib.java.guava;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

/**
 * 使用StopWatch查看程序运行了多少时间
 *
 * @author hailong.sha
 */
public class MyStopWatch {
    private static final Logger logger = LoggerFactory.getLogger(MyStopWatch.class);

    public static void main(String[] args) throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        final long startTime = System.nanoTime();
        Thread.sleep(100);
        final long endTime = System.nanoTime();
        // stopwatch.stop()也就是endTime - startTime的时间
        logger.info("It takes about {} minites.", stopwatch.stop());
        logger.info("It takes about {} minites.", endTime - startTime);

    }
}
