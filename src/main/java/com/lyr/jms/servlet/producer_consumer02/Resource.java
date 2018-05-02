package com.lyr.jms.servlet.producer_consumer02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Resource {
	private int num = 0; //当前资源数量
	private int size = 10; //资源池中最大的数量
	private Lock lock;
	private Condition produceCondition;
	private Condition consumeCondition;
	public Resource(Lock lock, Condition produceCondition, Condition consumeCondition) {
		super();
		this.lock = lock;
		this.produceCondition = produceCondition;
		this.consumeCondition = consumeCondition;
	}
	
	public void add() {
		lock.lock();
		try {
			if(num < size) {
				num++;
				System.out.println(Thread.currentThread().getName() + "生产一件资源,当前资源池有" + num + "个");
				consumeCondition.signalAll();
			}else {
				try {
					produceCondition.await();
					System.out.println(Thread.currentThread().getName() + "线程进入等待");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}finally {
			lock.unlock();
		}
	}
	
	public void remove() {
		lock.lock();
		try {
			if(num > 0) {
				num--;
				System.out.println("消费者" + Thread.currentThread().getName() 
			              + "消耗一件资源," + "当前资源池有" + num + "个");
				produceCondition.signalAll();
			}else {
				try {
					consumeCondition.await();
					System.out.println(Thread.currentThread().getName() + "线程进入等待");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} finally {
			lock.unlock();
		}
	}
}
