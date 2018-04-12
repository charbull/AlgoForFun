package com.data.algorithm;

public class MergeSort {

	static int[] table = new int[] {9, 6, 5, 1, 10, 7, 2, 3, 4, 8};
	static int[] helper;

	public static void main(String[] args) {
		mergeSort(table);
		printTable(table);
	}


	private static void mergeSort(int[] t) {
		int min = 0;
		helper = new int[t.length];
		int max = t.length-1;
		mergeSort(t, helper, min, max);
	}




	private static void mergeSort(int[] t, int[] helper, int min, int max) {
		if(min< max)
		{
			int middle = (max+min)/2;
			mergeSort(t, helper, min, middle);
			mergeSort(t, helper, middle+1, max);
			merge(t, helper, min, middle, max);
		}
	}

	public static void merge(int[] t, int[] helper, int min, int middle, int max) {

		//copy both into the helper
		for(int i= min; i<=max; i++)
		{
			helper[i] = t[i];
		}

		int helperLeft = min;
		int helperRight = middle +1;
		int current = min;

		//iterate through the helper array and comparing left and right half.
		//Copy back the smaller element from the two halves into the original array
		while(helperLeft <= middle && helperRight <= max) {
			//if left < right then copy it in the current
			if(helper[helperLeft] <= helper[helperRight]){
				t[current] = helper[helperLeft];
				helperLeft++;
			} else { //copy the right in the current since it is higher then left
				t[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}
		//copy the remaining left side, the right is already there, since we updated just the left
		int remaining = middle - helperLeft;
		for(int i=0; i<= remaining; i++) {
			t[current+i] = helper[helperLeft + i];
		}
	}

	public static void printTable(int[] t)
	{
		System.out.print("[");
		for(int i=0;i<t.length-1;i++) System.out.print(t[i]+", ");
		System.out.println(t[t.length-1]+"]");
	}

}
