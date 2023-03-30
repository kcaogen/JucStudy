package com.caogen.juc.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 康良玉
 * @Description 多线程打印时间
 * @Create 2023-03-30 10:51
 */
public class ThreadLocalNormalUsage00 {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                String date = new ThreadLocalNormalUsage00().date(10);
                System.out.println(date);
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                String date = new ThreadLocalNormalUsage00().date(1007);
                System.out.println(date);
            }
        }.start();
    }

    public String date(int seconds) {
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }

}
