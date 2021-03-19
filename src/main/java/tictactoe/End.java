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
		if (context.getBoard().isWinner('X')) {
			winner = "X";
		} else if (context.getBoard().isWinner('O')) {
			winner = "O";
		}
		String result = "";

		result += context.getBoard().toString();
		result += "\n";
		result += "[ THE WINNER IS " + winner + " ]\n";
		result += "\n";
		result += " $$$$$$\\                                           $$$$$$\\                                 \n";
		result += "$$  __$$\\                                         $$  __$$\\                                \n";
		result += "$$ /  \\__| $$$$$$\\  $$$$$$\\$$$$\\   $$$$$$\\        $$ /  $$ |$$\\    $$\\  $$$$$$\\   $$$$$$\\  \n";
		result += "$$ |$$$$\\  \\____$$\\ $$  _$$  _$$\\ $$  __$$\\       $$ |  $$ |\\$$\\  $$  |$$  __$$\\ $$  __$$\\ \n";
		result += "$$ |\\_$$ | $$$$$$$ |$$ / $$ / $$ |$$$$$$$$ |      $$ |  $$ | \\$$\\$$  / $$$$$$$$ |$$ |  \\__|\n";
		result += "$$ |  $$ |$$  __$$ |$$ | $$ | $$ |$$   ____|      $$ |  $$ |  \\$$$  /  $$   ____|$$ |      \n";
		result += "\\$$$$$$  |\\$$$$$$$ |$$ | $$ | $$ |\\$$$$$$$\\        $$$$$$  |   \\$  /   \\$$$$$$$\\ $$ |      \n";
		result += " \\______/  \\_______|\\__| \\__| \\__| \\_______|       \\______/     \\_/     \\_______|\\__|      \n";
		result += "                                                                                           \n";
		result += "                             [ PRESS ENTER KEY TO RESTART ]                             \n";
		result += "                                                                                           ";

		return result;
	}
}
