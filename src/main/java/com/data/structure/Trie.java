package com.data.structure;

public class Trie{
	char data;
	Trie[] alphabet;
	boolean wordCompleted;

	public Trie(char data, boolean wordCompleted)
	{
		this.data = data;
		this.wordCompleted = wordCompleted;
		this.alphabet = new Trie[26];
	}

	public Trie() {
		this.alphabet = new Trie[26];
	}

	public int getIndex(char character)
	{
		return character - 'a';
	}

	private Trie insertCharacter(char character, boolean wordCompleted)
	{
		int index = getIndex(character);
		Trie insertionNode = this.alphabet[index];
		if(insertionNode == null)
		{
			insertionNode = new Trie(character, wordCompleted);
			this.alphabet[index] = insertionNode;
			return insertionNode;
		}
		else return insertionNode.insertCharacter(character, wordCompleted);
	}

	public void insertWord(String word)
	{
		char wordArray[] = word.toCharArray();
		Trie insertionNode = null;

		if(word.length() == 1)
		{
			insertionNode = this.insertCharacter(wordArray[0], true);
		}
		else
		{
			insertionNode = this.insertCharacter(wordArray[0], false);
		}

		for(int i=1; i<word.length()-1;i++)
		{
			insertionNode = insertionNode.insertCharacter(wordArray[i], false);
		}
		insertionNode.insertCharacter(wordArray[word.length()-1], true);
	}

	public boolean searchPrefix(String word) {return true;}

	// Returns true if the enture word is found
	public boolean searchWord(String word)
	{
		return true;
	}
}
