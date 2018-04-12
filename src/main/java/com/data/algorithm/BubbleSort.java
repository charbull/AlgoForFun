package com.data.algorithm;

public class BubbleSort {

	static int[] table = new int[] {9, 6, 5, 1, 10, 7, 2, 3, 4};

	public static void main(String[] args) {
		bubbleSort(table);
		printTable(table);
	}


	public static void printTable(int[] t)
	{
		System.out.print("[");
		for(int i=0;i<t.length-1;i++) System.out.print(t[i]+", ");
		System.out.println(t[t.length-1]+"]");
	}

	public static void bubbleSort(int[] t)
	{
		for(int i=0;i<t.length;i++)
		{
			for(int j=0; j<t.length-1; j++)
			{
				if(t[j]>t[j+1])
				{
					int temp = t[j+1];
					t[j+1] = t[j];
					t[j] = temp;
				}
			}
			
		}
	}

}
