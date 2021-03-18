package tictactoe;

public class XTurn extends Turn {
	public XTurn(Context context) {
		super(context);
	}

	@Override
	public String getScreen() {
		String result = "[ X ist am Zug ]\n\n";
		result += super.getScreen();
		return result;
	}

	@Override
	protected void nextTurn() {
		context.setCurrentState(context.getOTurn());
	}

	@Override
	protected boolean setStone() {
		return context.getBoard().setStone('X', xCoordinate, yCoordinate);
	}
}
