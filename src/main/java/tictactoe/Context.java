package tictactoe;

import java.util.Scanner;

public class Context {

	private Aktion splash;
	private Aktion xTurn;
	private Aktion oTurn;
	private Aktion ende;
	private Aktion currentState;
	private Board board;
	
	
	public Context() {
		this.splash = new Splash(this);
		this.xTurn = new XTurn(this);
		this.oTurn = new OTurn(this);
		this.ende = new Ende(this);
		this.board = new Board();

		this.currentState = this.getSplash();
	}


	public void setCurrentState(Aktion s) {
		this.currentState = s;
		System.out.println(s.getScreen());
	}

	public Aktion getSplash() {
		return this.splash;
	}


	public Aktion getXTurn() {
		return this.xTurn;
	}


	public Aktion getOTurn() {
		return this.oTurn;
	}


	public Aktion getEnde() {
		return this.ende;
	}

	public Board getBoard() {
		return this.board;
	}

	public void keyPressed(char c) {
		this.currentState.keyPressed(c);
	}

	
	public static void main(String[] args) {
		
		// Startbildschirm
		Context context = new Context();

		Scanner scanner = new Scanner(System.in);
        while (true){
            String s = scanner.next();
            context.keyPressed(s.charAt(0));
        }

	}

}
