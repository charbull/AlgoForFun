package com.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSusbtringNoRepeatChar {

/*
 * Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", which the length is 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
	 public int lengthOfLongestSubstring(String s) {
	        if(s == null || s.isEmpty()) return 0;
	        Map<String, Integer> map = new HashMap<String, Integer>();
	        int j =0;
	        int count = 0;
	        
	        for(int i=0;i<s.length();i++)
	        {
	            char init = s.charAt(i);
	            StringBuilder sb = new StringBuilder(""+init);
	            j = i+1;
	            count = 1;
	            while(j<s.length() && (sb.indexOf(s.charAt(j)+""))== -1)
	            {
	             sb.append(s.charAt(j)+"");                
	             count = count + 1; 
	                j++;
	            }
	            map.put(sb.toString(), count);
	        }
	        return ((Integer)Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getValue()).intValue();
	    }
}
