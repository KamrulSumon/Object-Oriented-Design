package com.sumon.crossword;

import java.util.ArrayList;

/*
 * Result class hold the maximum crossword and words that cann't possible to
 * place in board
 */
public class Result {
	char[][] maxGrid;
	ArrayList<String> badWords;
	int maxWordsPlacedInGrid;

	public Result(int size) {
		maxGrid = new char[size][size];
	}

	public void printGrid() {
		for (int i = 0; i < maxGrid.length; i++) {
			for (int j = 0; j < maxGrid[0].length; j++) {
				System.out.print(maxGrid[i][j]);
			}
			System.out.println();
		}
	}

	public void printWrongWords() {
		System.out.println("Excluded words :");
		for (String word : badWords) {
			System.out.println(word);
		}
	}

	public void copyGrid(char[][] grid) {

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				maxGrid[i][j] = grid[i][j];
			}
		}
	}
}

