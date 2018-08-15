package com.threads.example;

public class Work {
	public static void main(String args[]) {
		TimeCard tc = new TimeCard();
		TimeCard tc2 = new TimeCard();
		Employee james = new Employee("James", tc);
		Employee mary = new Employee("Mary", tc2);
		james.start();
		mary.start();
	}
}
