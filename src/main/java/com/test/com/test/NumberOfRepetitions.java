package com.test;

public class NumberOfRepetitions {



	public static void main(String[] args) {
		int [] tab = {1, 2, 3, 4, 2, 3, 2, 1, 2};
		System.out.println(getMaxRepetition(tab));
	}

	public static int getMaxRepetition(int[] a) {
		int max = a.length; 
		// Iterate though input array, for every element a[i],
		// increment a[a[i]%k] by k
		for (int i = 0; i< a.length; i++)
		{  
			int num = a[i]%max;
			a[num] = a[num] + max;
		}
		// Find index of the maximum repeating element
		int maxr = a[0], result = 0;
		for (int i = 1; i < a.length; i++)
		{
			if (a[i] > maxr)
			{
				maxr = a[i];
				result = i;
			}
		}
		return result;
	}


}
