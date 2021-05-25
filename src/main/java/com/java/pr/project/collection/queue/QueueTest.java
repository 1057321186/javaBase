package com.java.pr.project.collection.queue;


import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 队列
 *
 * add(E e)
 * 将指定的元素插入到此队列中，如果可以立即执行此操作，而不会违反容量限制， true在成功后返回 IllegalStateException如果当前没有可用空间，则抛出IllegalStateException。
 * E element()
 * 检索，但不删除，这个队列的头。
 * boolean offer(E e)
 * 如果在不违反容量限制的情况下立即执行，则将指定的元素插入到此队列中。
 * E peek()
 * 检索但不删除此队列的头，如果此队列为空，则返回 null 。
 * E poll()
 * 检索并删除此队列的头，如果此队列为空，则返回 null 。
 * E remove()
 * 检索并删除此队列的头。
 *
 */
public class QueueTest {
    public static void main(String[] args) {

        ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
        // 将指定的元素插入到此队列中
        queue.add("a");
        queue.add("b");
        queue.add("c");
        // 获取队列的首元素
        System.out.println(queue.element());

    }
}
