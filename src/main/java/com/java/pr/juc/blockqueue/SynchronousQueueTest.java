package com.java.pr.juc.blockqueue;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 同步队列
 * 其中每个插入操作必须等待另一个线程相应的删除操作，
 * 反之亦然。 同步队列没有任何内部容量，甚至没有一个容量。
 */
public class SynchronousQueueTest {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + " put a");
                queue.put("a");
                System.out.println(Thread.currentThread().getName() + " put b");
                queue.put("b");
                System.out.println(Thread.currentThread().getName() + " put c");
                queue.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程1").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "take: "+queue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "take: "+queue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "take: "+queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程2").start();

    }
}
