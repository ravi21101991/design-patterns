package com.concurrency.core;

import java.util.LinkedList;

public class AProcessor {

	private LinkedList<Integer> list = new LinkedList<Integer>();

	private static final int LIMIT = 10;

	private Object mutex = new Object();

	public void produce() throws InterruptedException {

		int value = 0;
		while (true) {
			Thread.sleep(400);
			synchronized (mutex) {
				while (list.size() == LIMIT) {
					mutex.wait();
				}
				list.add(value++);
				mutex.notify();
			}
		}
	}

	public void consume() throws InterruptedException {

		while (true) {
			synchronized (mutex) {
				while (list.size() == 0) {
					mutex.wait();
				}
				System.out.printf("\n Value consumed is %d.", list.removeFirst());
				mutex.notify();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		AProcessor processor = new AProcessor();
		Thread producer = new ProducerThread1(processor);
		Thread consumer = new ConsumerThread1(processor);

		producer.start();
		consumer.start();
		producer.join();
		consumer.join();
	}
}

class ProducerThread1 extends Thread {

	private AProcessor processor;

	public ProducerThread1(AProcessor processor) {
		this.processor = processor;
	}

	public void run() {
		try {
			processor.produce();
		} catch (InterruptedException e) {
		}
	}
}

class ConsumerThread1 extends Thread {

	private AProcessor processor;

	public ConsumerThread1(AProcessor processor) {
		this.processor = processor;
	}

	public void run() {
		try {
			processor.consume();
		} catch (InterruptedException e) {
		}
	}
}
