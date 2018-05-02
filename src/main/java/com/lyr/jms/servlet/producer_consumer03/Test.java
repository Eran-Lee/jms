package com.lyr.jms.servlet.producer_consumer03;

public class Test {
	public static void main(String[] args) {
		Resource resource = new Resource();
		
		Producer producer = new Producer(resource);
		
		Consumer consumer1 = new Consumer(resource);
		Consumer consumer2 = new Consumer(resource);
		Consumer consumer3 = new Consumer(resource);
		
		producer.start();
		consumer1.start();
		consumer2.start();
		consumer3.start();
	}
}
