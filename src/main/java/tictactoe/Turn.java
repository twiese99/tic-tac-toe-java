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
        stringBuilder.append(xCoordinate == null ? "Spalte" : "Reihe");
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
        if (shouldStartNextTurn()) {
            if (setStone()) {
                resetCoordinates();
                if (isGameOver()) {
                    context.setCurrentState(context.getEnd());
                } else {
                    nextTurn();
                }
            } else {
                System.out.println(
                    "[ WARNUNG ] Ungültiger Spielzug! Das Feld bei Spalte " +
                    (xCoordinate + 1) +
                    " und Zeile " +
                    (yCoordinate + 1) +
                    " ist bereits belegt."
                );
                resetCoordinates();
                changeState();
            }
        } else {
            context.setCurrentState(this);
        }
    }

    private void resetCoordinates() {
        xCoordinate = null;
        yCoordinate = null;
    }

    private boolean shouldStartNextTurn() {
        if (xCoordinate == null || yCoordinate == null) {
            return false;
        }
        return true;
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
