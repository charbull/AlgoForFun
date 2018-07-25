package com.simple.test.map;

import java.util.*;
import java.util.Map.*;
import java.util.stream.*;

public class MapManipulations {

	public static void main(String[] args) {
		int[] A = new int[] {1,2,1,3,4,3,4,5};
		singleNumber(A);
		singleNumberKeys(A);
	}

	public static int singleNumber(int[] A) {
	    
		Map<Integer, Integer> numbersMap = new HashMap<Integer, Integer>();

		for(int current: A)
		{
		    Integer currentInteger = new Integer(current);
		    Integer count = numbersMap.get(currentInteger);
		    if(count == null)
		    {
		        numbersMap.put(currentInteger, 1);
		    }
		    else numbersMap.put(currentInteger, count + 1);
		    
		}

		List<Integer> list = numbersMap.entrySet().parallelStream().filter(m -> m.getValue() == 1).map( m -> m.getKey()).collect(Collectors.toList());
		return list.get(0).intValue();

		}

	public static ArrayList<String> removeDuplicates(List<String> input) {

		Set<String> nonDuplicates = new LinkedHashSet<String>(input.size());

		nonDuplicates.addAll(input);

		return (ArrayList<String>) nonDuplicates.parallelStream().collect(Collectors.toList());

	}

	public static void singleNumberEntry(int[] A) {

		Map<Integer, Integer> numbersMap = new HashMap<Integer, Integer>();

		for (int current : A) {
			Integer currInteger = new Integer(current);
			Integer occuration = numbersMap.get(currInteger);
			if (occuration != null) {
				numbersMap.put(currInteger, occuration + 1);
			} else
				numbersMap.put(currInteger, 1);
		}

		List<Entry<Integer, Integer>> distinctNumbers = numbersMap.entrySet().parallelStream()
				.filter(m -> m.getValue() == 1).collect(Collectors.toList());

		for(Entry<Integer,Integer> entry : distinctNumbers)
		{
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}

	}

	// java.util.* and java.util.streams.* have been imported for this problem.
	// You don't need any other imports.

	public static ArrayList<String> removeDuplicates2(List<String> input) {
	    
	    Map<String, Integer> mapCounter = new HashMap<String,Integer>();
	    for(String s: input)
	    {
	        Integer counter = mapCounter.get(s);
	        if(counter == null)
	        {
	            mapCounter.put(s, 1);
	        }
	        else
	        {
	            mapCounter.put(s, counter+1);
	        }
	    }
	    int val = 1;
	    ArrayList<String> listString = (ArrayList<String>) mapCounter.entrySet().parallelStream().filter(x -> x.getValue() == val).map(x -> x.getKey()).collect(Collectors.toList());
	    Collections.sort(listString);
	    return listString;

	}

	public static void singleNumberKeys(int[] A) {

		Map<Integer, Integer> numbersMap = new HashMap<Integer, Integer>();

		for (int current : A) {
			Integer currInteger = new Integer(current);
			Integer occuration = numbersMap.get(currInteger);
			if (occuration != null) {
				numbersMap.put(currInteger, occuration + 1);
			} else
				numbersMap.put(currInteger, 1);
		}

		List<Integer> distinctNumbers = numbersMap.entrySet().parallelStream()
				.filter(m -> m.getValue() == 1).map(x -> x.getKey()).collect(Collectors.toList());

		for(Integer current : distinctNumbers)
		{
			System.out.println("Keys " +current);
		}

	}

}