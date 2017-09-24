package controller;

public class ValidateController {

    private int tokenLength;

    public ValidateController(int tokenLength) {
        this.tokenLength = tokenLength;
    }

    public boolean tockenIsValidate(String tocken) {
        return lengthTocken(tocken, tokenLength) && tockenNumeric(tocken);
    }

    private boolean lengthTocken(String tocken, int tokenLength) {
        return tocken.length() == tokenLength;
    }

    private boolean tockenNumeric(String tocken) {
        assert tocken != null;
        char[] tockenChars = tocken.toCharArray();
        for (char digitChar : tockenChars) {
            Integer.parseInt(String.valueOf(digitChar));
        }
        return true;
    }
}
