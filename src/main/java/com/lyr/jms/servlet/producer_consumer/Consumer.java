package com.lyr.jms.servlet.producer_consumer;

public class Consumer implements Runnable{
	private DataStore m_data;
	

	public Consumer(DataStore m_data) {
		super();
		this.m_data = m_data;
	}


	public void run() {
		System.out.println("consumer thread run");
		while(true) {
			m_data.consumerData();
		}
	}
	
}
