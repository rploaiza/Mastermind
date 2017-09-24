package models;

import view.BoardView;

public class Game {
    private State state;

    private BoardView board;

    private Turn turn;

    public static final int OPORTUNITY = 10;

    public static final int BOXMAX = 4;

    public Game() {
        state = State.INITIAL;
        board = new BoardView(Game.BOXMAX, Game.OPORTUNITY);
        turn = new Turn(Game.OPORTUNITY);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public BoardView getBoard() {
        return board;
    }

    public Turn getTurn() {
        return turn;
    }
}
