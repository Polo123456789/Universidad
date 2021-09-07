package poo.proyecto_final;

public class Colors {
    private Colors() {}

    private static final String reset = "\033[0m";

    public static String red(String s) {
        return "\033[0;31m" + s + reset;
    }

    public static String green(String s) {
        return "\033[0;32m" + s + reset;
    }

    public static String blue(String s) {
        return "\033[0;34m" + s + reset;
    }
}
