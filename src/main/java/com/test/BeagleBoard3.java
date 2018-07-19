package com.test;

public class BeagleBoard3 {

	public static boolean boggleSearch(char[][] board, String word){
	    int rows = board.length;
	    int cols = board[0].length;
	    boolean out = false;
	    for(int i = 0; i < rows; i++){
	        for(int j = 0; j < cols; j++){
	            out = search(i,j,board,word,"");
	            if(out) return true;
	        }
	    }
	    return out;
	}

	public static boolean search(int r, int c, char[][] board, String word, String predecessor){
	    int rows = board.length;
	    int cols = board[0].length;
	    
	    // Terminating Conditions
	    if( r > rows-1                          // Out of Bounds
	     || r < 0                               // Out of Bounds
	     || c > cols-1                          // Out of Bounds
	     || c < 0                               // Out of Bounds 
	     || !word.contains(predecessor)         // Not matching pattern
	     || board[r][c] == '@'){                // Visited
	        return false;
	    }
	    char ch = board[r][c];
	    String s = predecessor + ch;
	    boolean out = false;
	    if(s.equals(word)) return true;         // Return true if found
	    else {
	        board[r][c] = '@';                  // Mark the board node as visited
	        out =   search(r-1,c,board,word,s)  // Check Up 
	             || search(r+1,c,board,word,s)  // Check Down
	             || search(r,c-1,board,word,s)  // Check Left
	             || search(r,c+1,board,word,s); // Check Right
	        board[r][c] = ch;                   // Unmark the board node
	    }
	    return out;
	}
}
