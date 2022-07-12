package com.caogen.juc.threadpool;

/**
 * @Author 康良玉
 * @Description 创建一个线程示例
 * @Create 2022-07-12 11:40
 */
public class EveryTaskOneThread {

    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.start();
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("执行了任务");
        }
    }

}
