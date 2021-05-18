package com.java.pr.juc.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 控制线程执行顺序
 * A 执行完调用 B
 * B 执行完调用 C
 * C 执行完调用 A
 */
public class Test3 {
    public static void main(String[] args) {
        Data3 data3 = new Data3();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printA();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printB();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printC();
            }
        },"C").start();
    }
}


// 业务 => 判断 => 执行 => 通知
class Data3{

    private Lock lock = new ReentrantLock();
    // 监视器
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    private int number = 1;
    public void printA() {
        lock.lock();
        try {
            while (number != 1) {
                // 等待
                conditionA.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>AAAA");
            // 唤醒,唤醒指定的线程,B
            number = 2;
            conditionB.signal();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            while (number != 2) {
                // 等待
                conditionB.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>BBBB");
            // 唤醒,唤醒指定的线程,B
            number = 3;
            conditionC.signal();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    protected void printC() {
        lock.lock();
        try {
            while (number != 3) {
                // 等待
                conditionC.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>CCC");
            // 唤醒,唤醒指定的线程,C
            number = 1;
            conditionA.signal();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    // 生产线 :=>下单 => 交易 => 物流
}