public class Main {
    public static void main(String[] args) {
        Boolean exit = false;

        while (!exit) {
            IO.limpiarPantalla();
            System.out.println("1. Iniciar Sesion");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");

            System.out.print("\nOpcion: ");
            Integer opcion = Integer.parseInt(IO.leerLinea());

            switch (opcion) {
            case 1:
                iniciarSesion();
                break;
            case 2:
                registrarse();
                break;
            case 3:
                exit = true;
                break;
            default:
                System.out.println("Escoja una opcion valida.");
                IO.esperar();
                IO.limpiarPantalla();
                break;
            }
        }
    }

    public static void registrarse() {
        var gestorUsuarios = GestorUsuarios.instanciar();
        IO.limpiarPantalla();
        System.out.println("--- Crear cuenta ---\n");

        gestorUsuarios.crearUsuario();
        IO.esperar();
    }

    public static void iniciarSesion() {
        var gestorUsuarios = GestorUsuarios.instanciar();
        IO.limpiarPantalla();
        System.out.println("--- Iniciar Sesion ---\n");

        System.out.print("Usuario: ");
        String nombre = IO.leerLinea();

        System.out.print("Contraseña: ");
        String pwd = IO.leerLinea();

        var usuario = gestorUsuarios.buscaUsuario(nombre);
        if (usuario == null) {
            System.out.println("El usuario que ha ingresado no existe");
            IO.esperar();
            return;
        }

        if (!usuario.getPasswd().equals(pwd)) {
            System.out.println("La contraseña que ha ingresado no es correcta");
            IO.esperar();
            return;
        }

        System.out.println("Inicio de sesion correcto");
        IO.esperar();
    }
}
