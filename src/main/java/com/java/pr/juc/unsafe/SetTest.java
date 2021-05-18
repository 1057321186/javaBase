package com.java.pr.juc.unsafe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 同理可证
 */
// java.util.ConcurrentModificationException 并发修改异常
public class SetTest {
    public static void main(String[] args) {

        // 并发下HashSet不安全
        /**
         * 解决方法:
         *  1、Set<String> set = Collections.synchronizedSet(new HashSet<>());
         *  2、Set<String> set = new CopyOnWriteArraySet<>();
         */
        Set<String> set = new HashSet<>();
//        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },"线程" + i).start();
        }

    }
}
