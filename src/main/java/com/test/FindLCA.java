package com.test;

public class FindLCA {
	  class TreeNode {
	      int data;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int data, TreeNode left, TreeNode right) {
	      this.data = data;
	      this.left = left;
	      this.right = right;
	      }
	  }
	
	
	public TreeNode findLCA(TreeNode root, TreeNode a, TreeNode b) {
        
	    if(root == null) return null;
	    
	    if(root == a || root == b) return root;
	    
	    TreeNode LCALeft = findLCA(root.left, a, b);
	    TreeNode LCARight = findLCA(root.right, a, b);
	    
	    if(LCARight != null || LCALeft != null)
	    {
	        //The first which finds BOTH non null children is the common LCA root.
	        if(LCALeft != null && LCARight != null) return root;
	        else if(LCARight == null) return LCALeft;
	        else if(LCALeft == null) return LCARight;
	    }
	    return null;
	}
	
}
