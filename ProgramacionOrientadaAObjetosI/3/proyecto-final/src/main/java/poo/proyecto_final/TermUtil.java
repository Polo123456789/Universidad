package poo.proyecto_final;

final public class TermUtil {
    private TermUtil() {}

    public static final void limpiarPantalla() {
        System.out.println("\033[H\033[2J");
    }
}
