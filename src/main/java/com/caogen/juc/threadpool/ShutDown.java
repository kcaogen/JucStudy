package com.caogen.juc.threadpool;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author 康良玉
 * @Description 演示关闭线程池
 * @Create 2022-07-12 14:23
 */
public class ShutDown {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new ShutDownTask());
        }

        Thread.sleep(1500);
        // 判断是否开始停止线程池
        System.out.println(executorService.isShutdown());
        // 优雅的停止线程池，保证之前的任务全部完成才会停止，并且不会接收新任务，有新任务会抛出异常
        executorService.shutdown();
        System.out.println(executorService.isShutdown());

        // 判断这段时间内是否所有任务执行完毕
        boolean b = executorService.awaitTermination(7L, TimeUnit.SECONDS);

        // 判断整个程序是否停止并且所有任务执行完毕
        System.out.println(executorService.isTerminated());
        executorService.execute(new ShutDownTask());

        // 暴力停止目前的所有线程，并返回队列里面正在等待的线程
        List<Runnable> runnableList = executorService.shutdownNow();
    }
}

class ShutDownTask implements Runnable {

    public void run() {
        try {
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "被中断了");
        }
    }
}