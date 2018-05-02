package com.lyr.jms.servlet.producer_consumer;

public class DataStore {
	private int m_idata = 0;
	private boolean m_bSetData = true;
	public synchronized void produceData(int inputData) {
		//数据栈已满，等待消费
		if(m_bSetData) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				System.out.println("InterrupExcepthion put data\\n");
			}
		}
		
		System.out.println("produce:" + inputData);
		m_idata = inputData;
		m_bSetData = true;
		this.notify(); //通知消费者消费
	}
	
	public synchronized void consumerData() {
		//数据栈为空，等待生产数据
		if(!m_bSetData) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				System.out.println("InterrupExcepthion get data\n");
			}
		}
		System.out.println("consumer: " + m_idata + "\n");
		m_bSetData = false;
		this.notify(); //通知生产者生产数据
	}

}
