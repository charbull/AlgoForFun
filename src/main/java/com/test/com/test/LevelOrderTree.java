package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.data.structure.TreeNode;

public class LevelOrderTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.left.right = null;
		root.left.left = null;
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(20);
		
		levelOrder(root);
	}
	
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> listToReturn = new ArrayList<List<Integer>>();

		if (root != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.push(root);
			int numbers = 1;
			int i = 0;
			int nPushed = 0;
			while (!stack.isEmpty()) {
				List<Integer> currentList = new ArrayList<Integer>();
				while (i < numbers) {
					TreeNode current = stack.pop();
					System.out.println("i " + i + " , numbers " + numbers);

					i = i + 1;
					if (current != null) {
						System.out.println("current " + current.data);
						if (!stack.isEmpty())
							System.out.println("next " + stack.peek().data);
						currentList.add(current.data);
						if(current.right != null) 
							{
							 stack.push(current.right);
							 nPushed++;
							}
						if(current.left != null)
						{
							stack.push(current.left);
							nPushed += 1;
							
						}
						System.out.println("npused " + nPushed);
					}
				}
				if (!currentList.isEmpty())
					listToReturn.add(currentList);
				numbers = nPushed;
				System.out.println("numbers " + numbers);
				System.out.println();
				nPushed = 0;
				i = 0;
			}

		}
		return listToReturn;
	}
}
