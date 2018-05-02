package com.lyr.jms.servlet.producer_consumer01;

public class Consumer implements Runnable{
	private DataStore m_data;
	

	public Consumer(DataStore m_data) {
		super();
		this.m_data = m_data;
	}


	public void run() {
		System.out.println("consumer thread run");
		while(true) {
			try {
				Thread.sleep((long)1000*2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			m_data.consumerData();
		}
	}
	
}
