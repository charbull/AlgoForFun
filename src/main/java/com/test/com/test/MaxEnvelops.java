package com.test;

public class MaxEnvelops {

	public static void main(String[] args) {
		int[][] envelopes = {{2, 3}, {6, 7}, {6, 4}, {5, 4}};
		System.out.println(maxEnvelopes(envelopes));
		int[][] envelopes2 = {{1,2},{2,3},{3,4},{3,5},{4,5},{5,5},{5,6},{6,7},{7,8}};
		System.out.println(maxEnvelopes(envelopes2));
		int[][] envelopes3 = {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
		System.out.println(maxEnvelopes(envelopes3));
	}

	public static int maxEnvelopes(int[][] envelopes) {

		//Sort the enveloprs
		int[][] helper = new int[envelopes.length][envelopes[0].length];
		mergeSort(envelopes, 0, envelopes.length-1, helper);
		//count them
		int count = 1;
		int i =0;
		int j = 0;
		j = i+1;
		while(i<envelopes.length && j<envelopes.length)
		{
			if(envelopes[i][0] < envelopes[j][0] && envelopes[i][1] < envelopes[j][1])
			{
				count = count+1;
				i = j;
				j =  i+1;
			}
			else j++;
		}
		return count>1? count : 0;

	}

	public static void mergeSort(int[][] envelopes, int low, int high, int[][] helper)
	{
		if(low< high)
		{
			int mid = (low+ high)/2;
			mergeSort(envelopes, low, mid, helper);
			mergeSort(envelopes, mid+1, high, helper);
			merge(envelopes, low, mid, high, helper);
		}
	}

	public static void merge(int[][] envelopes, int low, int mid, int high, int[][] helper)
	{
		for(int i=low; i<=high; i++)
		{
			helper[i][0] = envelopes[i][0];
			helper[i][1] = envelopes[i][1];
		}

		int leftHelper = low;
		int rightHelper = mid+1;
		int current = low;

		while(leftHelper <= mid && rightHelper <= high)
		{
			if(helper[leftHelper][0] < helper[rightHelper][0])
			{
				envelopes[current][0] = helper[leftHelper][0];
				envelopes[current][1] = helper[leftHelper][1];
				leftHelper++;
			}
			else if(helper[leftHelper][0] == helper[rightHelper][0])
			{
				if(helper[leftHelper][1] > helper[rightHelper][1])
				{
					envelopes[current][0] = helper[rightHelper][0];
					envelopes[current][1] = helper[rightHelper][1];
					rightHelper++;
				}
				else {
					envelopes[current][0] = helper[leftHelper][0];
					envelopes[current][1] = helper[leftHelper][1];
					leftHelper++;
				}
			}
			else
			{
				envelopes[current][0] = helper[rightHelper][0];
				envelopes[current][1] = helper[rightHelper][1];
				rightHelper++;
			}
			current++;
		}

		int remaining = mid - leftHelper;
		for(int i=0; i<=remaining; i++)
		{
			envelopes[current+i][0] = helper[leftHelper+i][0];
			envelopes[current+i][1] = helper[leftHelper+i][1];
		}

	}

}
