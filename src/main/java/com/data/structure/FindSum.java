package com.data.structure;

import java.util.LinkedList;
import java.util.Queue;

public class FindSum {

	public static int[] findSum(NGraph root, int depth)
	{
		int[] result = new int[depth];
		int level = 0;

		if(root != null)
		{
			result[level]= root.data;
			Queue<NGraph> queue = new LinkedList<NGraph>();
			queue.add(root);
			queue.add(null);
			level = level+1;
			while(!queue.isEmpty())
			{
				NGraph current = queue.remove();
				if(current != null)
				{
					if(current.children != null)
					{
						for(NGraph child : current.children)
						{
							result[level] = child.data + result[level];
							queue.add(child);
						}
						queue.add(null);
					}
				}
				else level = level +1;

			}
		}
		return result;
	}

	public static void main(String[] args) {
		NGraph n0 = new NGraph(3);
		NGraph n1 = new NGraph(1);
		NGraph n2 = new NGraph(5);
		NGraph n3 = new NGraph(10);
		n0.addChild(n1);
		n0.addChild(n2);
		n0.addChild(n3);
		NGraph n4 = new NGraph(6);
		n1.addChild(n4);
		NGraph n5 = new NGraph(1);
		n2.addChild(n5);
		NGraph n6 = new NGraph(4);
		n2.addChild(n6);
		NGraph n7 = new NGraph(5);
		n3.addChild(n7);

		int[] result = findSum(n0, 3);
		System.out.println("[");
		for(int i : result)
		{
			System.out.println(i+", ");
		}
		System.out.println("]");


	}

}
