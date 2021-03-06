package com.test;

public class WordSimilarity {

	static int[][] memo;
	public static void main(String[] args) {
		editDistance("sale", "sales");
		printMemo();

	}
	
	/*
	 * Edit distance is a classic algorithm that is used in many applications, including Spell Correction, DNA Sequencing and Natural Language Processing. Given two Strings, a and b, write a method - editDistance that returns the minimum number of operations needed to transform a into b. The following character operations are allowed : 

a) Replace character
b) Insert character
c) Delete character

Examples : 

editDistance("sale", "sales") => 1

Operations : 
1) Insert "s"

editDistance("sale", "sold") => 2

Operations : 
1) Replace "a" with "o"
2) Replace "e" with "d"

editDistance("sa", "s") => 1

Operations : 
1) Delete "a"
	 * 
	 * */

	public static void printMemo()
	{
		for(int i=0;i<memo[0].length-1;i++)
		{
			for(int j=0;j<memo[1].length;j++)
			{
				System.out.print(" "+memo[i][j]);
			}
			System.out.println();
		}
	}
	
	public static int editDistance(String a, String b){
		int lenA = a.length(), lenB = b.length();
		memo = new int[lenA+1][lenB+1];
		// Prefill first row and column
		for(int i = 1; i <= lenA; i++) memo[i][0] = i;
		for(int j = 1; j <= lenB; j++) memo[0][j] = j;
		// Traverse and fill cells
		for(int i = 1; i <= lenA; i++){
			char cA = a.charAt(i-1);
			for(int j = 1; j <= lenB; j++){
				char cB = b.charAt(j-1);
				if(cA == cB){
					memo[i][j] = memo[i-1][j-1];
				}
				else {
					int replaceDist = 1 + memo[i-1][j-1];
					int insertDist = 1 + memo[i][j-1];
					int deleteDist = 1 + memo[i-1][j];
					int minDist = Math.min(replaceDist,Math.min(insertDist, deleteDist));
					memo[i][j] = minDist;
				}
			}
		}
		return memo[lenA][lenB];
	}

}
