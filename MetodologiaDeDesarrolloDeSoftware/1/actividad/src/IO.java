import java.util.Scanner;

public class IO {
    private static Scanner s = new Scanner(System.in);

    public static String leerLinea() {
        return s.nextLine();
    }

    public static void limpiarPantalla() {
        System.out.println("\033[H\033[2J");
    }

    public static void esperar() {
        System.out.print("\nPresione enter para continuar ...");
        leerLinea();
    }
}
