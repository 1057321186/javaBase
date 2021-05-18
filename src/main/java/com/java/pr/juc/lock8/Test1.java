package com.java.pr.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 *
 * 8锁：就是关于锁的8个问题
 * 1、标准情况下，两个线程先打印哪个？ 发短信？打电话？
 *      result:先发短信 再打电话
 * 2、sendSms 延迟4秒，两个线程先打印哪个？ 发短信？打电话？
 *      result:先发短信 再打电话
 */
public class Test1 {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(()->{
            System.out.println("线程A执行");
            phone.sendSms();
        },"线程A").start();

        try {
            // 主线程延迟1s执行
            TimeUnit.SECONDS.sleep(1);
//            Thread.sleep(1000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(()->{
            System.out.println("线程B执行");
            phone.call();
        },"线程B").start();
    }
}

class Phone{
    // synchronized 锁的对象是方法的调用者!
    // 两个方法用的同一把锁，谁先拿到谁执行!
    // 线程A先获取phone对象的锁，A先执行，B等待A释放锁
    public synchronized void sendSms() {
        System.out.println("获取到了Phone对象的锁");
        try {
            TimeUnit.SECONDS.sleep(4);
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
        System.out.println("执行完毕释放锁");
    }

    public synchronized void call() {
        System.out.println("获取到了Phone对象的锁");
        System.out.println("打电话");
        System.out.println("执行完毕释放锁");
    }

}