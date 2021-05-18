package com.java.pr.project.thread.base;

import java.util.concurrent.CountDownLatch;


/**
 * 闭锁：允许一个或多个线程等待直到在其他线程中执行的一组操作完成的同步辅助
 *
 * 案例，创建三个线程，让主线程等待其余三个线程执行完毕后再执行主线程
 *
 * A CountDownLatch用给定的计数初始化。 await方法阻塞，直到由于countDown()方法的调用而导致当前计数达到零，
 * 之后所有等待线程被释放，并且任何后续的await 调用立即返回。 这是一个一次性的现象 - 计数无法重置
 */
public class CountDOwnLatchDemo {
	public static void main(String[] args) throws InterruptedException {
		new CountDOwnLatchDemo().go();
	}

	private void go() throws InterruptedException {
		// 计数器
		CountDownLatch countDownLatch=new CountDownLatch(3);

		//创建三个线程，并启动
		new Thread(new  Task(countDownLatch),"Thread1").start();
		Thread.sleep(1000);
		new Thread(new  Task(countDownLatch),"Thread2").start();
		Thread.sleep(1000);
		new Thread(new  Task(countDownLatch),"Thread3").start();

		// 阻塞主线程,
		countDownLatch.await();
		System.out.println("所有线程已到达,主线程开始执行"+System.currentTimeMillis());
	}

	class Task implements Runnable {
		private CountDownLatch countDownLatch;

		public  Task(CountDownLatch countDownLatch) {
			this.countDownLatch = countDownLatch;
		}

		@Override
		public void run() {
			System.out.println("线程"+Thread.currentThread().getName()+"已经到达"+System.currentTimeMillis());
			countDownLatch.countDown();
		}
	}

}
