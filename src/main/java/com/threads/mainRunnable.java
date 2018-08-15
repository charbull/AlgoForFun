package com.threads;

public class mainRunnable {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Main Runnable ... starting");
		RunnableExample instance = new RunnableExample();
		Thread thread = new Thread(instance);
		thread.start();
		
		while(instance.count != 5)
		{
			Thread.sleep(250);
		}
		
		System.out.println("Main Runnable ... done");
	}

}
