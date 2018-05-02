package com.lyr.jms.servlet.producer_consumer02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Condition conditionProduce = lock.newCondition();
		Condition conditionConsume = lock.newCondition();
		Resource resource = new Resource(lock, conditionProduce, conditionConsume);
		
		//生产者线程
		Producer producerThread = new Producer(resource);
		
		//消费者线程
		Consumer consumerThread1 = new Consumer(resource);
		Consumer consumerThread2 = new Consumer(resource);
		Consumer consumerThread3 = new Consumer(resource);
		
		producerThread.start();
		consumerThread1.start();
		consumerThread2.start();
		consumerThread3.start();
	}
}
