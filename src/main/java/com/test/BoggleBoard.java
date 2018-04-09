package com.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import com.data.structure.Trie;

public class BoggleBoard {

	static Trie dictionary;
	
 public static void main(String[] args) {
	 dictionary = new Trie(); 
	 
	 dictionary.insertWord("hello");
	 dictionary.insertWord("how");
	 
	 
}
	

	/**
You're given a 2D Boggle Board which contains an m x n matrix of chars - char[][] board, and a fast, electronic Dictionary in the form of a Prefix Tree or Trie. Write a method - boggleSearchWithDict that searches the Boggle Board for words in the dictionary. Your method should return an alphabetically sorted ArrayList of words that are present on the board as well as in the dictionary. Words on the board can be constructed with sequentially adjacent letters, where adjacent letters are horizontal or vertical neighbors (not diagonal). Also, each letter on the Boggle Board must be used only once. Your program should run in a reasonable amount of time (at max about 50 ms for each test case) and shouldn't time out. 

Note: The Trie has two built-in methods that you'll find useful for this problem - searchWord(String s) and searchPrefix(String s). These will return true if the complete word or prefix are found in the dictionary, respectively.

Example:

Input Board :      
{
    {A, O, L},
    {D, E, L},
    {G, H, I},
}
Dictionary : [HELLO, HOW, ARE, YOU] (as a Trie)
Output: [HELLO] 
	 */


	// java.util.* and java.util.streams.* have been imported for this problem.
	// You don't need any other imports.


	Set<String> hasNoPrefix = new HashSet<String>();
	Stack<Struct> visitedStack = new Stack<Struct>();

	class Struct{
		String character;
		int row;
		int column;

		public Struct(String character, int row, int column)
		{
			this.character = character;
			this.row = row;
			this.column = column;
		}
	}



	public ArrayList<String> boggleSearchWithDict(char[][] board, Trie dictionary){
		this.dictionary = dictionary;
		List<String> foundWords = new ArrayList<String>();
		initStruct(board);

		Struct current = visitedStack.pop();
		while(!visitedStack.isEmpty())
		{
			List<String> wordFoundCurrentList = traverseBoard(current.character, board, current.row, current.column);
			for(String foundWord : wordFoundCurrentList)
			{
				foundWords.add(foundWord);    
			}

		}

		return (ArrayList<String>) foundWords;

	}


	private List<String> traverseBoard(String struct, char[][] board, int row, int column)
	{
		List<String> newFoundWords = new ArrayList<String>();
		if(row > board.length || column > board[0].length) return newFoundWords;
		else{
			List<String> lowerCharacter =  traverseBoard(struct, board, row+1, column);
			if(!lowerCharacter.isEmpty())
			{
				for(String character : lowerCharacter)
				{
					if(foundWord(struct+character))
					{
						newFoundWords.add(struct+character);
					}
				}
			}
			List<String> rightCharacter =  traverseBoard(struct, board, row, column+1);
			if(!rightCharacter.isEmpty())
			{
				for(String character : rightCharacter)
				{
					if(foundWord(struct+character))
					{
						newFoundWords.add(struct+character);
					}
				}
			}
			List<String> leftCharacter =  traverseBoard(struct, board, row, column-1);
			if(!leftCharacter.isEmpty())
			{
				for(String character : leftCharacter)
				{
					if(foundWord(struct+character))
					{
						newFoundWords.add(struct+character);
					}
				}
			}
			List<String> upperCharacter =  traverseBoard(struct, board, row-1, column);
			if(!upperCharacter.isEmpty())
			{
				for(String character : upperCharacter)
				{
					if(foundWord(struct+character))
					{
						newFoundWords.add(struct+character);
					}
				}
			}
			return newFoundWords;
		}

	}


	private boolean foundWord(String word)
	{
		if(checkPrefix(word))
		{
			return this.dictionary.searchWord(word);
		}
		else return false;
	}


	private void initStruct(char[][] board)
	{
		for(int r = 0; r< board.length; r++)
		{
			for(int c = 0; c< board[0].length; c++)
			{
				String prefix = ""+board[r][c];
				if(checkPrefix(prefix))
				{
					Struct struct = new Struct(prefix, r, c);
					visitedStack.push(struct);
				}
			}
		}
	}

	private boolean checkPrefix(String prefix)
	{
		if(hasNoPrefix.contains(prefix)) return false;
		else{
			//search Prefix in the dictionary 
			if(this.dictionary.searchPrefix(prefix))
			{
				return true;
			}
			else{
				hasNoPrefix.add(prefix);
				return false;
			}

			//

		}

	}
}