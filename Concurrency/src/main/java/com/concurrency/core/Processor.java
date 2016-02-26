package com.concurrency.core;

import java.util.Scanner;

public class Processor {

	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer waiting...");
			this.wait();
			System.out.println("Producer resuming...");
		}
	}

	public void consume() throws InterruptedException {

		Thread.sleep(100);
		synchronized (this) {
			System.out.println("Press RETURN to continue");
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
			System.out.println("RETURN pressed.. notifying the waiting thread");
			scanner.close();
			this.notify();

		}
	}

	public static void main(String[] args) throws InterruptedException {
		Processor processor = new Processor();
		Thread producer = new ProducerThread(processor);
		Thread consumer = new ConsumerThread(processor);

		producer.start();
		consumer.start();
		producer.join();
		consumer.join();
		System.out.println("Main exiting now...");
	}
}

class ProducerThread extends Thread {

	private Processor processor;

	public ProducerThread(Processor processor) {
		this.processor = processor;
	}

	public void run() {
		try {
			processor.produce();
		} catch (InterruptedException e) {
		}
	}
}

class ConsumerThread extends Thread {

	private Processor processor;

	public ConsumerThread(Processor processor) {
		this.processor = processor;
	}

	public void run() {
		try {
			processor.consume();
		} catch (InterruptedException e) {
		}
	}
}
