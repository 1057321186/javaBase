package com.java.pr.juc;

/**
 * 基本的买票的例子
 *
 *
 * 真正的多线程开发，公司中的开发，降低耦合性
 * 线程就是单独的一个资源类，没有任何附属操作
 * 1、属性、方法
 *
 */
public class SaleTicketDemo1 {
    public static void main(String[] args) {
        // 并发：多线程操作同一个资源类，把资源类丢入线程
        Ticket ticket = new Ticket();
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
class Ticket{

    // 属性、方法
    private int count = 50;

    // 买票的方式
    // synchronized 本质：队列、
    public synchronized void sale() {
        if (count > 0) {
            System.out.println(Thread.currentThread().getName()+"卖出了"+ (--count) +"张票,剩余"+ count +"张票");
        }
    }

}




