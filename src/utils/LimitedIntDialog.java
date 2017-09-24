package utils;

public class LimitedIntDialog {
    
    private String title;

    private ClosedInterval limits;

    public LimitedIntDialog(String title, int min, int max) {
        assert title != null;
        this.limits = new ClosedInterval(min, max);
        this.title = title + " " + limits + ": ";
    }

    public LimitedIntDialog(String title, int max) {
        this(title, 1, max);
    }

    public int read() {
        IO io = new IO();
        io.writeln("Presiona 1 para jugar, si deseas ver el demo presiona 0");
        int value;
        boolean ok;
        do {
            value = io.readInt(title);
            ok = limits.includes(value);
            if (!ok) {
                io.writeln("El valor debe estar entre " + limits);
            }
        } while (!ok);
        return value;
    }
}
