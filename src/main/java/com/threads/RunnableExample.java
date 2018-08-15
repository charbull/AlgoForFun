package com.threads;

public class RunnableExample implements Runnable {

	public int count = 0;
	
	@Override
	public void run() {
		System.out.println("Runnable Example Starting ");
		try {
			while(count < 5)
			{
				Thread.sleep(500);
				count++;
				System.out.println("count is "+count);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
