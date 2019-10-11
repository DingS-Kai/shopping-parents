package com.web.shopping.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * newCacheThreadPool创建一个可缓存线程池，当线程超过了线程池的数量，线程池会创建一个新的线程。
 * 缺点 有可能不断扩展线程导致内存溢出
 */
public class CachedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("第一个线程");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("第二个线程");
            }
        });
        System.out.println("主线程");
    }
}
