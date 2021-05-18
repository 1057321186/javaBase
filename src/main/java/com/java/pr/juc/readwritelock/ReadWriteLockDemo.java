package com.java.pr.juc.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 独占锁（写锁） 一次只能被一个线程占有
 * 共享锁（读锁） 多个线程同时占有
 * ReadWriteLock
 * 读-读  可以共存!
 * 读-写  不能共存!
 * 写-写  不能共存!
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
//        CacheMap map = new CacheMap();
        CacheLockMap map = new CacheLockMap();

        // 写入
        for (int i = 0; i < 6; i++) {
            final int temp = i;
            new Thread(() -> {
                map.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }

        // 读取
        for (int i = 0; i < 6; i++) {
            final int temp = i;
            new Thread(() -> {
                map.get(temp+"");
            },String.valueOf(i)).start();
        }

    }
}


/**
 * 自定义缓存
 */
class CacheLockMap{
    private volatile Map<String,Object> map = new HashMap();

    // 读写锁:更加细粒度的控制
    ReadWriteLock lock = new ReentrantReadWriteLock();
//    ReentrantLock lock = new ReentrantLock();

    // 存，写入 只希望只有一个线程同时写
    public void put(String key,Object value) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + "写入END");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
   }

    // 取，读 所有线程都可以读
    public void get(String key) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "读取" + key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取END");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
    }
}

/**
 * 自定义缓存
 */
class CacheMap{
    private volatile Map<String,Object> map = new HashMap();

    // 存，写入
    public void put(String key,Object value) {
        System.out.println(Thread.currentThread().getName() + "写入" + key);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName() + "写入END");
    }

    // 取，读
    public void get(String key) {
        System.out.println(Thread.currentThread().getName() + "读取" + key);
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取END");
    }
}
