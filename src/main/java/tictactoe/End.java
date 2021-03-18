package tictactoe;

public class End implements Action {
	private Context context;

	public End(Context context) {
		this.context = context;
	}

	@Override
	public void keyPressed(char c) {
		context.setCurrentState(context.getSplash());
	}

	@Override
	public String getScreen() {
		String winner = "X";
		if (context.getBoard().isWinner('O')) {
			winner = "O";
		}
		String result = "";

		result += context.getBoard().toString();
		result += "\n";
		result += "[ THE WINNER IS " + winner + " ]";
		result += "\n";
		result += " $$$$$$\\                                           $$$$$$\\                                 ";
		result += "$$  __$$\\                                         $$  __$$\\                                ";
		result += "$$ /  \\__| $$$$$$\\  $$$$$$\\$$$$\\   $$$$$$\\        $$ /  $$ |$$\\    $$\\  $$$$$$\\   $$$$$$\\  ";
		result += "$$ |$$$$\\  \\____$$\\ $$  _$$  _$$\\ $$  __$$\\       $$ |  $$ |\\$$\\  $$  |$$  __$$\\ $$  __$$\\ ";
		result += "$$ |\\_$$ | $$$$$$$ |$$ / $$ / $$ |$$$$$$$$ |      $$ |  $$ | \\$$\\$$  / $$$$$$$$ |$$ |  \\__|";
		result += "$$ |  $$ |$$  __$$ |$$ | $$ | $$ |$$   ____|      $$ |  $$ |  \\$$$  /  $$   ____|$$ |      ";
		result += "\\$$$$$$  |\\$$$$$$$ |$$ | $$ | $$ |\\$$$$$$$\\        $$$$$$  |   \\$  /   \\$$$$$$$\\ $$ |      ";
		result += " \\______/  \\_______|\\__| \\__| \\__| \\_______|       \\______/     \\_/     \\_______|\\__|      ";
		result += "                                                                                           ";
		result += "                                     [ PRESS ANY KEY ]                                     ";
		result += "                                                                                           ";

		return result;
	}
}
