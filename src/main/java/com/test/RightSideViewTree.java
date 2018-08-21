package com.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.data.structure.TreeNode;

public class RightSideViewTree {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		TreeNode n11 = new TreeNode(11);
		TreeNode n13 = new TreeNode(13);
		TreeNode n14 = new TreeNode(14);

		n1.left = n2;
		n1.right = n3;
		n2.left = n5;
		n2.right = n7;
		n3.right = n4;
		n4.right = n6;
		n5.left = n11;
		n7.left = n8;
		n8.left = n9;
		n8.right = n10;
		n11.left = n13;
		n13.left = n14;

		List<List<Integer>> levels = fillTree(n1);
		
		for(List<Integer> level : levels)
		{
			for(Integer i : level) 
			{
				System.out.print(i+" , ");
			}
			System.out.println();
		}
		
		List<Integer> rightSide = righSideView(n1);
		System.out.println("\nRight side is : ");
		for(Integer i : rightSide)
		{
			System.out.print(i+ " , ");
		}
		

	}
	
	private static List<Integer> righSideView(TreeNode n)
	{
		List<List<Integer>> levels = fillTree(n);
		List<Integer> rightSide = new ArrayList<Integer>();
		for(List<Integer> level : levels)
		{
			rightSide.add(level.get(level.size()-1));
		}
		return rightSide;
	}
	

	private static List<List<Integer>> fillTree(TreeNode n)
	{
		List<List<Integer>> listLevels = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<>();
		List<Integer> level = new ArrayList<>();
		queue.add(n);
		queue.add(null);
		while(!queue.isEmpty())
		{
			TreeNode current = queue.poll();
			if(current != null)
			{
				level.add(current.data);
				if(current.left != null) queue.add(current.left);
				if(current.right != null) queue.add(current.right);
			}
			else
			{
				listLevels.add(level);
				level = new ArrayList<Integer>();
				if(!queue.isEmpty()) queue.add(null);
			}
		}
		
		return listLevels;
	}
}
