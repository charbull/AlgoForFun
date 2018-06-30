package com.simple.test.array;

public class SimpleArrayTests {

	public static void main(String[] args) {
		isUniqueTest();
	}

	public static void isUniqueTest() {
		try {
			System.out.println(isUnique("charbel"));
			System.out.println(isUnique("sentence"));
		} catch (Exception e) {
			e.printStackTrace();
			}

	}

	//FIXME: this is not optimal O(n2)
	public static boolean isUnique(String s) {
		char[] charArray = s.toCharArray();
		for(int i=0; i<charArray.length; i++) { //O(n)
			for(int j=0; j<charArray.length; j++) { //O(n)
				if(i!= j && charArray[i]== charArray[j]) return false;
			}
		}
		return true;
	}
}
