package poo.proyecto_final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.Consumer;

/**
 * Singleton destinado a gestionar la base de datos
 */
public final class DB {
    private static DB instance = null;
    private Connection conn = null;

    private DB() {}

    public static DB obtenerInstancia() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }

    public void conectar() throws SQLException {
        conn = DriverManager.getConnection(DBUtils.connectionString);
    }

    public void cerrarConexion() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (final SQLException e) {
            System.err.println(e);
        }
    }

    public Statement ejecutarQuery(String query) throws SQLException {
        Statement s = conn.createStatement();
        s.execute(query);
        return s;
    }

    /**
     * Ejecuta un query con parametros
     *
     * @param query Las instrucciones sql a ejecutar
     * @param llenar_params Un lambda que se encarga de llenar los parametros
     *                      del query
     *
     * Ejemplo:
     *
     * ```java
     * String nombre = "Algun nombre";
     *
     * db.ejecutarQueryConParametros(
     *      "INSERT INTO escuelaAcademica (nombre) VALUES (?)",
     *      (PreparedStatement s) -> {
     *          s.setString(1, nombre);
     *      }
     *  );
     * ```
     */
    public void ejecutarQueryConParametros(String               query,
                                           LlenadorDeParametros llenar_params)
                                             throws SQLException {
            
        PreparedStatement s = conn.prepareStatement(query);
        llenar_params.apply(s);
        s.executeUpdate();
    }

    public void crearTablas() throws SQLException {
        String[] querys = DBUtils.querysParaCrearTablas.split("\n\n");
        for (String q : querys) {
            ejecutarQuery(q);
        }
    }

}
