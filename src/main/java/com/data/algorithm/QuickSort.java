package com.data.algorithm;

public class QuickSort {

	static int[] table = new int[] {9, 6, 5, 1, 10, 7, 2, 3, 4};



	public static void main(String[] args) {
		quickSort(table, 0, table.length-1);
		printTable(table);
	}




	public static void quickSort(int[] table, int left, int right){
		int index = partition(table, left, right);
		if(left < index - 1) {
			quickSort(table, left, index-1);
		}
		if(index < right) {
			quickSort(table, index, right);
		}
	}
	
	public static int partition(int[] table, int left, int right) {
		int pivot = table[(left+right)/2];
		while(left<= right) {
			//find element on the left should be on the right
			while(table[left] < pivot) left++;
			while(table[right] > pivot) right--;
			//swap
			if(left <= right)
			{
				swap(table, left, right);
				left++;
				right--;
			}
		}
		return left;
	}


	private static void swap(int[] table, int left, int right) {
		int temp = table[left];
		table[left] = table[right];
		table[right] = temp;
	}




	public static void printTable(int[] t)
	{
		System.out.print("[");
		for(int i=0;i<t.length-1;i++) System.out.print(t[i]+", ");
		System.out.println(t[t.length-1]+"]");
	}

}
