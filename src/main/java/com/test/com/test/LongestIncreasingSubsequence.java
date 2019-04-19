package com.test;

import java.util.Arrays;

public class LongestIncreasingSubsequence {


	public static void main(String[] args) {
		int[] tab = {3, 4, 7, 6, 8};
		System.out.println(lis(tab));
	}

	
	public static int lis(int[] tab)
	{
		int[] dp = new int[tab.length];
		int len = 0;
		int index = 0;
		//Arrays.fill(dp, Integer.MAX_VALUE); // you can remove this line only if you use, 0 and len which increase with the search
		for(int i=0; i<tab.length;i++)
		{
			index = Arrays.binarySearch(dp, 0, len, tab[i]);
			if(index <0) index = -index-1;
			dp[index] = tab[i];
			if(index == len) len++;
		}
		return len;
	}

	
	public static int lis2(int[] tab)
	{
		int[] dp = new int[tab.length];
		int len = 0;
		int index = 0;
		Arrays.fill(dp, Integer.MAX_VALUE);
		for(int i=0; i<tab.length;i++)
		{
			index = Arrays.binarySearch(dp, tab[i]);
			if(index <0) index = -index-1;
			dp[index] = tab[i];
			if(index == len) len++;
		}
		return len;
	}

}
