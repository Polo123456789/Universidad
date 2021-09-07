package poo.proyecto_final;

import java.util.Scanner;

public class Input {
    private Input() {}

    protected static boolean nombreValido(final String nombre) {
        return nombre.length() != 0
               && nombre.chars().allMatch((int c) -> {
                   return c == ' ' || Character.isAlphabetic(c);
               });
    }

    private static final String nombreInvalidoError = 
        Colors.red("\nLos nombres pueden estar unicamente formados por "
                   + "caracteres de la 'a' a la 'z',\nen mayusculas y "
                   + "minusculas, con espacios. No pueden tener 0 caracteres\n");
        

    public static String leerNombre() {
        Scanner s = new Scanner(System.in);
        String n = "";
        boolean valido = false;
        while (!valido) {
            System.out.print("Nombre: ");
            n = s.nextLine();

            if (nombreValido(n)) {
                valido = true;
                continue;
            }

            System.out.println(nombreInvalidoError);
            System.out.println("Porfavor ingrese otro nombre.");
        }
        return n;
    }
}
