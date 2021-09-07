package poo.proyecto_final;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        DB db = inicializarDB();

        // Ya se imprimio el error en `inicializarDB` si hubo alguno
        if (db == null) {
            return;
        }

        // Y entramos en la applicacion
        try {
            mainLoop(db);
        } catch (final Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("\nCerrando la conexion a la base de datos ...");
            db.cerrarConexion();
            System.out.println("Finalizado");
        }
    }

    public static void mainLoop(DB db) throws SQLException, InterruptedException {
        boolean quiereSalir = false;
        while(!quiereSalir) {
            TermUtil.limpiarPantalla();
            System.out.println(Colors.blue(banner));
            TermUtil.imprimirOpciones(menuPrincipal);

            System.out.print(Colors.blue("Opcion: "));
            final int opcion = Input.leerNumero(new Input.Rango(1, 5));
            switch (opcion) {
                case 1:
                    EscuelaAcademica.gestionar(db);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    quiereSalir = true;
                    break;
            }
        }
    }

    /**
     * Ve que este el driver disponible, y se conecta a la base de datos,
     * creandola de ser necesario.
     */
    public static DB inicializarDB() {
        TermUtil.limpiarPantalla();

        // Nos aseguramos de tener el driver
        if (!DBUtils.seTieneElDriver()) {
            System.err.println(
                    Colors.red("No esta disponible el driver para conectarse "
                               + "con sqlite3.")
            );
            System.err.println(
                Colors.red("Asegurese de estar usando la version con " 
                + "dependencias incluidas o añadir "
                + "`sqlite-jdbc-3.36.0.3.jar` manualmente al "
                + "classpath")
            );
            return null;
        }

        DB db = DB.obtenerInstancia();

        // Creamos la base de datos si no existe
        try {
            if (!DBUtils.existeLaDB()) {
                System.out.println("No se ha encontrado una base de datos.");
                System.out.println("Creando la base de datos...");
                db.conectar();
                db.crearTablas();
                System.out.println(Colors.green("Base de datos creada con exito"));
                Thread.sleep(1000);
            } else {
                // Si ya existe unicamente nos conectamos, sin crear nada
                System.out.println("Se ha encontrado una base de datos. " +
                                   "Conectando ...");
                db.conectar();
                System.out.println(Colors.green("Conexion exitosa"));
                Thread.sleep(1000);
            }

        } catch (final SQLException e) {
            System.err.println("No se ha podido crear/conectar a la DB.");
            System.err.println(e);
            return null;
        } catch (final InterruptedException e) {
            System.err.println(e);
            return null;
        }

        TermUtil.limpiarPantalla();
        return db;
    }

    // Este codigo fue creado utilizando una herramienta a base del archivo
    // ".\docs\banner.txt" Si quiere cambiarlo, modifique el archivo original y
    // vuelva a correr la herramienta
    private static final String banner =
        "  _____   ____   ____       _____                                \n" +
        " |  __ \\ / __ \\ / __ \\     |_   _|                               \n" +
        " | |__) | |  | | |  | |      | |                                 \n" +
        " |  ___/| |  | | |  | |      | |                                 \n" +
        " | |    | |__| | |__| |     _| |_                                \n" +
        " |_|___  \\____/ \\____/     |_____|_           __ _             _ \n" +
        " |  __ \\                         | |         / _(_)           | |\n" +
        " | |__) | __ ___  _   _  ___  ___| |_ ___   | |_ _ _ __   __ _| |\n" +
        " |  ___/ '__/ _ \\| | | |/ _ \\/ __| __/ _ \\  |  _| | '_ \\ / _` | |\n" +
        " | |   | | | (_) | |_| |  __/ (__| || (_) | | | | | | | | (_| | |\n" +
        " |_|   |_|  \\___/ \\__, |\\___|\\___|\\__\\___/  |_| |_|_| |_|\\__,_|_|\n" +
        "                   __/ |                                         \n" +
        "                  |___/                                          \n";

    private static final String[] menuPrincipal = {
        "Escuelas Tecnicas",
        "Decanos",
        "Profesores",
        "Directores",
        "Salir"
    };

}
