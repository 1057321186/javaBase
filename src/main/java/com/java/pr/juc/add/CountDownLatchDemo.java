package com.java.pr.juc.add;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁(倒计时锁存器)：允许一个或多个线程等待直到在其他线程中执行的一组操作完成的同步辅助
 *
 * 案例，创建6个线程，让主线程等待其余三个线程执行完毕后再执行主线程
 *
 * A CountDownLatch用给定的计数初始化。 await方法阻塞，直到由于countDown()方法的调用而导致当前计数达到零，
 * 之后所有等待线程被释放，并且任何后续的await 调用立即返回。 这是一个一次性的现象 - 计数无法重置
 */
// 减法计数器器
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {

        // 构造一个以给定计数
        CountDownLatch countDownLatch = new CountDownLatch(6);// 如果参数大于7，执行减少计数的线程数量不足，则会一直阻塞

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "出门");
                //减少锁存器的计数，如果计数达到零，释放所有等待的线程
                countDownLatch.countDown();// 计数器 -1
                System.out.println("当前计数" + countDownLatch.getCount());;// 返回当前计数
            },"线程" + i).start();
        }

        // 让当前线程等到锁存器计数到零，除非线程是 interrupted
        countDownLatch.await();// 阻塞，等待计数器归0，然后再向下执行

        System.out.println("关门");

    }
}
