package com.caogen.juc.threadpool;

/**
 * @Author 康良玉
 * @Description 创建多个线程示例
 * @Create 2022-07-12 11:42
 */
public class ForLoop {

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(new Task());
            thread.start();
        }
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("执行了任务");
        }
    }

}
