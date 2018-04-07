package com.data.structure;

import java.util.EmptyStackException;

public class MyQueue<T> {

	private static class QueueNode<T> {	
		private T data;
		private QueueNode<T> next;
		
		public QueueNode(T data) {
			this.data = data;
		}
	}
	
	private QueueNode<T> first;
	private QueueNode<T> last;
	//[newItem] [last, --(next)--> , First]
	//When you use the last to dequeue, you can't do last = last.prev, that's why it is better to use the
	//the last to enqueue when you have forward linkage and the first to dequeue
	public void enqueue(T data) {
		QueueNode<T> newItem = new QueueNode<T>(data);
		if(last != null){
			last.next = newItem;
		}
		last = newItem;
		
		if(first == null) {
			first = last;
		}
	}
	
	//[last, --(next)--> , First] [ItemDelete]
	//When you use the last to dequeue, you can't do last = last.prev, that's why it is better to use the
	//the last to enqueue when you have forward linkage.
	public T dequeue() {
		if(first == null) throw new EmptyStackException();
		T item = first.data;
		first = first.next;
		if(first == null) {last = null;}
		return item; }
}

