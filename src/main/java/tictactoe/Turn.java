package tictactoe;

public abstract class Turn implements Action {
    protected Context context;
    protected boolean shouldStartNextTurn;

    protected Integer xCoordinate;
    protected Integer yCoordinate;

    Turn(Context context) {
        this.context = context;
    }

    @Override
    public String getScreen() {
        String result = "";

        if (isNewTurn()) {
            result += context.getBoard().toString();
            result += "\n";
        }

        String wantedCoordinate = "";
        if (xCoordinate == null) {
            wantedCoordinate = "Spalte";
        } else {
            wantedCoordinate = "Reihe";
        }

        result += "Bitte " + wantedCoordinate + " eingeben. 1 bis 3 erlaubt, ungültige Eingaben => Abbruch";
        return result;
    }

    @Override
    public void keyPressed(char c) {
        shouldStartNextTurn = false;
        if (Character.isDigit(c)) {
            int inputCoordinate = Character.getNumericValue(c) - 1;
            if (isCoordinateInRange(inputCoordinate)) {
                if (xCoordinate == null) {
                    xCoordinate = inputCoordinate;
                } else if (yCoordinate == null) {
                    yCoordinate = inputCoordinate;
                    shouldStartNextTurn = true;
                }
            }
        } else {
            resetCoordinates();
        }
        changeState();
    }

    protected void changeState() {
        if (shouldStartNextTurn) {
            if (setStone()) {
                resetCoordinates();
                if (context.getBoard().isWon() || !context.getBoard().containsFreeFields()) {
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
                shouldStartNextTurn = false;
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

    protected boolean isNewTurn() {
        return (xCoordinate == null);
    }

    protected abstract void nextTurn();

    protected abstract boolean setStone();

    private boolean isCoordinateInRange(int coordinate) {
        return (coordinate >= 0 && coordinate <= 2);
    }
}
