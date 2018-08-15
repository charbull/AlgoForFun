package com.threads.example;

class Employee extends Thread {
	String name;
	TimeCard tc;
	public Employee(String name, TimeCard tc) {
		this.name = name;
		this.tc = tc;
	}
	public void run() {
		while (true) {
			tc.punch(name);
		}
	}
}
