package com.java.pr.juc.blockqueue;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列
 */
public class BlockQueueTest {
    // 定义队列容量3
    static ArrayBlockingQueue queue = new ArrayBlockingQueue(3);

    public static void main(String[] args) {
//       test1();
//       test2();
        try {
//            test3();
            test4();
        } catch (Exception e) {
            e.printStackTrace();
        }


        // 遍历queue
        Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
//            System.out.println(next.toString());
        }
    }

    /**
     * 抛出异常
     * 添加: add(),将指定的元素插入到此队列中，如果可以立即执行此操作而不违反容量限制， true在成功后返回 IllegalStateException如果当前没有可用空间，则抛出IllegalStateException。
     * 移除: remove(),从该队列中删除指定元素的单个实例（如果存在）。
     */
    public static void test1() {
        System.out.println("===add queue================");
//        System.out.println(queue.add("a"));
//        System.out.println(queue.add("b"));
//        System.out.println(queue.add("c"));
        // java.lang.IllegalStateException: Queue full
        // 队列满了，再add()直接抛出异常
//        System.out.println(queue.add("d"));

        System.out.println("队首元素："+queue.element());// 获取队首元素，如果为空，抛出异常

        System.out.println("===remove queue=============");
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        // java.util.NoSuchElementException
        // 队列元素清空了，再remove()直接抛出异常
//        System.out.println(queue.remove());
    }

    /**
     * 有返回值，不抛出异常
     * 添加: offer(),将指定的元素插入到此队列中，如果可以立即执行此操作，而不会违反容量限制， true在成功时 false如果当前没有可用空间，则返回false
     * 移除: poll(),检索并删除此队列的头，等待指定的等待时间（如有必要）使元素变为可用
     */
    public static void test2() {
        System.out.println("===offer queue================");
//        System.out.println(queue.offer("a"));
//        System.out.println(queue.offer("b"));
//        System.out.println(queue.offer("c"));
        // 队列满了，再添加()直接返回false
//        System.out.println(queue.offer("d")); // false

        // 获取队首元素，为空，不抛异常
        System.out.println("队首元素："+queue.peek());

        System.out.println("===poll queue=================");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        // 队列中元素移除完了，再移除返回null
        System.out.println(queue.poll());
    }

    /**
     * 等待，阻塞(一直)
     * 添加: put(),将指定的元素插入到此队列中，等待空格可用
     * 删除: take(),检索并删除此队列的头，如有必要，等待元素可用
     */
    public static void test3() throws InterruptedException {
        System.out.println("===put queue================");
        queue.put("a");
        queue.put("b");
        queue.put("c");
//        queue.put("d");// 队列没有位置了，一直阻塞

        System.out.println("===take queue=========");

        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
//        System.out.println(queue.take());// 队列中元素空， 就一直阻塞等待
        System.out.println("===take queue end=========");
    }

    /**
     * 等待，阻塞(超时)
     * 添加:
     * 删除:
     */
    public static void test4() throws InterruptedException {
        System.out.println("===offer queue================");
        System.out.println(queue.offer("a"));
        System.out.println(queue.offer("b"));
        System.out.println(queue.offer("c"));
        // 队列满了，等待2s超时结束
        System.out.println(queue.offer("d",2, TimeUnit.SECONDS)); // false

        // 获取队首元素，为空，不抛异常
        System.out.println("队首元素："+queue.peek());

        System.out.println("===poll queue=================");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        // 队列中元素移除完了，再移除,等待超时2S返回null
        System.out.println(queue.poll(2,TimeUnit.SECONDS));
    }
}
