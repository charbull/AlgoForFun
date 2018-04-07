package com.data.structure;

import java.util.EmptyStackException;

public class MyStack<T> {

	//Definition
	private static class StackNode<T>{
		private T data;
		private StackNode<T> next;
		
		public StackNode(T data)
		{
			this.data = data;
		}
	}
	
	private StackNode<T> top;
	
	//Pop
	public T pop()
	{
		if(top == null) throw new EmptyStackException();
		else {
			T item = top.data;
			top = top.next;
			return item; 
		}
	}
	
	public void push(T item)
	{
		StackNode<T> newItem = new StackNode<T>(item);
		newItem.next = top;
		top = newItem;
	}
	
	public T peek()
	{
		if(top == null) throw new EmptyStackException();
		return top.data;
	}
	
	public boolean isEmpty()
	{
		return top == null;
	}
	
	
	
	
}
