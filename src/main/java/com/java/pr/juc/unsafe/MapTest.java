package com.java.pr.juc.unsafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

// java.util.ConcurrentModificationException 并发修改异常
public class MapTest {
    public static void main(String[] args) {
        // 默认等价于什么？ new HashMap(16, 0.75f)  // 初始容量16 、用于建立初始表大小的负载因子（表密度）0.75
//        Map<String,String> map = new HashMap(16,0.75f);
        /**
         * 解决方法:Map<String,String> map = Collections.synchronizedMap(new HashMap<>());
         */
//        Map<String,String> map = Collections.synchronizedMap(new HashMap<>());
        // 默认等价于什么？ new HashMap(16, 0.75f)  // 默认大小16 、加载因子0.75
        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);
            },"线程" + i).start();
        }

    }
}
