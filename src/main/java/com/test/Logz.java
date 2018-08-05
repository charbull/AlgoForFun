package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Logz {

	static String[] logs = {"g12 123 4356", "t65 abc def", "w32 abc dee", "iol2 klm 3es", "das klm abc", "g234 453 23"};

	public static void main(String[] args) {
		List<String> result = sortLogs(Arrays.asList(logs));
		for(String s: result)
		{
			System.out.println(s);
		}
		
	}

	private static List<String> sortLogs(List<String> logList) {
		List<String> numericLogs = new ArrayList<String>();
		List<String> alphaNumericLogs = new ArrayList<String>();
		for(String log : logList)
		{
			if(isNumeric(log))
			{
				numericLogs.add(log);
			}
			else
			{
				alphaNumericLogs.add(log);
			}
		}

		String[] logs = alphaNumericLogs.toArray(new String[0]);
		for(int i=0; i<logs.length;i++)
		{
			for(int j=0; j<logs.length-1;j++)
			{
				if(!isLeftTo(logs[j+1], logs[j]))
				{
					String temp = logs[j+1];
					logs[j+1] = logs[j];
					logs[j] = temp;
				}
			}
		}
		
		List<String> listResult = new ArrayList<String>();
		Collections.addAll(listResult, logs);
		listResult.addAll(numericLogs);
		return listResult;
	}

	private static boolean isNumeric(String log)
	{
		String[] logTable = log.split(" ");
		String charTable = logTable[1];
		for(char c: charTable.toCharArray()) {
			if(c-'0' > 9 || c-'0' < 0) return false;
		}
		return true;
	}

	private static boolean isLeftTo(String o1, String o2) {
		String log1 = o1.substring(o1.indexOf(" "));
		String log2 = o1.substring(o2.indexOf(" "));

		int l = Math.min(log1.length(), log2.length())-1;
		int i = 0;
		while(log1.charAt(i) <= log2.charAt(i) && i<l) i++;

		if(log1.charAt(i) > log2.charAt(i)) return false;
		return true;
	}




}
