package com.web.shopping.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * newSchaduledThreadPool 创建一个定长的线程池，可以支持定时及周期性任务的执行
 */
public class ScheduledThreadPoolExample {
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(8);
        pool.schedule(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("第一个线程");
                        System.out.println("延迟5秒运行");
                    }
                },
                5,
                TimeUnit.SECONDS
        );
        System.out.println("主线程");
    }
}
