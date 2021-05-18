package com.java.pr.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 3、增加了一个普通方法后！是先执行发短信还是hello?
 *      result：hello，普通方法直接执行，没加锁，不需要等待锁
 * 4、两个对象，两个同步方法， 先发短信还是打电话?
 *      result:打电话
 */
public class Test2 {
    public static void main(String[] args) {
        // 两个独享，两个调用者，两把锁
        Phone2 phone1= new Phone2();
        Phone2 phone2 = new Phone2();

        new Thread(()->{
            System.out.println("线程A执行");
            phone1.sendSms();
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
//            phone1.hello();
            phone2.call();
        },"线程B").start();
    }
}


class Phone2{
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

    public void hello() {
        System.out.println("hello");
    }
}