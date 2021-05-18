package com.java.pr.juc;

public class Test1 {
    public static void main(String[] args) {
        new Thread().start();
        Thread.State state;// 线程状态枚举类

        // 获取cpu的核数
        // CPU 密集型，IO密集型
        System.out.println("当前电脑的CPU核数：" + Runtime.getRuntime().availableProcessors());
    }
}
