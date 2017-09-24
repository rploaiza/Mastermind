package models;

import utils.IO;

public class Turn {

    private Integer oportunityMax;

    private IO io;

    public Turn(int oportunity) {
        this.oportunityMax = oportunity;
        io = new IO();
    }

    public int oportunity(int numberOportunity) {
        io.write("Intento #" + (oportunityMax - numberOportunity) + " >");
        return numberOportunity;
    }

}
