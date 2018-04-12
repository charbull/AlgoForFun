package com.test;

public class RotateArray {

	public static int[] rotateLeft(int[] arr, int k)  {	
		if (arr == null) return null;
	    int actualShifts = k % arr.length;
	    reverse(arr, 0, arr.length-1);
	    reverse(arr, 0, arr.length - actualShifts-1);
	    reverse(arr, arr.length - actualShifts, arr.length-1);
	    return arr;
	}
	 
	public static void reverse(int[] arr, int left, int right){
		if(arr == null || arr.length == 1) return;
		while(left < right){
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}	
	}
	
	
}
