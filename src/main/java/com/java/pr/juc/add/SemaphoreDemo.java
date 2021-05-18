package com.java.pr.juc.add;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量
 * 一个计数信号量。 在概念上，信号量维持一组许可证。
 * 如果有必要，每个acquire()都会阻塞，直到许可证可用，然后才能使用它。
 * 每个release()添加许可证，潜在地释放阻塞获取方。
 * 但是，没有使用实际的许可证对象; Semaphore只保留可用数量的计数，并相应地执行。
 *
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        // 初始化三个车位
        // 创建一个 Semaphore与给定数量的许可证和非公平公平设置
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    // 从该信号量获取许可证，阻塞直到可用，或线程为 interrupted
                    semaphore.acquire();// 得到
                    System.out.println(Thread.currentThread().getName()+" 抢到了车位");
                    TimeUnit.SECONDS.sleep(6);
                    System.out.println(Thread.currentThread().getName()+" 离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    // 释放许可证，将其返回到信号量，然后唤醒等待的线程
                    semaphore.release();// 释放
                }
            },"线程"+i).start();
        }
    }
}
