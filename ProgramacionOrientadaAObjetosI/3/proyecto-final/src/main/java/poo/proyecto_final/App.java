package poo.proyecto_final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Primer test para concectarse a una base de datos
 */
public class App {
    public static void main(String[] args) {
        // Nos aseguramos de tener el driver
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (final ClassNotFoundException e) {
            System.err.println(e);
            return;
        }

        Connection con = null;

        try {
            String connection_string = "jdbc:sqlite:test.db";

            con = DriverManager.getConnection(connection_string);

            System.out.println("Se ha establecido la concecion a la base de datos");
        } catch (final SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (final SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
