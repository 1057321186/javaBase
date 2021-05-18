package com.java.pr.juc.pc;

/**
 * 线程之间的通信问题：生产者和消费者问题！ 等待唤醒，通知唤醒
 * 线程交替执行 A B 操作同一个变量 num = 0
 * A num + 1
 * B num - 1
 *
 * 如何是四个会造成虚假唤醒
 */
public class Test {
    public static void main(String[] args) {

    Data data = new Data();
    new Thread(() -> {
        for (int i = 0; i < 10; i++) {
            try {
                data.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    },"A").start();

    new Thread(() -> {
        for (int i = 0; i < 10; i++) {
            try {
                data.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    },"B").start();

    new Thread(() -> {
        for (int i = 0; i < 10; i++) {
            try {
                data.decrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    },"C").start();

    new Thread(() -> {
        for (int i = 0; i < 10; i++) {
            try {
                data.decrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    },"D").start();
}
}


// 等待，业务，通知
class Data { // 资源类
    private int number = 0;

    public synchronized void increment() throws InterruptedException {
//        if (number != 0) {
        while (number != 0) { //使用while防止虚假唤醒
            // 等待
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        // 通知其他线程，他+1完毕了
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
//        if (number == 0) {
        while (number == 0) { //使用while防止虚假唤醒
            // 等待
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        // 通知其他线程，他-1完毕了
        this.notifyAll();
    }
}



