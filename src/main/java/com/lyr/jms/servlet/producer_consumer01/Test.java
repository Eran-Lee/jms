package com.lyr.jms.servlet.producer_consumer01;

public class Test {

	public static void main(String[] args) {
		DataStore data = new DataStore();
		Consumer consumer = new Consumer(data);
		Producer producer = new Producer(data);
		
		Thread consumerThread1 = new Thread(consumer);
		Thread consumerThread2 = new Thread(consumer);
		Thread consumerThread3 = new Thread(consumer);
		Thread producerThread = new Thread(producer);
		
		consumerThread1.start();
		consumerThread2.start();
		consumerThread3.start();
		producerThread.start();
		
	}

}
