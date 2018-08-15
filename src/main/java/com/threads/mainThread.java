package com.threads;

public class mainThread {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Main Thread ... starting");
		ThreadExample instance = new ThreadExample();
		instance.start();
		
		while(instance.count != 5)
		{
			Thread.sleep(250);
		}
		
		System.out.println("Main Thread ... done");
	}

}
