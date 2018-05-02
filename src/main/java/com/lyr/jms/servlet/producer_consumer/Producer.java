package com.lyr.jms.servlet.producer_consumer;

import java.util.Random;

public class Producer implements Runnable{
	private DataStore m_data;

	public Producer(DataStore m_data) {
		super();
		this.m_data = m_data;
	}

	public void run() {
		System.out.println("producer thread run");
		Random random = new Random();
		while(true) {
			int data = random.nextInt(100);
			m_data.produceData(data);
		}
	}
	
}
