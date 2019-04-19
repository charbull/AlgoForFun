package com.test;

public class DeleteAndEarn {

	public static void main(String[] args) {
		//int[] tab = new int[] {3,7,10,5,2,4,8,9,9,4,9,2,6,4,6,5,4,7,6,10};
		int[] tab = new int[] {3,4,2};
		System.out.println(deleteAndEarn(tab));
	}
	 public static int deleteAndEarn(int[] nums) {
	        int[] sum = new int[22]; 
	        
	        for(int i = 0; i < nums.length; i++){
	            sum[nums[i]] += nums[i]; 
	        }
	        
	        for(int i = 2; i < sum.length; i++){
	            sum[i] = Math.max(sum[i-1], sum[i-2] + sum[i]);
	        }
	        return sum[4];
	    }
}
