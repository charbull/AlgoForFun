package com.test;

import java.util.Arrays;

public class WordSimilarityRecursive {

	public static void main(String[] args) {
		System.out.println(editDistance("sale", "sales"));
		System.out.println(editDistance("sales", "sales"));
		System.out.println(editDistance("dsale", "sales"));
		System.out.println(editDistance("saturday","sunday"));
		System.out.println(editDistance("ATGCATGGCCAATTGCCAAT","ATCGATCGATCG"));
	}

	// java.util.* and java.util.streams.* have been imported for this problem.
	// You don't need any other imports.

	public static int editDistance(String a, String b){

		int la = a.length();
		int lb = b.length();
		int[][] mem = new int[la+1][lb+1];
		for( int[] m : mem)
		{
			Arrays.fill(m, -1);
		}
		return editDistance(a, b, 0, 0, mem);
	}


	public static int editDistance(String a, String b, int ia, int ib, int[][] mem)
	{
		int la = a.length();
		int lb = b.length();
		if(ia <= la-1 && ib <= lb-1)
		{
			if(mem[ia][ib]>=0) return mem[ia][ib]; 
			if(a.charAt(ia) == b.charAt(ib))
			{
				if(mem[ia+1][ib+1] < 0) mem[ia+1][ib+1] = editDistance(a, b, ia+1, ib+1, mem);
				return mem[ia+1][ib+1];
			}
			else
			{   
				if(mem[ia][ib+1]<0)
				{
					mem[ia][ib+1] = editDistance(a, b, ia, ib+1, mem);
				}
				if(mem[ia+1][ib]<0)
				{
					mem[ia+1][ib] = editDistance(a, b, ia+1, ib, mem);
				}
				if(mem[ia+1][ib+1]<0)
				{
					mem[ia+1][ib+1] = editDistance(a, b, ia+1, ib+1, mem);
				}
				mem[ia][ib] = 1 + Math.min(mem[ia][ib+1],
						Math.min(mem[ia+1][ib], mem[ia+1][ib+1]));
				return mem[ia][ib];
			}
		}
		else
		{
			if(mem[ia][ib]>=0) return mem[ia][ib]; 
			if(ia > la-1 && ib <=lb-1) return lb-ib;
			else if(ib > lb-1 && ia <= la-1) return la-ia;
			else return 0;
		}
	}
}
