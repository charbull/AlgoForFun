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


	public void insertWord(String word)
	{
		char wordArray[] = word.toCharArray();
		Trie insertionNode = this.insertCharacter(wordArray[0], false, this);

		if(word.length() == 1)
		{
			insertionNode.wordCompleted = true;
		}
		for(int i=1; i<word.length()-1;i++)
		{
			insertionNode = insertionNode.insertCharacter(wordArray[i], false, insertionNode);
		}
		insertionNode.insertCharacter(wordArray[word.length()-1], true, insertionNode);
	}

	private Trie insertCharacter(char character, boolean wordCompleted, Trie trie)
	{
		int index = getIndex(character);
		Trie insertionNode = trie.alphabet[index];
		if(insertionNode == null)
		{	
			//create a new Trie and add it to the parent trie
			insertionNode = new Trie(character, wordCompleted);
			trie.alphabet[index] = insertionNode;
		}
		//it already exists just set the boolean and return
		else{
			insertionNode.wordCompleted = wordCompleted;
		}
		return insertionNode;
	}

	public boolean searchWord(String word) {
		char wordArray[] = word.toCharArray();
		Trie currentTrie = searchPrefixCharacter(wordArray[0], this);
		if(word.length() == 1)
		{
			if(currentTrie != null) return currentTrie.wordCompleted;
		}
		else
		{
			for(int i=1; i<word.length(); i++)
			{
				if(currentTrie == null) return false;
				currentTrie = searchPrefixCharacter(wordArray[i], currentTrie);	
			}
			if(currentTrie != null ) return currentTrie.wordCompleted;
			else return false;
		}
		return false;
	}


	private Trie searchPrefixCharacter(char character, Trie trie)
	{
		int index = getIndex(character);
		if(trie == null) return null;
		return trie.alphabet[index];
	}


	// Returns true if the enture word is found
	public boolean searchPrefix(String word)
	{
		char wordArray[] = word.toCharArray();
		Trie currentTrie = searchPrefixCharacter(wordArray[0], this);
		for(int i=1; i<word.length(); i++)
		{
			if(currentTrie == null) return false;
			currentTrie = searchPrefixCharacter(wordArray[i], currentTrie);	
		}
		return currentTrie != null;
	}
}
