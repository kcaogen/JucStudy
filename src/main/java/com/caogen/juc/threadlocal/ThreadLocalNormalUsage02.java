package com.caogen.juc.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author 康良玉
 * @Description 线程池打印时间
 * @Create 2023-03-30 10:51
 */
public class ThreadLocalNormalUsage02 {

    public static ExecutorService executorService = Executors.newFixedThreadPool(10);

    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalNormalUsage02().date(finalI);
                    System.out.println(date);
                }
            });
        }
        executorService.shutdown();
    }

    /**
     * dateFormat 变成静态公用之后需要加锁处理了，要不然多线程调用 dateFormat.format 有线程安全问题
     *
     * @param seconds
     * @return
     */
    public String date(int seconds) {
        Date date = new Date(1000 * seconds);
        String dateStr;
        synchronized (ThreadLocalNormalUsage02.class) {
            dateStr = dateFormat.format(date);
        }
        return dateStr;
    }

}
