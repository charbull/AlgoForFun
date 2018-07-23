package com.test;

import java.util.ArrayList;
import java.util.List;

public class BeagleBoardWithTrie {

	public static void main(String[] args) {

	}
	
	    
	    class TrieNode {
	        public TrieNode[] children = new TrieNode[26];
	        public String word;
	        public TrieNode(){}  // constructor
	    }
	    
	    private TrieNode root;
	    
	    private void insert(String s) {
	        TrieNode node = root;
	        for (char c: s.toCharArray()) {
	            if (node.children[c-'a'] == null) {
	                node.children[c-'a'] = new TrieNode();
	            }
	            node = node.children[c-'a'];
	        }
	        node.word = s;
	    }
	    
	    
	    public List<String> findWords(char[][] board, String[] words) {
	        List<String> res = new ArrayList<>();
	        if (words == null || words.length == 0 || board == null || board.length == 0 || board[0].length == 0) return res;
	        root = new TrieNode();
	        for (String w: words) {
	            insert(w);
	        }
	        
	        int n = board.length;
	        int m = board[0].length;
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < m; j++) {
	                dfs(res, board, root, i, j, n, m);
	            }
	        }
	        return res;
	    }
	    
	    private void dfs(List<String> res, char[][] board, TrieNode p, int i, int j, int n, int m) {
	        char c = board[i][j];
	        if (c == '#' || p.children[c-'a'] == null) return;
	        p = p.children[c-'a'];
	        if (p.word != null) {
	            res.add(p.word);
	            p.word = null;
	        }
	        
	        board[i][j] = '#';
	        if (i > 0) dfs(res, board, p, i-1, j, n, m);
	        if (i < n - 1) dfs(res, board, p, i+1, j, n, m);
	        if (j > 0) dfs(res, board, p, i, j-1, n, m);
	        if (j < m - 1) dfs(res, board, p, i, j+1, n, m);
	        board[i][j] = c;
	    }
	

}
