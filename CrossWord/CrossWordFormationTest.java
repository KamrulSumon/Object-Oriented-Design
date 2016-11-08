package com.sumon.crossword;

public class CrossWordFormationTest {

	public static void main(String[] args) {

		String[] words = { "mist", "lime", "snicker", "paladin", "caramel", "leaven", "pumpernickel", "coral", "fjord",
				"plague", "piston", "lip", "dawn", "saffron", "coda"};
		int gridSize = 15;
		CrossWordFormation cwf = new CrossWordFormation(gridSize, words);
		Result grid = cwf.getBestGrid();
		grid.printGrid();
		grid.printWrongWords();
	}

}
