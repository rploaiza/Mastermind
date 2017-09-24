package controller;

import models.Game;
import models.State;
import view.BoardView;

public abstract class Controller {

    private Game game;

    protected Controller(Game game) {
        assert game != null;
        this.game = game;
    }

    public abstract void control();

    protected State getState() {
        return game.getState();
    }

    protected void setState(State state) {
        assert state != null;
        game.setState(state);
    }

    protected BoardView getBoard() {
        return game.getBoard();
    }

}
