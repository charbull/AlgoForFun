package com.test;

import com.test.NodeDistanceInTree.TreeNode;

public class DistanceBetweenTwoNodes {

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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int getNodeDistance(TreeNode root, int n1, int n2) {
	    
	    TreeNode LCA =  findLCA(root, n1, n2);
	    
	    int node1 = (LCA.data == n1 )? 0 : getPathToNode(LCA, n1) -1;
	    int node2 = (LCA.data == n2 )? 0 : getPathToNode(LCA, n2) -1;
	    
	    return node1+ node2;
	    
	}

	
	public int getPathToNode(TreeNode root, int n)
	{
		if(root == null ) return 0;
		if(root.data == n) return 1;
		
		int left = getPathToNode(root.left, n);
		int right = getPathToNode(root.right, n);
		
		if(left != 0 && right != 0) return 1 + left + right;
		else if (left == 0 && right != 0) return 1 + right;
		else if (right == 0 && left != 0) return 1 + left;
		else return 0;
	}
	
	public TreeNode findLCA(TreeNode root, int n1, int n2) {
	    if (root != null) {
	        if (root.data == n1 || root.data == n2) {
	            return root;
	        }
	        TreeNode left = findLCA(root.left, n1, n2);
	        TreeNode right = findLCA(root.right, n1, n2);
	    
	        //Both null means they intersected at common LCA
	        if (left != null && right != null) {
	            return root;
	        }
	        return left != null ? left : right;
	    }
	    return null;
	}
	
}
