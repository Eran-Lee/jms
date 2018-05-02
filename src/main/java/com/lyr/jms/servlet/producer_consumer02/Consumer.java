package com.lyr.jms.servlet.producer_consumer02;

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
				Thread.sleep((long)(1000 * Math.random()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			resource.remove();
		}
	}

}
