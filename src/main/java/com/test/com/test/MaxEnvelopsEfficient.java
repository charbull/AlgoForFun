package com.test;

import java.util.Arrays;
import java.util.Comparator;

public class MaxEnvelopsEfficient {

	public static void main(String[] args) {
		int[][] envelopes = {{2, 3}, {6, 7}, {6, 4}, {5, 4}};
		System.out.println(maxEnvelopes(envelopes));
		int[][] envelopes2 = {{1,2},{2,3},{3,4},{3,5},{4,5},{5,5},{5,6},{6,7},{7,8}};
		System.out.println(maxEnvelopes(envelopes2));
		int[][] envelopes3 = {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
		System.out.println(maxEnvelopes(envelopes3));
	}
	/**
	 * Sort the array. Ascend on width and descend on height if width are same.
	 * Find the longest increasing subsequence based on height.
	 * Since the width is increasing, we only need to consider height.
	 * [3, 4] cannot contains [3, 3], 
	 * so we need to put [3, 4] before [3, 3] when sorting otherwise it will be counted as an increasing number
	 * if the order is [3, 3], [3, 4]
	 * 
	 * If you sort the width in ascending order and the height in descending order, this problem is same with no.300.
	 * For example, here are some envelops [2, 6] [3, 3] [3, 6] [2, 3] [1,1] [2 ,4].
	 * After sorted, the evnelops become [1, 1] [2, 6] [2 ,4] [2, 3] [3, 6] [3, 3]. 
	 * In this way, we focus on height of this array [1, 6, 4, 3, 6, 3] and find the longest ascending subsequence. 
	 * If we the height this array ind ascending order and assume the normal function dp[i] = max{dp[j] + 1, dp[i]}(A[i]>A[j]), 
	 * envelop with larger height can package a smaller height one even they have same width.
	 * */
	public static int maxEnvelopes(int[][] envelopes) {
		if(envelopes == null || envelopes.length == 0 
				|| envelopes[0] == null || envelopes[0].length != 2)
			return 0;
		Arrays.sort(envelopes, new Comparator<int[]>(){
			public int compare(int[] arr1, int[] arr2){
				if(arr1[0] == arr2[0])
					return arr2[1] - arr1[1];
				else
					return arr1[0] - arr2[0];
			} 
		});
		int dp[] = new int[envelopes.length];
		int len = 0;
		for(int[] envelope : envelopes){
			int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
			if(index < 0)
				index = -(index + 1);
			dp[index] = envelope[1];
			if(index == len)
				len++;
		}
		return len;
	}
	
	public int maxEnvelopes2(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0)
			return 0;
		Arrays.sort(envelopes, (x, y) -> x[0] - y[0] == 0 ? y[1] - x[1] : x[0] - y[0]);
		int[] dp = new int[envelopes.length + 1];
		int len = 0, idx = 0;
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i < envelopes.length; i++) {
			idx = Arrays.binarySearch(dp, envelopes[i][1]);
			idx = idx < 0 ? -idx - 1 : idx;
			dp[idx] = envelopes[i][1];
			len = Math.max(len, idx);
		}
		return len;
    }


}
