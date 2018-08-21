package com.data.tree;

public class FindLCA {
	 public class TreeNode {
	      public int data;
	      public TreeNode left;
	      public TreeNode right;
	      
	      TreeNode(int data, TreeNode left, TreeNode right) {
	      this.data = data;
	      this.left = left;
	      this.right = right;
	      }
	      TreeNode(int data) {
	      this.data = data;}
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
