package com.data.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.data.structure.TreeNode;

public class BSTItr {

	public static boolean validateBSTItr(TreeNode root) {

	    class TreeBoundaryNode{
	      TreeNode treeNode;
	      int leftBoundary;
	      int rightBoundary;
	      TreeBoundaryNode(TreeNode treeNode, int leftBoundary, int rightBoundary) {
	          this.treeNode = treeNode;
	          this.leftBoundary = leftBoundary;
	          this.rightBoundary = rightBoundary;
	      }
	    }
	    
	    if(root == null || (root.left == null && root.right == null)) return true;
	    
	    Queue<TreeBoundaryNode> q = new LinkedList<>();
	    q.add(new TreeBoundaryNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	    while(!q.isEmpty()){
	        TreeBoundaryNode tbNode = q.poll();
	        TreeNode t = tbNode.treeNode;
	        if((t.data <= tbNode.leftBoundary) || (t.data >= tbNode.rightBoundary)) return false;
	        if(t.left != null){
	            q.add(new TreeBoundaryNode(t.left, tbNode.leftBoundary, t.data));
	        }
	        if(t.right != null){
	            q.add(new TreeBoundaryNode(t.right, t.data, tbNode.rightBoundary));
	        }
	    }

	    return true;
	}
	
}
