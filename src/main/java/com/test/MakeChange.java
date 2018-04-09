package com.test;

public class MakeChange {

	public static void main(String[] args) {
		System.out.println(makeChangeWrong(8)==makeChange2(8));
		System.out.println(makeChangeWrong(6)==makeChange2(6));
	}
	
	private static int makeChangeWrong(int n)
	{
		if(n < 0 ) return 0;
		if(n == 1 ) return 1;
		
		return makeChangeWrong(n-1) + makeChangeWrong(n-5)+ makeChangeWrong(n-10)  + makeChangeWrong(n-25);
	}
	
	
	private static int makeChange2(int n)
	{
		int[] denoms = {25, 10, 5, 1};
		return makeChange2(n, denoms, 0);
	}

	private static int makeChange2(int amount, int[] denoms, int index) {
		if(index >= denoms.length -1) return 1;
		int denomAmount = denoms[index];
		int ways = 0;
		for(int i=0; i*denomAmount<= amount; i++)
		{
			int amountRemaining = amount - i* denomAmount;
			ways+= makeChange2(amountRemaining, denoms, index+1);
		}
		return ways;
	}
	
	
	
}
