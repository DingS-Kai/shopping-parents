package com.web.shopping.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newFixedThreadPool可以创建一个定长的线程池，线程数超过了线程池的数量则会被等待
 */
public class FixedThreadPoolExample {
    public static void main(String[] args) {
        final int I=2;
        ExecutorService pool = Executors.newFixedThreadPool(8);
        for(int i=0;i<8;i++){
        final int index = i;
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("第"+index+"个线程");
            }
        });

        }
        System.out.println("主线程");
    }
}
