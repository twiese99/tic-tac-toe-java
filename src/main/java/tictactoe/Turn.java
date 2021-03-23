package tictactoe;

import java.text.MessageFormat;

public abstract class Turn implements Action {
    protected Context context;

    protected Integer xCoordinate;
    protected Integer yCoordinate;

    Turn(Context context) {
        this.context = context;
    }

    @Override
    public String getScreen() {
        final StringBuilder stringBuilder = new StringBuilder();
        if (isNewTurn()) {
            stringBuilder.append(context.getBoard().toString()).append("\n");
        }
        stringBuilder.append("Bitte ");
        stringBuilder.append(isNewTurn() ? "Spalte" : "Reihe");
        stringBuilder.append(" eingeben. 1 bis 3 erlaubt, ungültige Eingaben => Abbruch");
        return stringBuilder.toString();
    }

    @Override
    public void keyPressed(char c) {
        if (Character.isDigit(c)) {
            int inputCoordinate = Character.getNumericValue(c) - 1;
            if (Board.isValidXorY(inputCoordinate)) updateCoordinate(inputCoordinate);
        } else {
            resetCoordinates();
        }
        changeState();
    }

    private void updateCoordinate(int inputCoordinate) {
        if (xCoordinate == null) {
            xCoordinate = inputCoordinate;
        } else if (yCoordinate == null) {
            yCoordinate = inputCoordinate;
        }
    }

    protected void changeState() {
        if (bothCoordinatesSet()) {
            evaluateCurrentTurn();
        } else {
            context.setCurrentState(this);
        }
    }

    private void evaluateCurrentTurn() {
        final boolean validTurn = setStone();
        final String messageIfInvalid = MessageFormat.format(
                "[ WARNUNG ] Ungültiger Spielzug! Das Feld bei Spalte {0} und Zeile {1} ist bereits belegt.",
                xCoordinate + 1, yCoordinate + 1
        );
        resetCoordinates();
        if (!validTurn) {
            System.out.println(messageIfInvalid);
            changeState();
        } else if (isGameOver()) {
            context.setCurrentState(context.getEnd());
        } else {
            nextTurn();
        }
    }

    private void resetCoordinates() {
        xCoordinate = null;
        yCoordinate = null;
    }

    private boolean bothCoordinatesSet() {
        return xCoordinate != null && yCoordinate != null;
    }

    private boolean isGameOver() {
        return context.getBoard().isWon() || !context.getBoard().containsFreeFields();
    }

    protected boolean isNewTurn() {
        return (xCoordinate == null);
    }

    protected abstract void nextTurn();

    protected abstract boolean setStone();

}
