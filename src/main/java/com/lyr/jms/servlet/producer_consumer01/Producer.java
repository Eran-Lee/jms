package com.lyr.jms.servlet.producer_consumer01;

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
			try {
				Thread.sleep((long)1000*2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int data = random.nextInt(100);
			m_data.produceData(data);
		}
	}
	
}
