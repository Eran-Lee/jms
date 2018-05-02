package com.lyr.jms.servlet.producer_consumer;

public class Test {

	public static void main(String[] args) {
		DataStore data = new DataStore();
		Consumer consumer = new Consumer(data);
		Producer producer = new Producer(data);
		
		Thread consumerThread = new Thread(consumer);
		Thread producerThread = new Thread(producer);
		
		consumerThread.start();
		producerThread.start();
		
	}

}
