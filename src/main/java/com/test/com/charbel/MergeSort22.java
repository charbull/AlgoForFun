package com.charbel;

public class MergeSort22 {

	
	
	
	public static void main(String[] args) {
		int[] array = new int [] {1,9,3,8,7,4};
		sort(array);
		print(array);
	}
	
	static void print(int[] t)
	{
		for(int i = 0; i< t.length; i++)
		{
			System.out.print(t[i]+", ");
		}
	}
	
	
	
	static void sort(int [] array)
	{
		int[] helper = new int[array.length];
		mergeSort(helper, array, 0, array.length-1);
	}


	private static void mergeSort(int[] helper, int[] array, int low, int high) {
		if(low<high)
		{
			int mid = (low+high)/2;
			mergeSort(helper, array, low, mid);
			mergeSort(helper, array, mid+1, high);
			merge(helper, array, low, high);
			print(array);
			System.out.println("\n");
		}
	}


	private static void merge(int[] helper, int[] array, int low, int high) {
		if(low<high)
		{
			for(int i=low; i<=high;i++)
			{
				helper[i] = array[i];
			}
			
			int left = low;
			int current = low;
			int mid = (low+high)/2;
			int right = mid+1;
			while(left <= mid && right <= high)
			{
				if(helper[left] <= helper[right])
				{
					array[current] = helper[left];
					left++;
				}
				else
				{
					array[current] = helper[right];
					right++;
				}
				current++;
			}
			
			int remaining = mid- left;
			for(int i = 0; i<= remaining; i++)
			{
				array[current+i] = helper[left+i];
			}
		}
	}
	
	
}
