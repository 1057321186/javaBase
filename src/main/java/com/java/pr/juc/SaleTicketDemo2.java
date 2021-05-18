package com.java.pr.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo2 {
    public static void main(String[] args) {
        // 并发：多线程操作同一个资源类，把资源类丢入线程
        Ticket2 ticket = new Ticket2();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        },"线程a").start();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        },"线程b").start();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        },"线程c").start();
    }
}

// 资源类
class Ticket2{

    // 属性、方法
    private int count = 50;

    Lock lock = new ReentrantLock();

    // 买票的方式
    public void sale() {
        lock.lock();// 加锁
//        lock.tryLock();
        try {
            if (count > 0) {
                System.out.println(Thread.currentThread().getName()+"卖出了"+ (--count) +"张票,剩余"+ count +"张票");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();// 释放锁
        }
    }

}


