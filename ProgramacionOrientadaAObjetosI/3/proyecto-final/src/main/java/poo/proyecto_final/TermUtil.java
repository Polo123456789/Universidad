package poo.proyecto_final;

final public class TermUtil {
    private TermUtil() {}

    public static final String[] opcionesDeGestion = {
        "Agregar",
        "Modificar",
        "Eliminar"
    };

    public static final void limpiarPantalla() {
        System.out.println("\033[H\033[2J");
    }

    public static final void imprimirOpciones(String[] opciones) {
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i+1) + ") " + opciones[i]);
        }
        System.out.print('\n');
    }

    public static final void imprimirOpcionesGestion() {
        imprimirOpciones(opcionesDeGestion);
    }
}
