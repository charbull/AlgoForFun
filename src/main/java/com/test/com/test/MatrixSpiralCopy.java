package com.test;

class MatrixSpiralCopy {

	static int[] spiralCopy(int[][] inputMatrix) {

		int m = inputMatrix[0].length;
		int n = inputMatrix.length;
		int numbers = (n)*(m);
		int[] spiral = new int[numbers];

		int num = 0;
		int i=0;
		int j=0;
		
		while(num < numbers)
		{
			while(i < m && num<numbers)
			{
				spiral[num] = inputMatrix[j][i];
				i++;
				num++;
			}
			i--;
			j++;
			while(j < n && num<numbers)
			{
				spiral[num] = inputMatrix[j][i];
				j++;
				num++;
			}
			j--;
			i--;
			while(i >= 0 && num<numbers)
			{
				spiral[num] = inputMatrix[j][i];
				i--;
				num++;
			}
			i=i+1;
			j=j-1;
			while(j > 0 && num<numbers)
			{
				spiral[num] = inputMatrix[j][i];
				j--;
				num++;
			}
			j= j+1;
			i=i+1;
			m--;
			n--;

		}
		return spiral;    
	}

	private static void printtable(int[] table)
	{
		for(int j=0; j<table.length;j++)
		{
			System.out.print(table[j]+", ");
		}
	}


	//	private static void printMatrix(int[][] matrix)
	//	{
	//		for(int i=0; i<matrix.length;i++)
	//		{
	//			for(int j=0; j<matrix[0].length;j++)
	//			{
	//				System.out.println(matrix[i][j]);
	//			}
	//		}
	//	}

	public static void main(String[] args) {
		int [][] matrix = {
				{1, 2, 3, 4}, 
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}};

		printtable(spiralCopy(matrix));
	}

}
