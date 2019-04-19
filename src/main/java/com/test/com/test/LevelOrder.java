package com.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class LevelOrder {

	 public class TreeNode {
	      int data;
	      TreeNode left;
	      TreeNode right;
	      
	      TreeNode(int data, TreeNode left, TreeNode right) {
	      this.data = data;
	      this.left = left;
	      this.right = right;
	      }
	      TreeNode(int data) {
	      this.data = data;}
	  }
	 
	public static void main(String[] args) {
		
		LevelOrder levelorder = new LevelOrder();
		printLevels(LevelOrder.levelorder(levelorder.init()));
	}

	private static void printLevels(ArrayList<Integer> levelorder) {
		for(Integer current: levelorder)
		{
			System.out.println(current.intValue()+", ");
		}
		
	}

	public TreeNode init()
	{
		TreeNode root = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		
		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n1.right = n4;
		n3.left = n5;
		n4.right = n6;
		
		return root;
		
	}

	public static ArrayList<Integer> levelorder(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		ArrayList<Integer> levelorder = new ArrayList<Integer>();


		if(root != null){

			queue.add(root);

			while(!queue.isEmpty()){
				TreeNode current = queue.remove();
				levelorder.add(current.data);
				if(current.left != null) queue.add(current.left);
				if(current.right != null) queue.add(current.right);
			}
		}
		return levelorder;



	}

}
