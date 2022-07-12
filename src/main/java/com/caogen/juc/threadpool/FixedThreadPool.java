package com.caogen.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author 康良玉
 * @Description newFixedThreadPool 无界队列
 * @Create 2022-07-12 11:51
 */
public class FixedThreadPool {

    private static ExecutorService executorService = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Task());
        }
    }
}

class Task implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
