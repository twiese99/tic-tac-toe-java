package tictactoe;

public class Context {

	private Aktion splash;
	private Aktion xTurn;
	private Aktion oTurn;
	private Aktion ende;
	private Aktion currentState;
	private World world;
	
	
	public void setCurrentState(Aktion s) {
		
	}
	
	
	public Aktion getSplash() {
		return splash;
	}


	public Aktion getxTurn() {
		return xTurn;
	}


	public Aktion getoTurn() {
		return oTurn;
	}


	public Aktion getEnde() {
		return ende;
	}

	public World getWorld() {
		return world;
	}

	public void keyPressed(char c) {
		
	}
	
	public void numPressed(int i) {
		
	}
}
