package com.java.pr.juc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        new Thread(new MyThead()).start();
//        new Thread(new Runnable()).start();
//        FutureTask futureTask = new FutureTask(myThead);

        MyThead myThead = new MyThead();
        FutureTask futureTask = new FutureTask(myThead);// 适配类

        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();// 只会执行一个，结果被缓存了。

        String str = (String) futureTask.get();// 获取返回结果(可能会产生阻塞，把他放到最后)
        // 或者使用异步通信
        System.out.println(str);
    }
}


class MyThead implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("执行call方法");
        return "你是猪儿虫蛮";
    }
}