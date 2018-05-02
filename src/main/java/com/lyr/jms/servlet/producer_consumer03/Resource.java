package com.lyr.jms.servlet.producer_consumer03;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Resource {
	private BlockingQueue<Integer> resourceQueue = new LinkedBlockingQueue<Integer>();

	public void add() {
		try {
			resourceQueue.put(1);
			System.out.println(
					"生产者" + Thread.currentThread().getName() + "生产一件资源," + "当前资源池有" + resourceQueue.size() + "个资源");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void remove() {
		try {
			resourceQueue.take();
			System.out.println("消费者" + Thread.currentThread().getName() + 
				                        "消耗一件资源," + "当前资源池有" + resourceQueue.size() 
					                    + "个资源");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
