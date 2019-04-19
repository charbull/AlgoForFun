package com.test;

public class rotate90 {

	public static void main(String[] args) {
		int [][] matrix = {
				{1, 2, 3, 4}, 
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}};

		printMatrix(matrix);
		matrix = rotateMatrix90(matrix);
		printMatrix(matrix);

	}


	public static int[][] rotateMatrix90_2(int[][] matrix)
	{
		int len = matrix.length;
		int [][] matrix2 = new int[len][len];
		for(int i=0; i<len; i++)
		{
			for(int j=0; j< len ;j++)
			{
				matrix2[j][len-1-i] = matrix[i][j];
			}
		}
		return matrix2;
	}



	public static int[][] rotateMatrix90(int[][] matrix)
	{
		int temp;
		int offset;
		int len = matrix.length;
		for(int i=0; i<matrix.length/2; i++)
		{
			//the last element is exchanged with another one, there is no need to go to the end of the array.
			//it is a circular motion, the len-1 is reach when i=0 and then exchanged with all, no need to revisit
			//thats why len-1-i
			for(int j=i; j< len-1-i ;j++)
			{
				offset = j - i;
				//top cache
				temp = matrix[i][j];
				//left --> top
				matrix[i][j]= matrix[len-1-i -offset][i];
				//bottom -->left
				matrix[len-1-i -offset][i] = matrix[len-1-i][len-1-i -offset]; 
				//right --> bottom
				matrix[len-1-i][len-1-i -offset] = matrix[j][len-1-i];
				// top --> right
				matrix[j][len-1-i] = temp;
			}
		}
		return matrix;
	}


	public static void printMatrix(int[][] matrix)
	{
		System.out.println("===");
		for (int i = 0; i < matrix.length; i++) 
		{ 
			System.out.print("{");
			for (int j = 0; j < matrix.length; j++) { 
				System.out.print(" "+matrix[i][j]+" "); 
			}
			System.out.println("}");
		}
	}

}
