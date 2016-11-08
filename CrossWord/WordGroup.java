package com.sumon.crossword;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * Group the word according to their length. It becomes easier to discard the
 * word that size bigger than grid
 */
public class WordGroup {
	private ArrayList<String> group = new ArrayList<>(); // hold group of word
	int maxWordLength = 0;

	/* add word to the group */
	public void addWord(String word) {
		group.add(word);
	}

	/* return length of word group */
	public int length() {
		return group.size();
	}

	/* return the word of the specified index */
	public String getWord(int i) {
		return group.get(i);
	}

	/* return the group */
	public ArrayList<String> getWords() {
		return group;
	}

	public int getMaxWordLength() {
		return maxWordLength;
	}

	/* create word group from a list of words */
	public WordGroup[] createWordGroups(String[] list) {
		ArrayList<String> validWords = validateWords(list);
		list = validWords.toArray(new String[validWords.size()]);
		WordGroup[] groupList;

		int len = list.length;
		/* find the length of the largest word */
		for (int i = 0; i < len; i++) {
			if (list[i].length() > maxWordLength) {
				maxWordLength = list[i].length();
			}
		}

		groupList = new WordGroup[maxWordLength + 1];

		for (int i = 0; i < len; i++) {
			int wordLength = list[i].length();

			if (groupList[wordLength] == null) {
				groupList[wordLength] = new WordGroup();
			}

			groupList[wordLength].addWord(list[i]);
		}
		return groupList;
	}

	/* Check the validation of each word */
	public ArrayList<String> validateWords(String[] words) {
		if (words == null || words.length == 0)
			return null;

		ArrayList<String> goodWords = new ArrayList<>(); // keep valid words
		HashSet<String> set = new HashSet<>(); // to remove duplicate word

		for (int i = 0; i < words.length; i++) {
			String word = words[i].trim().toUpperCase();

			int j = 0;
			for (; j < word.length(); j++) {
				if (!(word.charAt(j) >= 'A' && word.charAt(j) <= 'Z')) {
					break;
				}
			}
			if (j == word.length() && !set.contains(word)) {
				goodWords.add(word);
				set.add(word);
			} else {
				System.out.println(word + " is not valid word");
			}
		}
		return goodWords;
	}
}

