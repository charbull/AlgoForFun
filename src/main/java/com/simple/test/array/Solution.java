package com.simple.test.array;
class Solution {
    
	public static void main(String[] args) {
		System.out.println(multiply("123", "6"));
	}
	
	  public static String multiply(String num1, String num2) {
	        int sum = 0;
	        for(int i=num1.length(); i>0 ; i--){
	            int currentNumber = convertAsciiToInt(num1.charAt(i-1));
	            for(int j=num2.length(); j>0 ; j--){
	                sum = (int) ((int) (sum + convertAsciiToInt(num2.charAt(j-1)) * currentNumber)* Math.pow(10, num2.length()-(j)));
	            }
	            sum = sum*10;
	        }
	            return new String()+sum;
	        }   
	    
	    
	    
	    public static int convertAsciiToInt(char c )
	    {
	        return (c - 48);
	    }
}