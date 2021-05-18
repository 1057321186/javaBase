package com.java.pr.juc.add;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 栅栏(循环屏障)
 * 允许一组线程全部等待彼此达到共同屏障点的同步辅助。
 * 循环阻塞在涉及固定大小的线程方的程序中很有用，这些线程必须偶尔等待彼此。
 * 屏障被称为循环 ，因为它可以在等待的线程被释放之后重新使用。
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        // 初始化循环屏障，设置屏障跳闸前必须调用 await()的线程数为7
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,new Thread(()->{
            // 线程数不够则会阻塞住
            System.out.println("Thread们都到了啊啊啊啊啊啊啊啊啊奥利给");
        }));


        for (int i = 0; i < 8; i++) {
            // lambda操作变量需要转换 final
            int temp = i;// (默认final)
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + " ");
                try {
                    cyclicBarrier.await();// +1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
