package com.test;

import java.util.LinkedList;
import java.util.Queue;

import com.test.FindLCA.TreeNode;

public class findMaxSumLevel {

	
	public findMaxSumLevel(){
		
	}
	
	public int findMaxSumLevelNode(TreeNode root) {                    
        if(root == null) return -1;
        int currSum = 0, maxSum = 0;
        int currLvl = 0, maxLvl = 0;
        TreeNode curr = null;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null); //end of first level indicator
        while(!q.isEmpty()) {
            curr = q.remove();
            // If at the end of current level, compare sum and process result
            if(curr == null) {
                if(currSum > maxSum) {
                    maxSum = currSum;
                    maxLvl = currLvl;
                }
                currSum = 0; //reset
                if(!q.isEmpty())
                    q.add(null); //end of level indicator
                currLvl++; //begin next level
            } else {
                currSum += curr.data;
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
                    
            }
        }
        return maxLvl;
    }
	
}
