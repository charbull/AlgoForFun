package com.simple.test.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Duplicates {

	public static String duplicate(int[] numbers){
	    

	Map<Integer, Integer> counterMap = new HashMap<Integer, Integer>();
	List<Integer> duplicates = new ArrayList<Integer>();

	for(int current: numbers)
	{
	    if(counterMap.get(current) == null)
	    {
	        counterMap.put(current, 1);
	    }
	    else{
	         counterMap.put(current, counterMap.get(current)+1);
	    }
	}

	for(int current: numbers)
	{
	     if(counterMap.get(current) > 1)
	     {
	         if(!duplicates.contains(current) ) duplicates.add(current);
	     }
	}

	Collections.sort(duplicates);
	return Arrays.toString(duplicates.toArray());
	}
	
	//TODO: look at this
	public static String duplicateBetter(int[] numbers){
		  TreeSet<Integer> result = new TreeSet<Integer>();
		  // Sort the array
		  Arrays.sort(numbers);
		  //Iterate over the array
		  for(int i = 1; i < numbers.length; i++) {
		      // If previous element is the same as current, its the duplicate element
		      if(numbers[i] == numbers[i - 1]) {
		          result.add(numbers[i]);
		      }
		  }
		  return result.toString();
		}
}


