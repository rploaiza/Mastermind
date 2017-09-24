package view;

import utils.IO;

public class BoardView {

    public BoardView(Integer tokenLength, Integer oportunityLength) {

    }

    public void information(int tokenLength, int oportunityLength) {

        IO io = new IO();
        io.writeln("Bienvenido a Mastermind...!!");
        io.writeln("Intento? [cuatro numeros de entre 1-amarillo, 2-rojo, 3-verde, 4-azul, 5-blanco, 6-negro] ");
        io.writeln("Coloca una combinación de " + tokenLength + " numeros, y tienes " + oportunityLength + " oportunidades");
        io.write("Codigo secreto: >");
        for (int i = 0; i < tokenLength; i++) {
            io.write("*");
        }
        io.writeln("<");
    }

}
