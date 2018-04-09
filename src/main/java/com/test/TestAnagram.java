package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestAnagram {

	public static void main(String[] args) {
		//	boolean answer = anagram("acta", "cat");
		//	System.out.println(answer);

//		int [][] matrix = {
//				{6, 2, 4}, 
//				{1, 2, 3},
//				{9, 8, 0}
//		};
//		matrixZero(matrix);
		List<String> listOfString = Arrays.asList("Charbel", "Bob", "Charbel");
		List<String> duplicates = removeDuplicates(listOfString);
		for (String currentString : duplicates) {
			System.out.println(currentString);
		}
	}
	

	
	public static List<String> removeDuplicates(List<String> list)
	{
		return list.parallelStream().map(x -> x.toString()).distinct().collect(Collectors.toList());
	}

	public static void printMatrix(int[][] matrix)
	{
		for (int i = 0; i < matrix.length; i++) 
		{ 
			System.out.print("{");
			for (int j = 0; j < matrix.length; j++) { 
				System.out.print(" "+matrix[i][j]+" "); 
			}
			System.out.println("}");
		}
	}

	public static void matrixZero(int [][]matrix)
	{
		for (int i = 0; i < matrix.length; i++) 
		{
			for (int j = 0; j < matrix.length; j++)
			{
				
			}
		}
	}
	
//	public static int[][] rotateMatrix90(int [][]matrix)
//	{
//		int numberOfPermutation = matrix.length -1;
//		for(int i=0;i<matrix.length;i++)
//		{
//			for (int j = 0; j < matrix.length; j++) { 
//				int[] temp = [j];
//			}
//		}*/
//
//
//		printMatrix(matrix);
//		return matrix;
//	}




	public static boolean anagram(String s, String t) {

		if(s.length() != t.length()) return false;

		char[] s_array = s.toCharArray();
		char[] t_array = t.toCharArray();

		int[] numberOfChars = new int[256];
		//Count the number of double characters
		for(int j=0; j<s.length(); j++)
		{
			++numberOfChars[s_array[j]];
		}

		for(int i=0; i< t.length(); i++)
		{
			char currentChar = t_array[i];
			--numberOfChars[currentChar];
			if(numberOfChars[currentChar] <0)
			{
				return false;
			}
		}
		return true;
	}

}
