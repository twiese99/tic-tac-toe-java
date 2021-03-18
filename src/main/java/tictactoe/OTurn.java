package tictactoe;

public class OTurn extends Turn {
	public OTurn(Context context) {
		super(context);
	}

	@Override
	public String getScreen() {
		String result = "[ O ist am Zug ]\n\n";
		result += super.getScreen();
		return result;
	}

	@Override
	protected void nextTurn() {
		context.setCurrentState(context.getXTurn());
	}

	@Override
	protected boolean setStone() {
		return context.getBoard().setStone('O', xCoordinate, yCoordinate);
	}
}
