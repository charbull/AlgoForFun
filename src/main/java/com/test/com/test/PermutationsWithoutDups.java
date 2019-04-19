package com.test;

import java.util.ArrayList;
import java.util.List;

public class PermutationsWithoutDups {

	public static void main(String[] args) {
		List<String> permutedList = permute("abcd");
		printList(permutedList);
	}


	private static void printList(List<String> list)
	{
		int i =0;
		for(String current : list)
		{
			System.out.println(i+":"+current);
			i++;
		}
	}

	private static List<String> permute(String s)
	{
		List<String> permutations = new ArrayList<String>();
		List<String> permutationsChild;

		if (s.length()  <= 1) permutations.add(s);
		else {
			permutationsChild = permute(s.substring(0, s.length()-1));
			char last = s.charAt(s.length()-1);

			List<String> tempList = insertCharacterInList(last, permutationsChild);
			for(String current : tempList)
			{
				permutations.add(current);
			}
		}
		return permutations;
	}


	private static List<String> insertCharacterInList(char c, List<String> permutatedStringList)
	{
		List<String> list = new ArrayList<String>();
		for(String current : permutatedStringList)
		{
			List<String> listtemp = insertCharacter(c, current);
			for(String currentTemp : listtemp)
			{
				list.add(currentTemp);
			}
		}
		return list;
	}

	private static List<String> insertCharacter(char c, String permutatedString)
	{
		List<String> insertedPermutatedString = new ArrayList<String>();
		for(int j=0; j<permutatedString.length(); j++)
		{
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<permutatedString.length(); i++)
			{
				if(i == j)
				{
					sb.append(c);
				}
				sb.append(permutatedString.charAt(i));
			}
			insertedPermutatedString.add(sb.toString());
		}
		insertedPermutatedString.add(permutatedString+c);
		return insertedPermutatedString;
	}
}