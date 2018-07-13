package com.simple.test.map;

import java.util.HashMap;
import java.util.Map;

public class Permutations {

	public static void main(String[] args) {
		System.out.println(permutation("CAT", "CTA"));
		System.out.println(permutation("hello", "alloha"));
	}
	
	public static boolean permutation(String str1, String str2) {
	    

		if(str1.length() != str2.length()) return false;

		Map<Character, Integer> mapChar = new HashMap<Character, Integer>();
		Integer number = null;

		for(char c: str1.toCharArray())
		{
		    number = mapChar.get(c);
		    if(number == null)
		    {
		        mapChar.put(c, 1);
		    }
		    else{
		        mapChar.put(c, number+1);
		    }
		}

		for(char c: str2.toCharArray())
		{
		    number = mapChar.get(c);
		    if(number == null || number < 0)
		    {
		        return false;
		    }
		    else
		    {
		        mapChar.put(c, number-1);
		    }
		}

		long counter = mapChar.entrySet().parallelStream().
				filter(m-> m.getValue() != 0).map(x -> x.getValue()).count();
		if(counter != 0) return false;
		else return true;
		}
}
