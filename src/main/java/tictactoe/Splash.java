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
		return Resources.AnsiArt.SPLASH;
	}
}
