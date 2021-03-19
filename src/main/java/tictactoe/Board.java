package tictactoe;

import java.util.LinkedHashMap;

public class Board {

	private final LinkedHashMap<Coordinate, Character> stones = new LinkedHashMap<>();

	public boolean setStone(char character, int x, int y) {
		if((x >= 0 && x <= 2) && (y >= 0 && y <= 2)) {
			final Coordinate coordinate = new Coordinate(x, y);
			if (isFieldEmpty(coordinate)) {
				stones.put(coordinate, character);
				return true;
			}
		}
		return false;
	}

	public boolean isWon() {
		return (isWinner('X') || isWinner('O'));
	}

	/**
	 * Returns true, if field is empty or filled with a Character which not equals X or O
	 */
	public boolean isFieldEmpty(final Coordinate coordinate) {
		if(stones.containsKey(coordinate)) {
			final Character character = stones.get(coordinate);
			return !(character == 'X' || character == 'O');
		}
		return true;
	}

	public boolean containsFreeFields() {
		for (int y = 0; y <= 2; y++) {
			for (int x = 0; x <= 2; x++) {
				if(isFieldEmpty(new Coordinate(x, y))) return true;
			}
		}
		return false;
	}

	public boolean isWinner(final char character) {
		// X X X
		// - - -
		// - - -
		if(expectedCharNotNull(character, stone(0, 0), stone(1, 0), stone(2, 0))) return true;
		// - - -
		// X X X
		// - - -
		if(expectedCharNotNull(character, stone(0, 1), stone(1, 1), stone(2, 1))) return true;
		// - - -
		// - - -
		// X X X
		if(expectedCharNotNull(character, stone(0, 2), stone(1, 2), stone(2, 2))) return true;
		// X - -
		// X - -
		// X - -
		if(expectedCharNotNull(character, stone(0, 0), stone(0, 1), stone(0, 2))) return true;
		// - X -
		// - X -
		// - X -
		if(expectedCharNotNull(character, stone(1, 0), stone(1, 1), stone(1, 2))) return true;
		// - - X
		// - - X
		// - - X
		if(expectedCharNotNull(character, stone(2, 0), stone(2, 1), stone(2, 2))) return true;
		// X - -
		// - X -
		// - - X
		if(expectedCharNotNull(character, stone(0, 0), stone(1, 1), stone(2, 2))) return true;
		// - - X
		// - X -
		// X - -
		if(expectedCharNotNull(character, stone(2, 0), stone(1, 1), stone(0, 2))) return true;
		// default case
		return false;
	}

	@Override
	public String toString() {
		String string = "┌─────┬─────┬─────┐\n";
		string = string + "│ " + stoneOrEmpty(0,0) + " │ " + stoneOrEmpty(1,0) + " │ " + stoneOrEmpty(2,0) + " │\n";
		string = string + "├─────┼─────┼─────┤\n";
		string = string + "│ " + stoneOrEmpty(0,1) + " │ " + stoneOrEmpty(1,1) + " │ " + stoneOrEmpty(2,1) + " │\n";
		string = string + "├─────┼─────┼─────┤\n";
		string = string + "│ " + stoneOrEmpty(0,2) + " │ " + stoneOrEmpty(1,2) + " │ " + stoneOrEmpty(2,2) + " │\n";
		string = string + "└─────┴─────┴─────┘";
		return string;
	}

	public void clear() {
		stones.clear();
	}

	/**
	 * Just to make it more convenient; Maybe null
	 */
	private Character stone(int x, int y) {
		return stones.get(new Coordinate(x, y));
	}

	/**
	 * Returns String with Character if placed or 3 empty whitespaces
	 */
	private String stoneOrEmpty(int x, int y) {
		final Character stone = stone(x, y);
		if(stone != null) {
			final String color = (stone == 'X') ? AnsiColor.ANSI_YELLOW : AnsiColor.ANSI_RED;
			return color + " " + stone + " " + AnsiColor.ANSI_RESET;
		} else {
			return "   ";
		}
	}

	private boolean expectedCharNotNull(final Character expected, final Character char1, final Character char2, final Character char3) {
		if(expected == null) return false;
		return (expected == char1) && (expected == char2) && (expected == char3);
	}


}
