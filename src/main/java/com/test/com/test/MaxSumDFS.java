package com.test;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSumDFS {
	public static int matrixMaxSumDfs(int[][] grid) {
	    class TravelNode {
	        int row;
	        int col;
	        int nodeSum;
	        TravelNode(int r, int c, int sum, int[][] grid) {
	            row = r;
	            col = c;
	            sum += grid[r][c];
	            nodeSum = sum;
	        }
	    }
	    
	    int maxSum = Integer.MIN_VALUE;
	    int rows = grid.length;
	    int cols = grid[0].length;
	    if(rows < 2 && cols < 2) return grid[0][0];
	    else {
	        Deque<TravelNode> stack = new LinkedList<>();
	        stack.addFirst(new TravelNode(0,0,0,grid));
	        while(!stack.isEmpty()){
	            TravelNode t = stack.removeFirst();
	            // Update maxSum if the last node is reached
	            if(t.row == rows-1 && t.col == cols - 1){
	                if(t.nodeSum > maxSum) maxSum = t.nodeSum;
	            } else {
	                // Go Right
	                if(t.col < cols-1){
	                    stack.addFirst(new TravelNode(t.row, t.col+1, t.nodeSum, grid));
	                }
	                // Go Down
	                if(t.row < rows-1){
	                    stack.addFirst(new TravelNode(t.row + 1, t.col, t.nodeSum, grid));
	                }
	            }
	        }
	    }
	    return maxSum;
	}
}
