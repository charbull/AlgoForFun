package com.test;

import java.util.ArrayList;
import java.util.TreeSet;

import com.data.structure.Trie;

public class BeagleBoard2 {

	public ArrayList<String> boggleSearchWithDict(char[][] board, Trie dictionary){
	    TreeSet<String> outputHolder = new TreeSet<>();
	    int rows = board.length;
	    int cols = board[0].length;
	    for(int i = 0; i < rows; i++){
	        for(int j = 0; j < cols; j++){
	            search(i,j,board,dictionary,"",outputHolder);
	        }
	    }
	    return new ArrayList<>(outputHolder);
	}

	public void search(int r, int c, char[][] board, Trie dictionary, String prefix, TreeSet<String> outputHolder){
	    int rows = board.length;
	    int cols = board[0].length;
	    
	    // Terminating Conditions
	    if( r > rows-1                          // Out of Bounds
	     || r < 0                               // Out of Bounds
	     || c > cols-1                          // Out of Bounds
	     || c < 0                               // Out of Bounds 
	     || !dictionary.searchPrefix(prefix)    // Not matching pattern
	     || board[r][c] == '@'){                // Visited
	        return;
	    }
	    char ch = board[r][c];
	    String s = prefix + ch;
	    if(dictionary.searchWord(s)){           
	        outputHolder.add(s);                // Add to the treeSet 
	    }
	    board[r][c] = '@';                      // Mark the board node as visited
	    
	    search(r-1,c,board,dictionary,s,outputHolder);  // Check Up 
	    search(r+1,c,board,dictionary,s,outputHolder);  // Check Down
	    search(r,c-1,board,dictionary,s,outputHolder);  // Check Left
	    search(r,c+1,board,dictionary,s,outputHolder);  // Check Right
	    
	    board[r][c] = ch;                       // Unmark the board node
	}
	
}
