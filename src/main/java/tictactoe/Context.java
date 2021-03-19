package tictactoe;

import java.util.Scanner;

public class Context {

	private Action splash;
	private Action xTurn;
	private Action oTurn;
	private Action end;
	private Action currentState;
	private Board board;
	
	
	public Context() {
		this.splash = new Splash(this);
		this.xTurn = new XTurn(this);
		this.oTurn = new OTurn(this);
		this.end = new End(this);
		this.board = new Board();

		this.currentState = this.getSplash();
	}

	public void setCurrentState(Action s) {
		this.currentState = s;
		System.out.println(s.getScreen());
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
		// Startbildschirm
		final Context context = new Context();
		context.setCurrentState(context.getSplash());

		final Scanner scanner = new Scanner(System.in);
        while (true){
            String line = scanner.nextLine();
            line = line.isEmpty() ? " " : line;
            context.keyPressed(line.charAt(0));
        }

	}

}
