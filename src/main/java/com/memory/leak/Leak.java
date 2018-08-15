package com.memory.leak;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Leak { 

	private static Random random = new Random();
	public static final List<Double> list = new ArrayList<Double>();

	public void memoryOverFlow()
	{
		for (int i = 0; i < 99000000; i++) {
			list.add(random.nextDouble());
		}
	}

	public static void main(String[] args) {
		System.out.println(" Use the following parameters in the eclipse configuration\n -Xms2m -Xmx2m -verbose:gc");
		try {
			Leak leak = new Leak();
			leak.memoryOverFlow();

			System.out.println("Done!");	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
