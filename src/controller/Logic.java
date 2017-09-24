package controller;

import models.Game;
import utils.IO;
import utils.LimitedIntDialog;

public class Logic {
    private Game game;

    private String tocken;

    private StartController startController;

    private ContinueController continueController;

    private PutController putController;

    public Logic() {
        game = new Game();
        startController = new StartController(game);
        continueController = new ContinueController(game);
        putController = new PutController(Game.BOXMAX, Game.OPORTUNITY);
    }

    public Controller getController() {
        switch (game.getState()) {
        case INITIAL:
            return startController;
        case IN_GAME:
            int numberOportunity = 0;
            int users = new LimitedIntDialog("Cuántos usuarios?", 0, 1).read();
            do {
                game.getTurn().oportunity(numberOportunity);
                for (int i = 0; i < 1; i++) {
                    if (i < users) {
                        tocken = new IO().readTocken();
                    } else {
                        tocken = new IO().writeTocken();
                    }
                }
                if (!putController.getTockensFail(tocken)) {
                    new IO().error();
                    continue;
                }
                numberOportunity++;
                if (putController.getTockensGood(tocken)) {
                    putController.win();
                    break;
                } else {
                    putController.result();
                }
            } while (!putController.gameOver(numberOportunity, Game.OPORTUNITY));
        case FINAL:
            return continueController;
        case EXIT:
        default:
            return null;
        }
    }
}
