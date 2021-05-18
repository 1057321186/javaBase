package com.java.pr.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 1、1个静态的同步方法，1个普通的同步方法，一个对象，先打印 发短信？打电话？
 *      result:打电话 (锁的对象不同)
 * 2、1个静态的同步方法，11个普通的同步方法，两个对象 先打印 发短信？打电话？
 *      result:打电话 (锁的对象不同)
 */
public class Test4 {
    public static void main(String[] args) {

        Phone4 phone4 = new Phone4();
        Phone4 phone5 = new Phone4();

        new Thread(()->{
            System.out.println("线程A执行");
            phone4.sendSms();
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
            phone5.call();
        },"线程B").start();
    }
}


// Phone4唯一的一个Class对象
class Phone4{

    // static 静态方法
    // 对静态同步方法加锁，锁的是类(Class对象)
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

    // 普通的同步方法 锁的调用者
    public synchronized void call() {
        System.out.println("获取到了Phone对象的锁");
        System.out.println(">>>>>>>>>>打电话");
        System.out.println("执行完毕释放锁");
    }

}

