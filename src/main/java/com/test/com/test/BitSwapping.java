package com.test;

public class BitSwapping {


	/*
	 * Given a 32 bit integer input x, swap its odd and even bits and return the resulting integer. (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).

For example:

x = 5, Binary code = 0101
swapOddEvenBits(5) --> 10
Binary representation of 10 = 1010
	 * */

	public static int swapOddEvenBits(int x){
		//Add your code below this line
		return ((x & 0xaaaaaaaa) >> 1 | ((x & 0x5555555) << 1));
		//Add your code above this line
	}

}
