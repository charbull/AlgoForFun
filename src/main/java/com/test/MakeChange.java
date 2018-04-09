package com.test;

public class MakeChange {

	public static void main(String[] args) {
		System.out.println(makeChangeCorrect(5));
		System.out.println(makeChangeWrong(5));
		System.out.println(makeChangeWrong(5)==makeChangeCorrect(5));
		System.out.println(makeChangeWrong(6)==makeChangeCorrect(6));
	}
	
	private static int makeChangeWrong(int n)
	{
		if(n <= 0 ) return 0;
		if(n == 1 ) return 1;
		if(n ==5) return 2;
		
		return makeChangeWrong(n-1) + makeChangeWrong(n-5)+ makeChangeWrong(n-10)  + makeChangeWrong(n-25);
	}
	
	
	private static int makeChangeCorrect(int n)
	{
		int[] denoms = {25, 10, 5, 1};
		return makeChangeCorrect(n, denoms, 0);
	}

	private static int makeChangeCorrect(int amount, int[] denoms, int index) {
		if(index >= denoms.length -1) return 1;
		int denomAmount = denoms[index];
		int ways = 0;
		for(int i=0; i*denomAmount<= amount; i++)
		{
			int amountRemaining = amount - i* denomAmount;
			ways+= makeChangeCorrect(amountRemaining, denoms, index+1);
		}
		return ways;
	}
	
	
	
}
