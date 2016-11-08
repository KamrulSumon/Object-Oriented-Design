package com.sumon.crossword;

/*
 * In case of word, hold the row, col and direction. And, in case of character
 * in grid, hold row, col
 */
public class Position {
	public int row;
	public int col;
	Direction direction = null;

	public Position(int row, int col, Direction dir) {
		this(row, col);		
		this.direction = dir;
	}

	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
