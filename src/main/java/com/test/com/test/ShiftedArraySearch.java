package com.test;

public class ShiftedArraySearch {
/*	Shifted Array Search

	A sorted array of distinct integers shiftArr is shifted to the left by an unknown offset and you don’t have a pre-shifted copy of it. For instance, the sequence 1, 2, 3, 4, 5 becomes 3, 4, 5, 1, 2, after shifting it twice to the left.

	Given shiftArr and an integer num, implement a function shiftedArrSearch that finds and returns the index of num in shiftArr. If num isn’t in shiftArr, return -1. Assume that the offset doesn’t equal to 0 (i.e. assume the array is shifted at least once) or to arr.length - 1 (i.e. assume the shifted array isn’t fully reversed).

	Explain your solution and analyze its time and space complexities.

	Example:

	input:  shiftArr = [9, 12, 17, 2, 4, 5], num = 2 # shiftArr is the
	                                                 # outcome of shifting
	                                                 # [2, 4, 5, 9, 12, 17]
	                                                 # three times to the left

	output: 3 # since it’s the index of 2 in arr

	Constraints:

	    [time limit] 5000ms
	    [input] array.integer arr
	    [input] integer num
	    [output] integer
*/
	static int shiftedArrSearch(int[] shiftArr, int num) {

	    int low = 0;
	    int high = shiftArr.length-1; 
	    int mid = 0;
	    
	    while(low <= high)
	    {
	      mid = (high - low)/2 + low;
	      
	      if(shiftArr[mid] == num ) return mid;
	      
	      else if(shiftArr[mid+1] < shiftArr[mid])
	      {
	        if(num < shiftArr[high]) low = mid +1;
	        else high = mid-1; 
	      }
	      else if(shiftArr[mid+1] > shiftArr[mid])
	      {
	        if( shiftArr[high] > shiftArr[mid])
	        {
	          if(num > shiftArr[mid]) low = mid +1;
	          else if (num == shiftArr[high]) return high;
	          else high = mid -1;
	        }
	        else
	        {
	          if(num < shiftArr[high]) low = mid + 1;
	          else if (num == shiftArr[high]) return high;
	          else high = mid -1;
	        }
	      }
	    }
	    return -1;
	  }
	     
}
