package com.caogen.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author 康良玉
 * @Description newSingleThreadExecutor 单个线程池 无界队列
 * @Create 2022-07-12 12:07
 */
public class SingleThreadExecutor {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Task());
        }
    }

}
