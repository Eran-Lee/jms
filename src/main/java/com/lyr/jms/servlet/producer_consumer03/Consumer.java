package com.lyr.jms.servlet.producer_consumer03;

public class Consumer extends Thread {
	private Resource resource;

	public Consumer(Resource resource) {
		super();
		this.resource = resource;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep((long)(100000 * Math.random()));//这个时间如果是1000*，会出现问题；以后再细研究；
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			resource.remove();
		}
	}

}
