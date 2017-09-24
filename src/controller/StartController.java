package controller;

import models.Game;
import models.State;

public class StartController extends Controller {

    protected StartController(Game game){
        super(game);
    }
    
    public void control() {
        assert this.getState() == State.INITIAL;
        this.getBoard().information(Game.BOXMAX, Game.OPORTUNITY);
        this.setState(State.IN_GAME);
    }


}
