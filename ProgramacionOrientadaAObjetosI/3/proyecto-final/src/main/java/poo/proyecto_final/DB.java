package poo.proyecto_final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

    public void ejecutarQuery(String query) throws SQLException {
        Statement s = conn.createStatement();
        s.execute(query);
    }

    public void crearTablas() throws SQLException {
        String[] querys = DBUtils.querysParaCrearTablas.split("\n\n");
        for (String q : querys) {
            ejecutarQuery(q);
        }
    }

}
