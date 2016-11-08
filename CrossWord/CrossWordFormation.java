package com.sumon.crossword;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/*
 * Actual implementation of logic to place word in grid in crossword formation
 */
public class CrossWordFormation {
	
	final char DEFAULT_CHAR = '-';
	final int DEFAULT_GRID_SIZE = 5;
	char[][] grid;
	int gridSize;
	String[] words;
	HashMap<Character, ArrayList<Position>> charPositionInGrid = null;
	ArrayList<String> wrongWords = null;

	/* default grid */
	public CrossWordFormation() {
		grid = new char[DEFAULT_GRID_SIZE][DEFAULT_GRID_SIZE];
		for (int i = 0; i < DEFAULT_GRID_SIZE; i++) {
			for (int j = 0; j < DEFAULT_GRID_SIZE; j++) {
				grid[i][j] = DEFAULT_CHAR;
			}
		}
	}

	/* grid size and word list are given */
	public CrossWordFormation(int gSize, String[] list) {
		gridSize = gSize;
		words = list;
		if (words.length < 2 || gridSize < 2)
			throw new IllegalArgumentException("Word and grid size must be grate than or equal 2");

		grid = new char[gridSize][gridSize];

		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				grid[i][j] = DEFAULT_CHAR;
			}
		}
	}

	/* add word list */
	public void addWordList(String[] words) {
		if (words.length < 2)
			throw new IllegalArgumentException("Word must be grate than or equal 2");
		this.words = words;
	}

	/* clear the grid */
	public void clearGrid() {
		// create new map for holding the coordinate of character in grid
		charPositionInGrid = new HashMap<>();

		// initialize the grid with default char
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				grid[i][j] = DEFAULT_CHAR;
			}
		}
	}

	/* return random direction */
	public Direction getDirection() {
		Random r = new Random();
		int n = r.nextInt(2);
		return n == 0 ? Direction.Horizontal : Direction.Vertical;
	}

	/*
	 * find the best possible grid where max possible words intersects at least
	 * with other word
	 */
	public Result getBestGrid() {
		
		if (words.length < 2 || gridSize < 2)
			throw new IllegalArgumentException("Word and grid size must be grate than or equal 2");
		
		// do some words pre-processing: group the words so that word size
		// bigger than grid is out of consider. Words size of i are put
		// corresponding index
		WordGroup wordGroup = new WordGroup();
		WordGroup[] groupList = wordGroup.createWordGroups(words);
		
		// find the best possible word group
		int gSize = Math.min(wordGroup.getMaxWordLength(), gridSize);
		Result bestGrid = new Result(gridSize); // hold the best grid

		while ( gSize > 0) {
			
			if ( (groupList[gSize] == null) || (groupList[gSize].getWords().size() == 0) ) {
				gSize--;
				continue;
			}
			
			clearGrid(); // clear the grid
			
			int maxWordPlaced = 0;
			Direction start_dir = getDirection(); // get random direction either
													// horizontal or vertical
			wrongWords = new ArrayList<>();

			int r = (int) Math.floor(gridSize / 2);
			int c = (int) Math.floor(gridSize / 2);

			// adjust the index to place first biggest word in the grid
			String biggestWord = groupList[gSize].getWords().get(0);
			groupList[gSize].getWords().remove(0);

			if (start_dir == Direction.Horizontal) {
				c -= biggestWord.length() / 2;
			} else {
				r -= biggestWord.length() / 2;
			}

			if (canPlaceWordAt(biggestWord, r, c, start_dir) == true) {
				placeWordAt(biggestWord, r, c, start_dir);
				maxWordPlaced++;

			} else {
				wrongWords.add(biggestWord);
				continue;
			}

			// go through all the word groups
			for (int g = gSize; g >= 1; g--) {
				if (groupList[g] != null && groupList[g].getWords().size() > 0) {
					ArrayList<String> group = groupList[g].getWords();
					// try to add all the words in this group
					for (int i = 0; i < group.size(); i++) {
						String word = group.get(i);
						Position position = findPositionForWord(word);

						if (position != null) {
							placeWordAt(word, position.row, position.col, position.direction);
							maxWordPlaced++;
						} else {
							// add to wrong group plus need to consider for next
							// group
							wrongWords.add(word);
						}
					}
				}
			}
			if (maxWordPlaced > bestGrid.maxWordsPlacedInGrid) {
				bestGrid.copyGrid(grid);
				bestGrid.badWords = wrongWords;
				bestGrid.maxWordsPlacedInGrid = maxWordPlaced;
			}
			// printGrid();
		}
		return bestGrid;
	}

	// print location of the character in grid
	public void printLocation(char ch, ArrayList<Position> possibleCharLocationsOnGrid, String word) {
		for (int i = 0; i < possibleCharLocationsOnGrid.size(); i++) {
			System.out.println(ch + " : " + possibleCharLocationsOnGrid.get(i).row + ","
					+ possibleCharLocationsOnGrid.get(i).col + " " + word);
		}
	}

	// print char location in grid
	public void printCharIndexInGrid() {
		for (Character key : charPositionInGrid.keySet()) {
			for (Position p : charPositionInGrid.get(key)) {
				System.out.println(key + " -> " + p.row + "," + p.col);
			}
		}
	}

	// Find possible position of the word
	public Position findPositionForWord(String word) {
		ArrayList<Position> suggestedCoordinate = new ArrayList<>();
		// printCharIndexInGrid();
		for (int i = 0; i < word.length(); i++) {
			ArrayList<Position> possibleCharLocationsOnGrid = charPositionInGrid.get(word.charAt(i));
			if (possibleCharLocationsOnGrid != null) {
				// printLocation(word.charAt(i), possibleCharLocationsOnGrid,
				// word);
				for (int j = 0; j < possibleCharLocationsOnGrid.size(); j++) {
					Position point = possibleCharLocationsOnGrid.get(j);

					int r = point.row;
					int c = point.col;

					boolean isHorizontalIntersection = canPlaceWordAt(word, r, c - i, Direction.Horizontal);
					boolean isVerticalIntersection = canPlaceWordAt(word, r - i, c, Direction.Vertical);

					if (isHorizontalIntersection == true) {
						suggestedCoordinate.add(new Position(r, c - i, Direction.Horizontal));
					}

					if (isVerticalIntersection == true) {
						suggestedCoordinate.add(new Position(r - i, c, Direction.Vertical));
					}
				}
			}
		}
		if (suggestedCoordinate.size() == 0)
			return null;
		return suggestedCoordinate.get(0);
	}

	
	//check whether you can place word in the specified row, col, and direction
	public boolean canPlaceWordAt(String word, int row, int col, Direction dir) {

		// check the boundary condition
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length)
			return false;

		int intersections = 0;
		
		// Check word can be placed at horizontal
		if (dir == Direction.Horizontal) {
			
			// word exceeds boundary means word is too long to fit in this row, col
			if (col + word.length() > grid[row].length)
				return false;
			
			// can't have a word on the left
			if (col - 1 >= 0 && grid[row][col - 1] != DEFAULT_CHAR)
				return false;
			
			// can't have word directly to the right
			if (col + word.length() < grid[row].length && grid[row][col + word.length()] != DEFAULT_CHAR)
				return false;

			// check any word running parallel in above
			int r = row - 1; // above row
			int c = col; // same column
			int i = 0; // starting char of word

			for (; r >= 0 && c < col + word.length(); c++, i++) {
				boolean isEmpty = grid[r][c] == DEFAULT_CHAR;
				boolean isIntersection = grid[row][c] != DEFAULT_CHAR && grid[row][c] == word.charAt(i);
				boolean isPossibleToPlace = isEmpty || isIntersection;
				if (!isPossibleToPlace)
					return false;
			}

			// check any word running parallel in below
			r = row + 1; // below row
			c = col; // same column
			i = 0; // starting char of word

			for (; r < grid.length && c < col + word.length(); c++, i++) {

				boolean isEmpty = grid[r][c] == DEFAULT_CHAR;
				boolean isIntersection = grid[row][c] != DEFAULT_CHAR && grid[row][c] == word.charAt(i);
				boolean isPossibleToPlace = isEmpty || isIntersection;
				if (!isPossibleToPlace)
					return false;
			}

			// count of intersection
			c = col; // column
			i = 0; // starting char of word
			intersections = 0;
			for (; i < word.length() && c < col + word.length(); c++, i++) {
				int result = canPlaceCharAt(word.charAt(i), row, c);
				if (result == -1)
					return false;
				intersections++;
			}

			if (intersections > 0)
				return true;
		}

		// Check word can be placed at vertical
		if (dir == Direction.Vertical) {
			
			// word exceeds boundary means word is too long to fit in this row, col
			if (row + word.length() > grid.length)
				return false;
			
			// can't have a word on the above
			if (row - 1 >= 0 && grid[row - 1][col] != DEFAULT_CHAR)
				return false;
			
			// can't have word directly to the below
			if (row + word.length() < grid.length && grid[row + word.length()][col] != DEFAULT_CHAR)
				return false;

			// check any word running parallel in left
			int r = row; // same row
			int c = col - 1; // left column
			int i = 0; // starting char of word
			
			for (; c >= 0 && r < row + word.length(); r++, i++) {
				boolean isEmpty = grid[r][c] == DEFAULT_CHAR;
				boolean isIntersection = grid[r][col] != DEFAULT_CHAR && grid[r][col] == word.charAt(i);
				boolean isPossibleToPlace = isEmpty || isIntersection;
				if (!isPossibleToPlace)
					return false;
			}
			
			// check any word running parallel in right
			r = row; // same row
			c = col + 1; // right column
			i = 0; // starting index of word
			
			for (; r < row + word.length() && c < grid[r].length; r++, i++) {
				boolean isEmpty = grid[r][c] == DEFAULT_CHAR;
				boolean isIntersection = grid[r][col] != DEFAULT_CHAR && grid[r][col] == word.charAt(i);
				boolean isPossibleToPlace = isEmpty || isIntersection;
				if (!isPossibleToPlace)
					return false;
			}

			// count of intersection
			intersections = 0;
			r = row;
			i = 0;
			for (; r < row + word.length(); r++, i++) {
				int result = canPlaceCharAt(word.charAt(i), r, col);
				if (result == -1)
					return false;
				intersections++;
			}
			if (intersections > 0)
				return true;
		}
		return false;
	}

	// Check whether you can place a char
	public int canPlaceCharAt(char ch, int row, int col) {
		if (grid[row][col] == DEFAULT_CHAR)
			return 0;
		if (grid[row][col] == ch)
			return 1;
		return -1;
	}

	/* place word in the grid */
	public void placeWordAt(String word, int row, int col, Direction direction) {

		// place word horizontally
		if (direction == Direction.Horizontal) {
			for (int c = col, i = 0; c < col + word.length(); c++, i++) {
				if (charPositionInGrid.get(word.charAt(i)) == null) {
					ArrayList<Position> points = new ArrayList<>();
					charPositionInGrid.put(word.charAt(i), points);
				}
				grid[row][c] = word.charAt(i);
				charPositionInGrid.get(word.charAt(i)).add(new Position(row, c));
			}
		}
		
		// place word vertically
		if (direction == Direction.Vertical) {
			for (int r = row, i = 0; r < row + word.length(); r++, i++) {
				if (charPositionInGrid.get(word.charAt(i)) == null) {
					ArrayList<Position> points = new ArrayList<>();
					charPositionInGrid.put(word.charAt(i), points);
				}
				grid[r][col] = word.charAt(i);
				charPositionInGrid.get(word.charAt(i)).add(new Position(r, col));
			}
		}
	}

	/* print the grid */
	public void printGrid() {
		for (int r = 0; r < gridSize; r++) {
			for (int c = 0; c < gridSize; c++) {
				System.out.print(grid[r][c] + " ");
			}
			System.out.println();
		}
	}

	/* print word groups */
	public void printWordGroup(WordGroup[] groups) {
		System.out.println(groups.length);
		for (int g = groups.length - 1; g >= 0; g--) {
			if (groups[g] != null) {
				ArrayList<String> group = groups[g].getWords();
				for (int i = 0; i < group.size(); i++) {
					System.out.print(group.get(i) + " ");
				}
				System.out.println();
			}
		}
	}
	
	
}
