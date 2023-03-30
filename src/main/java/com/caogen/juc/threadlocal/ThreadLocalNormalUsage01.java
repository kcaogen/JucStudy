package com.caogen.juc.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 康良玉
 * @Description 多线程打印时间
 * @Create 2023-03-30 10:51
 */
public class ThreadLocalNormalUsage01 {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            new Thread() {
                @Override
                public void run() {
                    String date = new ThreadLocalNormalUsage01().date(finalI);
                    System.out.println(date);
                }
            }.start();
            Thread.sleep(100);
        }

    }

    public String date(int seconds) {
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }

}
