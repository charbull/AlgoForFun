package com.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintValidParentheses {

	public static void main(String[] args) {
		printList(printValidParetheses(3));
		printList(printValidParetheses(4));
	}

	private static void printList(Set<String> list)
	{
		int i =0;
		for(String current : list)
		{
			System.out.println(i+":"+current);
			i++;
		}
	}

	public static Set<String> printValidParetheses(int number)
	{
		Set<String> permutationsList = new HashSet<String>();
		if(number <= 1) permutationsList.add("()");
		else
		{
			Set<String> previousPermutations =  printValidParetheses(number-1);
			for(String current : previousPermutations)
			{
				List<String> tempList = insert(current, "()");
				for(String recentPerm : tempList)
				{
						permutationsList.add(recentPerm);
				}
			}

		}
		return permutationsList;
	}

	private static List<String> insert(String s, String previous)
	{
		List<String> listWithPermutations = new ArrayList<String>(s.length()*previous.length());
		for(int i=0; i<s.length();i++)
		{
			listWithPermutations.add(insert(s, previous, i));
		}
		return listWithPermutations;
	}

	private static String insert(String s, String toInsert, int index)
	{
		String start = s.substring(0, index);
		String last = toInsert + s.substring(index);
		return start + last;
	}

}
