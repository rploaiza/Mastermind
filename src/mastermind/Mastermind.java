package mastermind;

import controller.Controller;
import controller.Logic;

public class Mastermind {

    private Logic logic;

    public Mastermind() {

        logic = new Logic();
    }

    public void play() {

        Controller controller;
        do {
            controller = logic.getController();
            if (controller != null) {
                controller.control();
            }
        } while (controller != null);

    }

    public static void main(String[] args) {
        new Mastermind().play();
    }
}
