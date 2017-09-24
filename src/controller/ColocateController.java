package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import utils.IO;

public class ColocateController {

    private ValidateController validateTocken;

    private List<Integer> codeTocken;

    private List<Integer> readTocken;

    protected ColocateController(Integer tokenLength, Integer oportunityMax) {
        generateTokensSecret(tokenLength);
        validateTocken = new ValidateController(tokenLength);
    }

    protected void generateTokensSecret(int tokenLength) {
        this.codeTocken = new ArrayList<Integer>(tokenLength);
        do {
            Random random = new Random();
            int randomNumber = random.nextInt(6);
            if (!this.codeTocken.contains(randomNumber)) {
                this.codeTocken.add(randomNumber);

            }
        } while (this.codeTocken.size() < tokenLength);
    }

    public String getCode() {
        return String.format("%s%s%s%s", codeTocken.toArray());
    }

    public int getHerido() {
        int white = 0;
        boolean[] checked = new boolean[codeTocken.size()];
        for (int i = 0; i < codeTocken.size(); i++) {
            for (int j = 0; j < codeTocken.size(); j++) {
                if (readTocken.get(i) == codeTocken.get(i)) {
                    break;
                }
                if (readTocken.get(i) == codeTocken.get(j) && checked[j] == false && i != j) {
                    white++;
                    checked[j] = true;
                    break;
                }
            }
        }
        return white;
    }

    public int getMuerto() {
        int black = 0;
        for (int i = 0; i < codeTocken.size(); i++) {
            if (readTocken.get(i) == codeTocken.get(i))
                black++;
        }
        return black;
    }

    public boolean getTockensFail(String tocken) {
        return validateTocken.tockenIsValidate(tocken);
    }

    public boolean getTockensGood(String tocken) {
        this.readTocken = convertStringToArrayList(tocken);
        return (getMuerto() == codeTocken.size());
    }

    public void result() {
        IO io = new IO();
        io.writeln(getMuerto() + " muertos y " + getHerido() + " heridos");
    }

    public void win() {
        IO io = new IO();
        io.writeln(getMuerto() + " muertos!!! Victoria! \n");
    }

    public boolean gameOver(Integer numberOportunity, Integer oportunityMax) {
        if (numberOportunity == oportunityMax) {
            IO io = new IO();
            io.writeln("\nPerdiste, superaste el numero de intentos\nel codigo era >" + getCode() + "<");
            return true;
        }
        return false;
    }

    private List<Integer> convertStringToArrayList(String text) {
        List<Integer> result = new ArrayList<Integer>(text.length());
        for (int i = 0; i < text.length(); i++) {
            result.add(Integer.parseInt(text.substring(i, i + 1)));
        }
        return result;
    }

}
