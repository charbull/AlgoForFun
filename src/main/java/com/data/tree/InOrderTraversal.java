package com.data.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.data.structure.TreeNode;

public class InOrderTraversal {

	public static List<Integer> traverseInOrder(TreeNode root)
	{
		List<Integer> res = new ArrayList<Integer>();
		
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		boolean done = false;
		TreeNode current = root;
		while(!done)
		{
			if(current != null)
			{
				//push and keep going left
				stack.push(current);
				current = current.left;
			}
			else
			{
				if(stack.isEmpty()) done = true;
				else
				{
					current = stack.pop();
					res.add(current.data);
					current = current.right;
				}
			}
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		TreeNode n3 = new TreeNode(3);
		TreeNode n2 = new TreeNode(2);
		TreeNode n1 = new TreeNode(1);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		
		n3.left = n6;
		n3.right = n7;
		
		List<Integer> list = traverseInOrder(n1);
		for(int i : list)
		{
			System.out.print(i+", ");
		}
		

	}
	
}
