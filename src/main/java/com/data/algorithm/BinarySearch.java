package com.data.algorithm;

public class BinarySearch {

	static int[] table = new int[] {1, 2, 3, 4, 5, 6, 7, 9, 10};

	public static void main(String[] args) {

		int index = binarySearch(table, 7);
		System.out.println("Index is "+index);
	}

	private static int binarySearch(int[] a, int key) {

		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			// Key is in a[lo..hi] or not present.
			int mid = lo + (hi - lo) / 2;
			if      (key < a[mid]) hi = mid - 1;
			else if (key > a[mid]) lo = mid + 1;
			else return mid;
		}
		return -1;
	}
}
