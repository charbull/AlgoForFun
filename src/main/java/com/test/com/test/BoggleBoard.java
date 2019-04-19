package com.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import com.data.structure.Trie;

public class BoggleBoard {

	Trie dictionary;

	public static void main(String[] args) {


		BoggleBoard bg = new BoggleBoard();
		bg.dictionary = new Trie(); 

		bg.dictionary.insertWord("hello");
		bg.dictionary.insertWord("how");
		bg.dictionary.insertWord("are");
		bg.dictionary.insertWord("you");
		bg.dictionary.insertWord("aolli");
		bg.dictionary.insertWord("eh");

		char[][] board = {{'a', 'o', 'l'}, 
				{'d', 'e', 'l'},
				{'g', 'h', 'i'}};

		/*System.out.println(bg.dictionary.searchPrefix("h")==true);
		System.out.println(bg.dictionary.searchPrefix("hell")==true);
		System.out.println(bg.dictionary.searchPrefix("hells")==false);
		System.out.println(bg.dictionary.searchWord("hells")==false);
		System.out.println(bg.dictionary.searchWord("how")==true);
		System.out.println(bg.dictionary.searchWord("ho")==false);
		System.out.println(bg.dictionary.searchWord("hello")==true);*/

		List<String> foundWords = bg.boggleSearchWithDict(board, bg.dictionary);
		bg.printList(foundWords);
	}

	public void printList(List<String> list)
	{
		for(String current: list)
		{
			System.out.println(current);
		}
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

	Set<String> hasNoPrefix = new HashSet<String>();
	Stack<Struct> visitedStack = new Stack<Struct>();

	public class Struct{
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
			foundWords.addAll(traverseBoard(current.character, board, current.row, current.column));
			current = visitedStack.pop();
		}
		foundWords.addAll(traverseBoard(current.character, board, current.row, current.column));
		return (ArrayList<String>) foundWords;
	}

	private boolean isInBoarder(int r, int c, int rowLen, int colLen)
	{
		return (r>=0 && c>=00 && r<rowLen && c<colLen);
	}

	private List<String> traverseBoard(String character, char[][] board, int row, int column) {
		List<String> listOfWordsFound = new ArrayList<>();
		for(int i=0;i<2;i++)
		{
			int r = row+((i+1)%2);
			int c = column+(i%2);
			if(isInBoarder(r, c, board.length, board[0].length))
			{
				String currentWord = character+ board[r][c];
				if(foundWord(currentWord))
				{
					listOfWordsFound.add(currentWord);
				}
				if(checkPrefix(currentWord))
				{
					listOfWordsFound.addAll(traverseBoard(currentWord, board, r, c));
				}
			}
		}
		for(int i=0;i<2;i++)
		{
			int r = row-((i+1)%2);
			int c = column-(i%2);
			if(isInBoarder(r, c, board.length, board[0].length))
			{
				String currentWord = character+ board[row-((i+1)%2)][column-(i%2)];
				if(foundWord(currentWord))
				{
					listOfWordsFound.add(currentWord);
				}
				if(checkPrefix(currentWord))
				{
					listOfWordsFound.addAll(traverseBoard(currentWord, board, r, c));
				}
			}
		}

		//if prefix not valid, no need to look for neighbors
		return listOfWordsFound;
	}


	private boolean foundWord(String word)
	{
		if(checkPrefix(word))
		{
			return dictionary.searchWord(word);
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

	public boolean checkPrefix(String prefix)
	{
		if(hasNoPrefix.contains(prefix)) return false;
		else{
			//search Prefix in the dictionary 
			if(dictionary.searchPrefix(prefix))
			{
				return true;
			}
			else{
				hasNoPrefix.add(prefix);
				return false;
			}

		}

	}
}