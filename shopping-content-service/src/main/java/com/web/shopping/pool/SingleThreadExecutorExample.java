package com.web.shopping.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newSingleThreadExecutor 是创建一个单线程的线程池，保证任务的顺序执行
 * FIFO LIFO 优先级
 */
public class SingleThreadExecutorExample {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            pool.execute(

                    new Runnable() {

                        @Override
                        public void run() {
                            try {
                                System.out.println("第" + index + "个线程正在被打印");
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    });


        }
        System.out.println("主线程");
    }
}
