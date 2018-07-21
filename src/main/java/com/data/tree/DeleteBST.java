package com.data.tree;

import com.data.structure.TreeNode;

public class DeleteBST {
	
	public TreeNode delete(TreeNode root, int data) {                    
        if(root == null) { 
            return null;
        } else if(data < root.data) {
            root.left = delete(root.left, data);
        } else if(data > root.data) {
            root.right = delete(root.right, data);
        } else { //element found
            if(root.left != null && root.right != null) { //full node case
                root.data = findMin(root.right).data;    
                root.right = delete(root.right, root.data);
            } else if(root.left == null && root.right == null) {
                root = null;
            }  
            else if(root.left == null) {
                root = root.right;
            } else if(root.right == null) {
                root = root.left;                
            }                
        }
        return root;
    }
	
	private TreeNode findMin(TreeNode root)
	{
		return root;//it should find the TreeNode with data minimum
	}
}
