package com.test;

import java.util.Stack;

public class IsBalancedParenthesisFaster {

	public static void main(String[] args) {
		
		System.out.println(isBalanced("()[]{}")==true);
		System.out.println(isBalanced("(()[]{})")==true);
		System.out.println(isBalanced("(()[]{})(")==false);

	}

	public static boolean isBalanced(String s) {
        Stack<Character> st=new Stack<>();
        for (char c:s.toCharArray()){
            if (c=='(') st.push(')');
            else if (c=='[') st.push(']');
            else if (c=='{') st.push('}');
            else {
                if (st.isEmpty()) return false;
                if (c==st.peek()) st.pop();
                else return false;
            }
        }
        return st.isEmpty();
    }
}