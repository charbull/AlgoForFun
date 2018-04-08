package com.test;

public class IsBalancedParenthesis {

	public static void main(String[] args) {
		
		System.out.println(isBalanced("()[]{}")==true);
		System.out.println(isBalanced("(()[]{})")==true);
		System.out.println(isBalanced("(()[]{})(")==false);

	}

	static String open = "{[(";
	static String close = "}])";

	public static boolean isBalanced(String input) {
		return isBalancedHelper(input, 0, "");
	}

	private static boolean isBalancedHelper(String input, int inputIndex, String stack)
	{
		char expectedClose;
		
		if(inputIndex < input.length())
		{
			char currentInputChar = input.charAt(inputIndex);
			int posParanthesis = open.indexOf(""+currentInputChar);
			if(posParanthesis < 0)
			{
				posParanthesis = close.indexOf(""+currentInputChar);
				expectedClose = open.charAt(posParanthesis);
			}
			else expectedClose = close.charAt(posParanthesis);

			if(!stack.isEmpty() && stack.charAt(stack.length()-1) == expectedClose)
			{
				//remove last in the stack
				stack = stack.substring(0, stack.length()-1);
			}
			else
			{
				stack = stack + currentInputChar;
			}
			inputIndex++;
			return isBalancedHelper(input, inputIndex, stack);		
		}
		if(inputIndex == input.length() && stack.isEmpty()) return true;
		return false;
	}

}