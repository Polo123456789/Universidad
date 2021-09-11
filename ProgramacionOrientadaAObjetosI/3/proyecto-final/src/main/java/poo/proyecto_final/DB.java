package poo.proyecto_final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public Integer ultimoIdInsertado() throws SQLException {
        ResultSet rs = ejecutarQuery("SELECT last_insert_rowid()").getResultSet();
        rs.next();
        return rs.getInt("last_insert_rowid()");
    }

    public Integer insertar(final EscuelaAcademica e) throws SQLException {
        ejecutarQueryConParametros(
            "INSERT INTO escuelaAcademica (nombre) VALUES (?)",
            (PreparedStatement s) -> {
                s.setString(1, e.getNombre());
            }
        );
        return ultimoIdInsertado();
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

    public Integer insertar(final Profesor p) throws SQLException {
        ejecutarQueryConParametros(
            "INSERT INTO profesor (nombre, apellidos) VALUES (?,?)", 
            (PreparedStatement s) -> {
                s.setString(1, p.getNombre());
                s.setString(2, p.getApellidos());
            }
        );
        return ultimoIdInsertado();
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

    public Integer insertar(final Decano d) throws SQLException {
        ejecutarQueryConParametros(
            "INSERT INTO decano (nombre, apellidos) VALUES (?,?)", 
            (PreparedStatement s) -> {
                s.setString(1, d.getNombre());
                s.setString(2, d.getApellidos());
            }
        );
        return ultimoIdInsertado();
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

    public Integer insertar(final Carrera c) throws SQLException {
        ejecutarQueryConParametros(
            "INSERT INTO carrera (nombre, idDecano, idEscuela) VALUES (?,?,?)",
            (PreparedStatement s) -> {
                s.setString(1, c.getNombre());
                s.setInt(2, c.getIdDecano());
                s.setInt(3, c.getIdEscuela());
            }
        );
        return ultimoIdInsertado();
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

    
    public Integer insertar(final Director d) throws SQLException {
        ejecutarQueryConParametros(
            "INSERT INTO director (nombre, apellidos, idCarrera) VALUES (?,?,?)", 
            (PreparedStatement s) -> {
                s.setString(1, d.getNombre());
                s.setString(2, d.getApellidos());
                s.setInt(3, d.getIdCarrera());
            }
        );
        return ultimoIdInsertado();
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

    public Integer insertar(final Horario h) throws SQLException {
        ejecutarQueryConParametros(
            "INSERT INTO horario (aula, dia, inicio, final) VALUES "
            + "(?,?,?,?)",
            (PreparedStatement s) -> {
                s.setInt(1, h.getAula());
                s.setInt(2, h.getDia());
                s.setInt(3, h.getInicio());
                s.setInt(4, h.getFin());
            }
        );
        return ultimoIdInsertado();
    }

    public void actualizar(final Horario h) throws SQLException {
        ejecutarQueryConParametros(
            "UPDATE horario SET aula = ?, dia = ?, inicio = ?, final = ? "
            + "WHERE id = ?", 
            (PreparedStatement s) -> {
                s.setInt(1, h.getAula());
                s.setInt(2, h.getDia());
                s.setInt(3, h.getInicio());
                s.setInt(4, h.getFin());
                s.setInt(5, h.getId());
            }
        );
    }

    public void eliminar(final Horario h) throws SQLException {
        ejecutarQueryConParametros(
            "DELETE FROM horario WHERE id = ?",
            (PreparedStatement s) -> {
                s.setInt(1, h.getId());
            }
        );
    }

    public Integer insertar(final Curso c) throws SQLException {
        ejecutarQueryConParametros(
            "INSERT INTO curso (nombre, idHorario, idProfesor) VALUES (?,?,?)",
            (PreparedStatement s) -> {
                s.setString(1, c.getNombre());
                s.setInt(2, c.getIdHorario());
                s.setInt(3, c.getIdProfesor());
            }
        );
        return ultimoIdInsertado();
    }

    public void actualizar(final Curso c) throws SQLException {
        ejecutarQueryConParametros(
            "UPDATE curso SET nombre = ?, idHorario = ?, idProfesor = ? "
            + "WHERE id = ?",
            (PreparedStatement s) -> {
                s.setString(1, c.getNombre());
                s.setInt(2, c.getIdHorario());
                s.setInt(3, c.getIdProfesor());
                s.setInt(4, c.getId());
            }
        );
    }

    public void eliminar(final Curso c) throws SQLException {
        ejecutarQueryConParametros(
            "DELETE FROM curso WHERE id = ?",
            (PreparedStatement s) -> {
                s.setInt(1, c.getId());
            }
        );
    }

    public void crearRelacion(final Carrera carrera, final Curso curso)
        throws SQLException {

        ejecutarQueryConParametros(
            "INSERT INTO carreraTieneCurso (idCarrera, idCurso) VALUES (?,?)",
            (PreparedStatement s) -> {
                s.setInt(1, carrera.getId());
                s.setInt(2, curso.getId());
            }
        );
    }
    
    public void eliminarRelacion(final Carrera carrera, final Curso curso)
        throws SQLException {

        ejecutarQueryConParametros(
            "DELETE FROM carreraTieneCurso WHERE idCarrera = ? AND idCurso = ?",
            (PreparedStatement s) -> {
                s.setInt(1, carrera.getId());
                s.setInt(2, curso.getId());
            }
        );
    }
}
