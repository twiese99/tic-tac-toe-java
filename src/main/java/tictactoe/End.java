package tictactoe;

public class End implements Action {
	private Context context;

	public End(Context context) {
		this.context = context;
	}

	@Override
	public void keyPressed(char c) {
		context.getBoard().clear();
		context.setCurrentState(context.getSplash());
	}

	@Override
	public String getScreen() {
		String winner = "NOBODY";
		if (context.getBoard().isWinner(Resources.PlayerSymbol.PlayerX)) {
			winner = Character.toString(Resources.PlayerSymbol.PlayerX);
		} else if (context.getBoard().isWinner(Resources.PlayerSymbol.PlayerO)) {
			winner = Character.toString(Resources.PlayerSymbol.PlayerO);
		}
		String result = "";

		result += context.getBoard().toString();
		result += "\n";
		result += "[ THE WINNER IS " + winner + " ]\n";
		result += "\n";
		result += Resources.AnsiArt.GAME_OVER;

		return result;
	}
}
