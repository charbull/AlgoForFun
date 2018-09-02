package com.test;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	Entry head;
	Entry tail;
	Map<Integer, Entry> map;
	int capacity = 0;
	int counter = 0;


	class Entry{
		int key;
		int value;
		Entry prev;
		Entry next;

		Entry(int key, int value)
		{
			this.key = key;
			this.value = value;
		}
	}

	private void removeEntry(Entry del)
	{
		del.next.prev = del.prev;
		del.prev.next = del.next;
	}

	private void addToHead(Entry e)
	{
		e.next = head.next;
		e.next.prev = e;
		e.prev = head;
		head.next = e;
	}

	public void put(int key, int value) {
		if (map.get(key) != null) {
			Entry e = map.get(key);
			e.value = value;
			removeEntry(e);
			addToHead(e);
		} else {
			Entry e = new Entry(key, value);
			map.put(key, e);
			if (counter < capacity) {
				counter++;
				addToHead(e);
			} else {
				map.remove(tail.prev.key);
				removeEntry(tail.prev);
				addToHead(e);
			}
		}
	}

	public int get(int key) {
		if (map.get(key) != null) {
			Entry e = map.get(key);
			int result = e.value;
			removeEntry(e);
			addToHead(e);
			return result;
		}
		return -1;
	}

	public LRUCache(int capacity) {
		this.capacity = capacity;
		head = new Entry(0,0);
		tail = new Entry(0,0);
		head.next = tail;
		tail.prev = head;
		head.prev = null;
		tail.next = null;
		counter = 0;
		map = new HashMap<Integer, Entry>();
	}


	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		System.out.println(cache.get(4)); 
	}

}
