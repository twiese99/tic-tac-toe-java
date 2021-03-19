package tictactoe;

public class XTurn extends Turn {
	public XTurn(Context context) {
		super(context);
	}

	@Override
	public String getScreen() {
		String result = "";

		if (isNewTurn()) {
			result += "[ X ist am Zug ]\n";
		}

		result += super.getScreen();
		return result;
	}

	@Override
	protected void nextTurn() {
		context.setCurrentState(context.getOTurn());
	}

	@Override
	protected boolean setStone() {
		return context.getBoard().setStone(Resources.PlayerSymbol.PlayerX, xCoordinate, yCoordinate);
	}
}
