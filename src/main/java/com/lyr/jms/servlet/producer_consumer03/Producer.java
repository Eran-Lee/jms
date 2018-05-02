package com.lyr.jms.servlet.producer_consumer03;

public class Producer extends Thread {
	private Resource resource;

	public Producer(Resource resource) {
		super();
		this.resource = resource;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep((long) (1000 * Math.random()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			resource.add();
		}
	}

}
