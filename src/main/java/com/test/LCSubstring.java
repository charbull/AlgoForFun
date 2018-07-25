package com.test;

public class LCSubstring {

	public static void main(String[] args) {
		String[] list = {"reflower", "flow", "flight"};
		System.out.println("LCP " +longestCommonPrefix(list));
		String[] list2 = {"flower", "flow", "flight"};
		System.out.println("LCP2 " +longestCommonPrefix(list2));
	}
	 public static String longestCommonPrefix(String[] strs) {
	       if(strs == null) return "";
	        int len = strs.length;
	        if(len == 0) return "";
	        if(len == 1) return strs[0];
	        String prefix = strs[0]; 
	        for(int i=1; i<strs.length;i++ )
	        {
	            prefix = longestCommonPrefix(prefix, strs[i], 0, 0);
	        }
	        return prefix;
	    }
	    
	    
	    private static String longestCommonPrefix(String s1, String s2, int i1, int i2)
	    {
	        if(i1 >= s1.length() || i2 >= s2.length()) return "";
	        if(s1.charAt(i1) == s2.charAt(i2))
	        {
	            return s1.charAt(i1) + longestCommonPrefix(s1, s2, i1+1, i2+1);
	        }
	        else
	        {
	            String o1 = longestCommonPrefix(s1, s2, i1+1, i2+1);
	            String o2 = longestCommonPrefix(s1, s2, i1, i2+1);
	            String o3 = longestCommonPrefix(s1, s2, i1+1, i2);
	            int max = Math.max(Math.max(o1.length(), o2.length()), o3.length());
	            if(max == o1.length()) return o1;
	            if(max == o2.length()) return o2;
	            else return o3; 
	        }
	    }
}
