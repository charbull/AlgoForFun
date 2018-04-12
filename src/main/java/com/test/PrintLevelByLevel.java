package com.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.test.FindLCA.TreeNode;

public class PrintLevelByLevel {

	
	// java.util.* and java.util.streams.* have been imported for this problem.
	// You don't need any other imports.

	public ArrayList<ArrayList<Integer>> printLevelByLevel(TreeNode root) {
	                           

	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
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
	         list.add(listLevel);
	         //create a new level
	         listLevel = new ArrayList<Integer>();   
	         //insert a new null
	         if(!queue.isEmpty())
	         queue.add(null);
	        }
	    }
	}
	 return list;



	}
	
}
