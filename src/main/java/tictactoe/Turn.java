package tictactoe;

public abstract class Turn implements Action {
    protected Context context;
    protected boolean shouldStartNextTurn;

    Integer xCoordinate;
    Integer yCoordinate;

    Turn(Context context) {
        this.context = context;
    }

    @Override
    public String getScreen() {
        String result = context.getBoard().toString();
        result += "\n";

        String wantedCoordinate = "";
        if (xCoordinate == null) {
            wantedCoordinate = "Spalte";
        } else {
            wantedCoordinate = "Reihe";
        }

        result += "\nBitte " + wantedCoordinate + " eingeben. 1 bis 3 erlaubt, ungültige Eingaben => Abbruch";
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
            xCoordinate = null;
            yCoordinate = null;
        }
        changeState();
    }

    protected void changeState() {
        if (context.getBoard().isWon()) {
            context.setCurrentState(context.getEnd());
        } else if (shouldStartNextTurn) {
            if (setStone()) {
                xCoordinate = null;
                yCoordinate = null;
                nextTurn();
            } else {
                System.out.println(
                    "[ WARNUNG ] Ungültiger Spielzug! Das Feld bei Spalte " +
                    (xCoordinate + 1) +
                    " und Zeile " +
                    (yCoordinate + 1) +
                    " ist bereits belegt."
                );
                shouldStartNextTurn = false;
                changeState();
            }
        } else {
            context.setCurrentState(this);
        }
    }

    protected abstract void nextTurn();

    protected abstract boolean setStone();

    private boolean isCoordinateInRange(int coordinate) {
        return (coordinate >= 0 && coordinate <= 2);
    }
}
