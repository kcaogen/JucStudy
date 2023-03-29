package com.caogen.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author 康良玉
 * @Description newCachedThreadPool 可缓存线程池 交换队列(没有队列缓存任务)
 * @Create 2022-07-12 12:10
 */
public class CachedThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Task());
        }
    }

}
