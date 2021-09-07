package poo.proyecto_final;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EscuelaAcademica {
    // Para indicar que no se ha ingresado a la base de datos
    protected final static Integer noId = -1;

    private Integer id;
    private String nombre;

    /**
     * Lee las escuelas academicas guardadas en la base de datos
     */
    public static ArrayList<EscuelaAcademica> cargarDesde(DB db)
            throws SQLException {

        ArrayList<EscuelaAcademica> escuelas =
            new ArrayList<EscuelaAcademica>();
        ResultSet rs =
            db.ejecutarQuery("SELECT * FROM escuelaAcademica").getResultSet();

        while (!rs.next()) {
            EscuelaAcademica e = new EscuelaAcademica();
            e.id = rs.getInt("id");
            e.nombre = rs.getString("nombre");
            escuelas.add(e);
        }

        return escuelas;
    }

    public static EscuelaAcademica leerDesdeTerminal() {
        EscuelaAcademica e = new EscuelaAcademica();
        System.out.print("Ingrese los datos de la escuela:");

        e.nombre = Input.leerNombre();
        e.id = noId;

        return e;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

}
