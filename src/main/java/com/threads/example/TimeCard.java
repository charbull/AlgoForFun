package com.threads.example;

import java.util.Date;

class TimeCard {
	Date dt = new Date();
	public void punch(String name) {
		System.out.println(name + " punched in at: \t" +
				((int)(System.currentTimeMillis() - dt.getTime()) /1000));
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException ie) {
		}
	}
}


