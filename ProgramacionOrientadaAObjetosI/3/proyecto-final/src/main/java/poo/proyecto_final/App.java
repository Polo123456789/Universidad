package poo.proyecto_final;

import java.sql.SQLException;
import java.util.ArrayList;

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
        } catch (final SQLException e) {
            System.out.println(e);
        } finally {
            System.out.println("\nCerrando la conexion a la base de datos ...");
            db.cerrarConexion();
            System.out.println("Finalizado");
        }
    }

    public static void mainLoop(DB db) throws SQLException {
        System.out.println("Cargando Escuelas ...");
        ArrayList<EscuelaAcademica> escuelas = EscuelaAcademica.cargarDesde(db);

        for (EscuelaAcademica e : escuelas) {
            System.out.println(e);
        }

        System.out.println("Y ahora leamos una de la terminal.");

        EscuelaAcademica escuelita = EscuelaAcademica.leerDesdeTerminal();

        System.out.println(escuelita);
    }

    /**
     * Ve que este el driver disponible, y se conecta a la base de datos,
     * creandola de ser necesario.
     */
    public static DB inicializarDB() {
        TermUtil.limpiarPantalla();

        // Nos aseguramos de tener el driver
        if (!DBUtils.seTieneElDriver()) {
            System.err.println("No esta disponible el driver para conectarse "
                               + "con sqlite3.");
            System.err.println("Asegurese de estar usando la version con " 
                               + "dependencias incluidas o añadir "
                               + "`sqlite-jdbc-3.36.0.3.jar` manualmente al "
                               + "classpath");
            return null;
        }

        DB db = DB.obtenerInstancia();

        // Creamos la base de datos si no existe
        try {
            if (!DBUtils.existeLaDB()) {
                System.out.println("No se ha encontrado una base de datos.");
                System.out.println("Creando la base de datos...");
                Thread.sleep(1000);

                // No hay que crear el archivo, al conectar automaticamente se
                // creara
                db.conectar();
                db.crearTablas();
            } else {
                // Si ya existe unicamente nos conectamos, sin crear nada
                System.out.println("Se ha encontrado una base de datos. " +
                                   "Conectando ...");
                Thread.sleep(1000);
                db.conectar();
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
}
