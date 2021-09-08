package poo.proyecto_final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

    public Statement ejecutarQuery(final String query) throws SQLException {
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
    public void ejecutarQueryConParametros(final String               query,
                                           final LlenadorDeParametros llenar_params)
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

    public void insertar(final EscuelaAcademica e) throws SQLException {
        ejecutarQueryConParametros(
            "INSERT INTO escuelaAcademica (nombre) VALUES (?)",
            (PreparedStatement s) -> {
                s.setString(1, e.getNombre());
            }
        );
    }

    public void actualizar(final EscuelaAcademica e) throws SQLException {
        ejecutarQueryConParametros(
            "UPDATE escuelaAcademica SET nombre = ? WHERE id = ?",
            (PreparedStatement s) -> {
                s.setString(1, e.getNombre());
                s.setInt(2, e.getId());
            }
        );
    }

    public void eliminar(final EscuelaAcademica e) throws SQLException {
        ejecutarQueryConParametros(
            "DELETE FROM escuelaAcademica WHERE id = ?",
            (PreparedStatement s) -> {
                s.setInt(1, e.getId());
            }
        );
    }

    public void insertar(final Profesor p) throws SQLException {
        ejecutarQueryConParametros(
            "INSERT INTO profesor (nombre, apellidos) VALUES (?,?)", 
            (PreparedStatement s) -> {
                s.setString(1, p.getNombre());
                s.setString(2, p.getApellidos());
            }
        );
    }

    public void actualizar(final Profesor p) throws SQLException {
        ejecutarQueryConParametros(
            "UPDATE profesor SET nombre = ?, apellidos = ? WHERE id = ?", 
            (PreparedStatement s) -> {
                s.setString(1, p.getNombre());
                s.setString(2, p.getApellidos());
                s.setInt(3, p.getId());
            }
        );
    }

    public void eliminar(final Profesor p) throws SQLException {
        ejecutarQueryConParametros(
            "DELETE FROM profesor WHERE id = ?", 
            (PreparedStatement s) -> {
                s.setInt(1, p.getId());
            }
        );
    }

    public void insertar(final Decano d) throws SQLException {
        ejecutarQueryConParametros(
            "INSERT INTO decano (nombre, apellidos) VALUES (?,?)", 
            (PreparedStatement s) -> {
                s.setString(1, d.getNombre());
                s.setString(2, d.getApellidos());
            }
        );
    }

    public void actualizar(final Decano d) throws SQLException {
        ejecutarQueryConParametros(
            "UPDATE decano SET nombre = ?, apellidos = ? WHERE id = ?", 
            (PreparedStatement s) -> {
                s.setString(1, d.getNombre());
                s.setString(2, d.getApellidos());
                s.setInt(3, d.getId());
            }
        );
    }

    public void eliminar(final Decano d) throws SQLException {
        ejecutarQueryConParametros(
            "DELETE FROM decano WHERE id = ?", 
            (PreparedStatement s) -> {
                s.setInt(1, d.getId());
            }
        );
    }

    public void insertar(final Carrera c) throws SQLException {
        ejecutarQueryConParametros(
            "INSERT INTO carrera (nombre, idDecano, idEscuela) VALUES (?,?,?)",
            (PreparedStatement s) -> {
                s.setString(1, c.getNombre());
                s.setInt(2, c.getIdDecano());
                s.setInt(3, c.getIdEscuela());
            }
        );
    }

    public void actualizar(final Carrera c) throws SQLException {
        ejecutarQueryConParametros(
            "UPDATE carrera SET nombre = ?, idDecano = ?, idEscuela = ? "
            + "WHERE id = ?",
            (PreparedStatement s) -> {
                s.setString(1, c.getNombre());
                s.setInt(2, c.getIdDecano());
                s.setInt(3, c.getIdEscuela());
                s.setInt(4, c.getId());
            }
        );
    }

    public void eliminar(final Carrera c) throws SQLException {
        ejecutarQueryConParametros(
            "DELETE FROM carrera WHERE id = ?", 
            (PreparedStatement s) -> {
                s.setInt(1, c.getId());
            }
        );
    }

    
    public void insertar(final Director d) throws SQLException {
        if (d != null) {
            System.out.println(Colors.red("El director no es nulo"));
        }
        ejecutarQueryConParametros(
            "INSERT INTO director (nombre, apellidos, idCarrera) VALUES (?,?,?)", 
            (PreparedStatement s) -> {
                if (s != null) {
                    System.out.println(Colors.red("El statement no es nulo"));
                }


                System.out.println(Colors.red("Se empezo a ejecutar el statement"));
                s.setString(1, d.getNombre());
                System.out.println(Colors.red("Se inserto el nombre"));
                s.setString(2, d.getApellidos());
                System.out.println(Colors.red("Se inserto el apellido"));
                s.setInt(3, d.getIdCarrera());
                System.out.println(Colors.red("Se inserto la carrera"));
                System.out.println(Colors.red("Llenado finalizado"));
            }
        );
    }

    public void actualizar(final Director d) throws SQLException {
        ejecutarQueryConParametros(
            "UPDATE director SET nombre = ?, apellidos = ?, idCarrera = ? "
            + "WHERE id = ?", 
            (PreparedStatement s) -> {
                s.setString(1, d.getNombre());
                s.setString(2, d.getApellidos());
                s.setInt(3, d.getIdCarrera());
                s.setInt(4, d.getId());
            }
        );
    }

    public void eliminar(final Director d) throws SQLException {
        ejecutarQueryConParametros(
            "DELETE FROM director WHERE id = ?", 
            (PreparedStatement s) -> {
                s.setInt(1, d.getId());
            }
        );
    }
    
}
