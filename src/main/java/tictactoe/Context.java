package tictactoe;

import java.util.Scanner;

public class Context {

	private final Action splash;
	private final Action xTurn;
	private final Action oTurn;
	private final Action end;
	private Action currentState;
	private final Board board;
	
	
	public Context() {
		this.splash = new Splash(this);
		this.xTurn = new XTurn(this);
		this.oTurn = new OTurn(this);
		this.end = new End(this);
		this.board = new Board();

		this.currentState = this.getSplash();
		printScreen();
	}

	public void setCurrentState(Action state) {
		this.currentState = state;
		printScreen();
	}

	private void printScreen() {
		System.out.println(currentState.getScreen());
	}

	public Action getSplash() {
		return this.splash;
	}


	public Action getXTurn() {
		return this.xTurn;
	}


	public Action getOTurn() {
		return this.oTurn;
	}


	public Action getEnd() {
		return this.end;
	}

	public Board getBoard() {
		return this.board;
	}

	public void keyPressed(char c) {
		this.currentState.keyPressed(c);
	}

	
	public static void main(String[] args) {
		final Context context = new Context();

		final Scanner scanner = new Scanner(System.in);
        while (true) {
            String s = scanner.next();
            context.keyPressed(s.charAt(0));
        }
	}
}
