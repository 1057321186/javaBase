package com.java.pr.juc.unsafe;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

// java.util.ConcurrentModificationException 并发修改异常
public class ListTest {
    public static void main(String[] args) {

        // 并发下ArrayList不安全
        /**
         * 解决方法:
         *  1、List<String> list = new Vector<>(); jdk 1.0
         *  2、List<String> list = Collections.synchronizedList(new ArrayList<>());
         *  3、
         */
//        List<String> list = new Vector<>();// jdk 1.0 发布
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        // CopyOnWriteArray 写入时复制 COW 计算机设计领域的一种优化策略
        // 多个线程调用的时候，list 读取的时候，固定的，写入(覆盖)
        // 在写入的时候避免覆盖，造成数据问题
        // 读写分离
        //
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString());
                System.out.println(list);
            },"线程:"+i).start();
        }
    }
}
