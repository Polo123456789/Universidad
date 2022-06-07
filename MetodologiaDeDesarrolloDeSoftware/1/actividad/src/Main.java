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

        gestorUsuarios.setUsuarioActivo(usuario);
        System.out.println("Inicio de sesion correcto");
        IO.esperar();
        gestionarEventos();
    }

    public static void gestionarEventos() {
        var gestorUsuarios = GestorUsuarios.instanciar();
        Boolean exit = false;

        while (!exit) {
            IO.limpiarPantalla();
            System.out.println("1. Crear Evento");
            System.out.println("2. Listar Eventos");
            System.out.println("3. Eliminar Evento");
            System.out.println("4. Editar Evento");
            System.out.println("5. Cerrar Sesion");

            System.out.print("\nOpcion: ");
            Integer opcion = Integer.parseInt(IO.leerLinea());

            switch (opcion) {
            case 1:
                crearEvento();
                break;
            case 2:
                listarEventos();
                break;
            case 3: 
                eliminarEvento();
                break;
            case 4:
                editarEvento();
                break;
            case 5:
                gestorUsuarios.setUsuarioActivo(null);
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

    public static void crearEvento() {
        var gestorEventos = GestorEventos.instanciar();

        IO.limpiarPantalla();
        System.out.println("--- Crear evento ---\n");
        gestorEventos.crearEvento();
        IO.esperar();
    }

    public static void listarEventos() {
        var gestorEventos = GestorEventos.instanciar();

        IO.limpiarPantalla();
        System.out.println("--- Lista de eventos ---\n");
        gestorEventos.listarEventos();
        IO.esperar();
    }

    public static void eliminarEvento() {
        var gestorEventos = GestorEventos.instanciar();

        IO.limpiarPantalla();
        System.out.println("--- Eliminar Evento ---\n");
        gestorEventos.eliminarEvento();
        IO.esperar();
    }

    public static void editarEvento() {
        var gestorEventos = GestorEventos.instanciar();

        IO.limpiarPantalla();
        System.out.println("--- Editar Evento ---\n");
        gestorEventos.editarEvento();
        IO.esperar();
    }
}
