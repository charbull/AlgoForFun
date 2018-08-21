package com.test;

import java.util.ArrayList;
import java.util.List;

public class PrisonBreak {

	public static void main(String[] args) {
		List<Integer> h = new ArrayList<Integer>();
		h.add(1);
		h.add(2);
		h.add(3);

		List<Integer> v = new ArrayList<Integer>();
		v.add(1);
		v.add(2);


		System.out.println(prisonBreak(3,  2,  h, v));
	}


	public static long prisonBreak(int n, int m, List<Integer> h, List<Integer> v)
	{
		int[] nTab = new int[n+1];
		int[] mTab = new int[m+1];

		for(int i=0; i<h.size(); i++)
		{
			nTab[h.get(i)] = 1;
			nTab[h.get(i)-1] = 1;
		}

		for(int i=0; i<v.size(); i++)
		{
			mTab[v.get(i)] = 1;
			mTab[v.get(i)-1] = 1;
		}

		//find consecutive numbers, longest segment
		int hor = longestSegment(nTab);
		int ver = longestSegment(mTab);

		return hor*ver;
	}


	private static int longestSegment(int[] tab)
	{
		int i=0;
		int segment = 0;
		int maxSegment = 0;
		while(i<tab.length)
		{
			if(tab[i] == 1)
			{
				segment = segment+1;
			}
			else
			{
				segment = 0;
			}
			maxSegment = Math.max(maxSegment, segment);
			i++;
		}
		return maxSegment;
	}

}
