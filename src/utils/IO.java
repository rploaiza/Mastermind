package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void writeln(String string) {
        System.out.println(string);
    }

    public void write(String string) {
        System.out.print(string);
    }

    public String readTocken() {

        String tocken = null;
        try {
            tocken = bufferedReader.readLine();
        } catch (IOException e) {
            this.writeError("de cadena de numeros");
        }
        return tocken;
    }

    public int readInt(String title) {
        int input = 0;
        boolean ok = false;
        do {
            try {
                input = Integer.parseInt(this.readTocken());
                ok = true;
            } catch (Exception ex) {
                this.writeError("entero");
            }
        } while (!ok);
        return input;
    }

    public void writeError(String formato) {
        System.out.println("ERROR DE FORMATO! " + "Introduzca un valor con formato " + formato + ".");
    }

    public String readString(String title) {
        String input = null;
        boolean ok = false;
        do {
            this.write(title);
            try {
                input = bufferedReader.readLine();
                ok = true;
            } catch (Exception ex) {
                this.writeError("de cadena de caracteres");
            }
        } while (!ok);
        return input;
    }

    public char readChar(String title) {
        char charValue = ' ';
        boolean ok = false;
        do {
            String input = this.readString(title);
            if (input.length() != 1) {
                this.writeError("caracter");
            } else {
                charValue = input.charAt(0);
                ok = true;
            }
        } while (!ok);
        return charValue;
    }

    public void error() {
        IO io = new IO();
        io.writeln("Valores no validos, recuerda son 4 numeros");
    }

    public String writeTocken() {
        String result = "";
        int[] secret = new int[4];
        for (int i = 0; i < 4; i++) {
            secret[i] = (int) (Math.random() * 6 + 1);
        }

        result = String.valueOf(secret[0])
                .concat(String.valueOf(secret[1]).concat(String.valueOf(secret[2]).concat(String.valueOf(secret[3]))));
        new IO().writeln(" la máquina pone " + result);
        new IO().readString("Enter para continuar!");
        return result;
    }

}
