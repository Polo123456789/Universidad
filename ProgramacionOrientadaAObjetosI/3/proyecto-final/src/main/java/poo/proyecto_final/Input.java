package poo.proyecto_final;

import java.util.Scanner;

public class Input {
    private Input() {}
    /**
     * Rango en el que pueden estar los enteros al leerse desde la terminal
     */
    static public class Rango {
        public int minimo;
        public int maximo;

        public Rango(int min, int max) {
            this.minimo = min;
            this.maximo = max;
        }

        public boolean enRango(int i) {
            return i >= minimo && i <= maximo;
        }
    }

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

    private static final String noEsUnNumeroError = 
        Colors.red("\nLo que ingreso no es un numero entero\n");

    private static final String numeroNoEnRango(final Rango r) {
        return Colors.red("\nEl numero ingresado tiene que ser como minimo "
                          + r.minimo + " y como maximo " + r.maximo + "\n");
    }

    public static Integer leerNumero() {
        Scanner s = new Scanner(System.in);
        Integer n = 0;

        boolean valido = false;
        while (!valido) {
            final String temp = s.nextLine();
            try {
                n = Integer.parseInt(temp);
                valido = true;
                continue;

            } catch (final NumberFormatException e) {
                System.out.println(noEsUnNumeroError);
                System.out.print("Porfavor ingrese otro numero: ");
            }

        }
        return n;
    }

    public static Integer leerNumero(final Rango r) {
        Scanner s = new Scanner(System.in);
        Integer n = 0;

        boolean valido = false;
        while (!valido) {
            final String temp = s.nextLine();
            try {
                n = Integer.parseInt(temp);
                if (r.enRango(n)) {
                    valido = true;
                    continue;
                }

                System.out.println(numeroNoEnRango(r));
                System.out.print("Porfavor ingrese otro numero: ");

            } catch (final NumberFormatException e) {
                System.out.println(noEsUnNumeroError);
                System.out.print("Porfavor ingrese otro numero: ");
            }

        }
        return n;
    }


}

