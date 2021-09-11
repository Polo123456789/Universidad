import java.util.Scanner;

public class Input {
    private Input() {}
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
        return nombre.chars().allMatch((int c) -> {
                   return c == ' ' || Character.isAlphabetic(c);
               });
    }

    private static final String textoInvalidoError(String tipo) {
        return "\nLos " + tipo + "s pueden estar unicamente formados por "
               + "caracteres de la 'a' a la 'z',\nen mayusculas y "
               + "minusculas, con espacios. No pueden tener 0 caracteres\n";

    }

    private static final String textoVacioError(String tipo) {
        return "\nTiene que ingresar un " + tipo + "\n";
    }

    public static String leerNombre() {
        return leerTexto("nombre");
    }

    public static String leerNombreOVacio() {
        return leerTextoOVacio("nombre");
    }

    public static String leerApellido() {
        return leerTexto("apellido");
    }

    public static String leerApellidoOVacio() {
        return leerTextoOVacio("apellido");
    }

    public static String leerDireccion() {
        Scanner s = new Scanner(System.in);
        String n = "";

        boolean valido = false;
        while (!valido) {
            System.out.print("direccion: ");
            n = s.nextLine();

            if (n.length() == 0) {
                System.out.println("La direccion no puede estar vacia");
                continue;
            }

            valido = true;
        }
        return n;
    }

    public static String leerTexto(String tipo) {
        String s = leerTextoOVacio(tipo);
        while (s == null) {
            System.out.println(textoVacioError(tipo));
            s = leerTextoOVacio(tipo);
        }
        return s;
    }

    public static String leerTextoOVacio(String tipo) {
        Scanner s = new Scanner(System.in);
        String n = "";

        boolean valido = false;
        while (!valido) {
            System.out.print(tipo + ": ");
            n = s.nextLine();

            if (n.length() == 0) {
                return null;
            }

            if (nombreValido(n)) {
                valido = true;
                continue;
            }

            System.out.println(textoInvalidoError(tipo));
            System.out.println("Porfavor ingrese otro " + tipo + ".");
        }
        return n;

    }

    private static final String noEsUnNumeroError =
        "\nLo que ingreso no es un numero entero\n";

    private static final String numeroNoEnRango(final Rango r) {
        return "\nEl numero ingresado tiene que ser como minimo "
               + r.minimo + " y como maximo " + r.maximo + "\n";
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
