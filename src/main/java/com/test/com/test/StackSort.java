package com.test;

import java.util.Stack;

public class StackSort {

	private static Stack<Integer> sOrderedDecrementally = new Stack<Integer>();

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(Integer.valueOf(4));
		s.push(Integer.valueOf(6));
		s.push(Integer.valueOf(2));
		s.push(Integer.valueOf(1));
		s.push(Integer.valueOf(5));
		s.push(Integer.valueOf(3));
		s.push(Integer.valueOf(7));

		printStack(s);
		printStack(sortStack(s));
		System.out.println("=======================");
		System.out.println(s.peek());

	}

	public static void printStack(Stack<Integer> s)
	{
		System.out.println("=======================");
		for(int i=0; i<s.size();i++)
		{
			System.out.println(i+" - "+s.get(i).intValue());
		}
	}
	public static Stack<Integer> sortStack(Stack<Integer> s)
	{
		Stack<Integer> r = new Stack<Integer>();
		Integer top;
		while(!s.isEmpty())
		{
			top = s.pop();
			while(!r.isEmpty() && top < r.peek())
			{
				s.push(r.pop());
			}
			r.push(top);
			
		}
		while(!r.isEmpty())
		{
			s.push(r.pop());
		}
		
		return s;
	}

	public static Stack<Integer> sortStackWrong(Stack<Integer> s)
	{
		Integer peek1, top1;
		while(!s.isEmpty())
		{
			top1 = s.pop();
			//last Element left
			if(s.empty()) insertDecrementallyWrong(top1);
			else
			{
				peek1 = s.peek();

				if(top1<peek1)
				{
					insertDecrementallyWrong(top1);
				}
				else
				{
					peek1 = s.pop();
					s.push(top1);
					insertDecrementallyWrong(peek1);
				}
			}
		}
		while(!sOrderedDecrementally.isEmpty())
		{
			s.push(sOrderedDecrementally.pop());
		}
		return s;
	}


	public static void insertDecrementallyWrong(Integer top1)
	{
		Integer top2, peek2;
		if(!sOrderedDecrementally.isEmpty())
		{
			peek2 = sOrderedDecrementally.peek();
			if(top1 > peek2)
			{
				sOrderedDecrementally.push(top1);
			}
			else
			{
				top2 = sOrderedDecrementally.pop();
				sOrderedDecrementally.push(top1);
				sOrderedDecrementally.push(top2);
			}
		}
		else sOrderedDecrementally.push(top1);
	}
}
