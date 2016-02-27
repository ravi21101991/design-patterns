package com.concurrency.core;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

	private int counter = 0;

	private Lock lock = new ReentrantLock();

	public static void main(String[] args) {

		ReentrantLockDemo r = new ReentrantLockDemo();
		Thread t1 = new IncrementThread(r);
		Thread t2 = new IncrementThread(r);

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
		} finally {
			System.out.println("Counter value is: " + r.counter);
		}

	}

	public void increment() {
		for (int i = 0; i < 10000; i++) {
			counter++;
		}
	}

	public Lock getLock() {
		return lock;
	}
}

class IncrementThread extends Thread {

	private ReentrantLockDemo demo;

	public IncrementThread(ReentrantLockDemo demo) {
		this.demo = demo;
	}

	@Override
	public void run() {
		this.demo.getLock().lock();
		try {
			demo.increment();
		} finally {
			this.demo.getLock().unlock();
		}
	}
}