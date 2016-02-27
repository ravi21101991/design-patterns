package com.concurrency.core;

import java.util.Scanner;

public class MailReader {

	private String message;

	private Scanner scanner = new Scanner(System.in);

	private Object lock = new Object();
	
	private static final String EMPTY_MESSAGE = "";
	
	private static final String GREETING_MESSAGE = "Enter the message or press return to QUIT: ";
	
	private static final String GOODBYE_MESSAGE = "GOODBYE";
	
	private static final String RECIEVED_MESSAGE = "Message recieved: %s \n";
			
	public void readMessage() throws InterruptedException {
		while (true) {
			synchronized (lock) {
				System.out.println(GREETING_MESSAGE);
				message = scanner.nextLine();
				if (EMPTY_MESSAGE.equals(message)) {
					System.out.println(GOODBYE_MESSAGE);
					System.exit(0);
				} else {
					lock.notify();
					lock.wait();
				}
			}
		}
	}

	public void publishMessage() throws InterruptedException {

		while (true) {
			synchronized (lock) {
				while (message == null) {
					lock.wait();
				}

				if (!EMPTY_MESSAGE.equals(message))
					System.out.printf(RECIEVED_MESSAGE, message);
				message = null;
				lock.notify();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MailReader mailReader = new MailReader();
		Thread messageReader = new MessageReader(mailReader);
		Thread messagePublisher = new MessagePublisher(mailReader);

		messageReader.start();
		messagePublisher.start();

		messageReader.join();
		messagePublisher.join();
	}
}

class MessageReader extends Thread {

	MailReader mailReader;

	public MessageReader(MailReader mailReader) {
		this.mailReader = mailReader;
	}

	@Override
	public void run() {
		try {
			mailReader.readMessage();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MessagePublisher extends Thread {

	MailReader mailReader;

	public MessagePublisher(MailReader mailReader) {
		this.mailReader = mailReader;
	}

	@Override
	public void run() {
		try {
			mailReader.publishMessage();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
