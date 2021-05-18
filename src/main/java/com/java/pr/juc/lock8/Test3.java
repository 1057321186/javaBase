package com.java.pr.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 *  5、增加两个静态的同步方法，只要一个对象，先打印 发短信？打电话？
 *      result:发短信
 *  6、两个对象！增加两个静态的同步方法，先打印 发短信？打电话？
 *      result:发短信
 */
public class Test3 {
    public static void main(String[] args) {
        // 两个对象的Class类模板只有一个，static锁的是Class
        Phone3 phone1 = new Phone3();
        Phone3 phone2 = new Phone3();

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
//            phone1.call();
            phone2.call();
        },"线程B").start();
    }
}

// Phone3唯一的一个Class对象
class Phone3{
    // synchronized 锁的对象是方法的调用者!
    // 两个方法用的同一把锁，谁先拿到谁执行!
    // 线程A先获取phone对象的锁，A先执行，B等待A释放锁
    // static 静态方法
    // 对静态方法加锁，锁的是类(Class对象)
    public static synchronized void sendSms() {
        System.out.println("获取到了Phone对象的锁");
        try {
            TimeUnit.SECONDS.sleep(4);
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(">>>>>>>>>>发短信");
        System.out.println("执行完毕释放锁");
    }

    public static synchronized void call() {
        System.out.println("获取到了Phone对象的锁");
        System.out.println(">>>>>>>>>>打电话");
        System.out.println("执行完毕释放锁");
    }

}
