package com.threads;

public class ThreadExample extends Thread {

	int count = 0;

	public void run()
	{
		System.out.println("Thread Example is starting ");
		try {
			while(count < 5)
			{
				Thread.sleep(500);
				count++;
				System.out.println("count is "+count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Thread Example is Terminating");
	}

}
