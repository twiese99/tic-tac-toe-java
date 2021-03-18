package tictactoe;

public class Splash implements Action {
	private Context context;
	
	public Splash(Context context) {
		this.context = context;
	}
	
	public void keyPressed(char c) {
		context.setCurrentState(context.getXTurn());
	}

	public String getScreen() {
		String result = "";

		result += "$$$$$$$$\\ $$\\                $$$$$$$$\\                       $$$$$$$$\\                  \n";
		result += "\\__$$  __|\\__|               \\__$$  __|                      \\__$$  __|                 \n";
		result += "   $$ |   $$\\  $$$$$$$\\         $$ | $$$$$$\\   $$$$$$$\\         $$ | $$$$$$\\   $$$$$$\\  \n";
		result += "   $$ |   $$ |$$  _____|$$$$$$\\ $$ | \\____$$\\ $$  _____|$$$$$$\\ $$ |$$  __$$\\ $$  __$$\\ \n";
		result += "   $$ |   $$ |$$ /      \\______|$$ | $$$$$$$ |$$ /      \\______|$$ |$$ /  $$ |$$$$$$$$ |\n";
		result += "   $$ |   $$ |$$ |              $$ |$$  __$$ |$$ |              $$ |$$ |  $$ |$$   ____|\n";
		result += "   $$ |   $$ |\\$$$$$$$\\         $$ |\\$$$$$$$ |\\$$$$$$$\\         $$ |\\$$$$$$  |\\$$$$$$$\\ \n";
		result += "   \\__|   \\__| \\_______|        \\__| \\_______| \\_______|        \\__| \\______/  \\_______|\n";
		result += "                                                                                        \n";
		result += "                                   [ PRESS ANY KEY ]                                   \n";
		result += "                                                                                        ";

		return result;
	}
}
