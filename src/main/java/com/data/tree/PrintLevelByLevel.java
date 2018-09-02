package com.data.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.data.structure.TreeNode;

public class PrintLevelByLevel {

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
		
		ArrayList<ArrayList<Integer>> list = printLevelByLevel(n1);
		for(ArrayList<Integer> sublist : list)
		{
			for(int i : sublist) System.out.print(i+", ");
			System.out.println();
		}
		

	}
	public static ArrayList<ArrayList<Integer>> printLevelByLevel(TreeNode root) {
	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	Queue<TreeNode> queue = new LinkedList<TreeNode>();
	ArrayList<Integer> listLevel = new ArrayList<Integer>();
	if(root != null )
	{
	    queue.add(root);
	    queue.add(null);
	    while(!queue.isEmpty())
	    {
	        TreeNode current = queue.remove();
	        if(current != null)
	        {
	            listLevel.add(current.data);
	            if(current.left != null){
	                queue.add(current.left);
	            }
	            if(current.right != null){
	                queue.add(current.right);
	            }
	        }
	        //reached another level
	        else{
	         //put the previous level
	         res.add(listLevel);
	         //create a new level
	         listLevel = new ArrayList<Integer>();   
	         //insert a new null
	         if(!queue.isEmpty())
	         queue.add(null);
	        }
	    }
	}
	 return res;



	}
	
}
