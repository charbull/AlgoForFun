package com.test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicatesIn2SortedArrays {


	/*
	 * 
	 * Find The Duplicates

Given two sorted arrays arr1 and arr2 of passport numbers, implement a function findDuplicates that returns an array of all passport numbers that are both in arr1 and arr2. Note that the output array should be sorted in an ascending order.

Let N and M be the lengths of arr1 and arr2, respectively. Solve for two cases and analyze the time & space complexities of your solutions: M ≈ N - the array lengths are approximately the same M ≫ N - arr2 is much bigger than arr1.

Example:

input:  arr1 = [1, 2, 3, 5, 6, 7], arr2 = [3, 6, 7, 8, 20]

output: [3, 6, 7] # since only these three values are both in arr1 and arr2

Constraints:

    [time limit] 5000ms

    [input] array.integer arr1
        1 ≤ arr1.length ≤ 100

    [input] array.integer arr2
        1 ≤ arr2.length ≤ 100

    [output] array.integer


	binary Search m => O( log m)
	iterate O(n) we should leverage the bigger array
	1- pick the array which has the min length
	2- for each element of the array, perform a binarySearch on the second array which is longer
	3- if number is found, add it to the result
	O(n * log m)
	n is the larger array

	Unfortunately, I don't believe there really is a better way of doing this due to the nature of Java's handling of primitive types, boxing, arrays and generics. In particular:

	List<T>.toArray won't work because there's no conversion from Integer to int
	You can't use int as a type argument for generics, so it would have to be an int-specific method (or one which used reflection to do nasty trickery).
	I believe there are libraries which have autogenerated versions of this kind of method for all the primitive types (i.e. there's a template which is copied for each type). It's ugly, but that's the way it is I'm afraid :(

	Even thoug
	 */ 


	static int[] findDuplicates(int[] arr1, int[] arr2) {

		int max = Math.max(arr1.length, arr2.length);
		int[] binarySearch;
		int[] iterate;
		List<Integer> listResult = new ArrayList<Integer>();
		if(max == arr1.length)
		{
			binarySearch = arr1;
			iterate = arr2;
		}
		else
		{
			binarySearch = arr2;
			iterate = arr1;
		}

		for(int i=0; i<iterate.length; i++)
		{
			int num = iterate[i];
			int result = Arrays.binarySearch(binarySearch, num);
			if(result >=0) listResult.add(num);
		}	
		return listResult.stream().mapToInt(i -> i.intValue()).toArray();

	}

	public static void main(String[] args) {

	}
}
