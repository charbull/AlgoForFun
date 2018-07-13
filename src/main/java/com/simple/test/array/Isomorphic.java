package com.simple.test.array;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {

	public static void main(String[] args) {
		
	}
	
	public static boolean isIsomorphic(String input1, String input2) {
		 
		 if(input1.length() != input2.length()) return false;
		 
		 Map<Character, Character> mapping = new HashMap<Character, Character>();
		 
		 for(int i=0; i<input1.length(); i++)
		 {
		     char c1 = input1.charAt(i);
		     char c2 = input2.charAt(i);
		     Character mapChar = mapping.get(c1);
		     if(mapChar == null)
		     {
		         mapping.put(c1, c2);
		     }
		     else
		     {
		         if(mapChar.charValue() != c2) return false;
		     }
		 }
		 return true;
		    
		}

		public static boolean alreadyMapped(Map<Character, Character> m, Character c)
		{
		   return (m.entrySet().parallelStream().filter( x -> x.getValue() == c).map(x -> x.getKey()).count() == 0)? false: true;
		}
	
}
