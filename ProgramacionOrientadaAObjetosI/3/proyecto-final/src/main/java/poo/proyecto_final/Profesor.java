package poo.proyecto_final;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Profesor {
    protected final static Integer noId = -1;

    private Integer id;
    private String nombre;
    private String apellidos;

    public static ArrayList<Profesor> cargarDesde(DB db)
        throws SQLException {
        ArrayList<Profesor> profesores =
            new ArrayList<Profesor>();
        ResultSet rs = 
            db.ejecutarQuery("SELECT * FROM profesor").getResultSet();

        while (rs.next()) {
            Profesor p = new Profesor();
            p.id = rs.getInt("id");
            p.nombre = rs.getString("nombre");
            p.apellidos = rs.getString("apellidos");
            profesores.add(p);
        }

        return profesores;
    }

    public static Profesor leerDesdeTerminal() {
        Profesor p = new Profesor();
        System.out.println("Ingrese los datos del profesor");

        p.nombre = Input.leerNombre();
        p.apellidos = Input.leerApellido();
        p.id = noId;

        return p;
    }

    public static void enlistarProfesores(ArrayList<Profesor> profesores) {
        for (int i = 0; i < profesores.size(); i++) {
            System.out.println((i + 1) + ") " + profesores.get(i).nombre + " "
                                       + profesores.get(i).apellidos);
        }
    }

    public static void gestionar(DB db)
        throws SQLException, InterruptedException {

        TermUtil.limpiarPantalla();
        System.out.println(Colors.blue("Gestion de Profesores\n"));

        TermUtil.imprimirOpcionesGestion();
        System.out.print(Colors.blue("Opcion: "));
        final int opcion = Input.leerNumero(
                new Input.Rango(1, TermUtil.opcionesDeGestion.length + 1)
        );

        switch (opcion) {
            case 1: 
                gestionAgregar(db);
                break;

            case 2: 
                gestionModificar(db);
                break;

            case 3:
                gestionEliminar(db);
                break;

            case 4:
                // Salir
                return;
        }
    }

    private static void gestionAgregar(DB db)
        throws SQLException, InterruptedException {

        Profesor p = leerDesdeTerminal();
        db.insertar(p);
        System.out.println(Colors.green("Insertado correctamente"));
        Thread.sleep(1000);
    }

    private static void gestionModificar(DB db)
        throws SQLException, InterruptedException {

        ArrayList<Profesor> profesores = cargarDesde(db);

        if (profesores.size() == 0) {
            System.out.println(
                Colors.red("\nTiene que crear al menos un profesor "
                           + "antes de poder modificarlos.\n")
            );

            Thread.sleep(1000);
            return;
        }

        enlistarProfesores(profesores);

        System.out.print(Colors.blue("Que profesor quiere modificar? "));
        final int aModificar = Input.leerNumero(
            new Input.Rango(1, profesores.size() + 1)
        );

        Profesor p = profesores.get(aModificar - 1);

        p.modificarDesdeTermial();
        db.actualizar(p);
        System.out.println(Colors.green("\nModificado exitosamente\n"));
        Thread.sleep(1000);
    }

    private static void gestionEliminar(DB db)
        throws SQLException, InterruptedException {

        ArrayList<Profesor> profesores = cargarDesde(db);

        if (profesores.size() == 0) {
            System.out.println(
                Colors.red("\nTiene que crear al menos un profesor "
                           + "antes de poder eliminarlos.\n")
            );

            Thread.sleep(1000);
            return;
        }

        enlistarProfesores(profesores);

        System.out.print(Colors.blue("Que profesor quiere eliminar?")
                        + " (0 para cancelar) ");
        final int aModificar = Input.leerNumero(
            new Input.Rango(0, profesores.size() + 1)
        );

        if (aModificar == 0) {
            System.out.println(
                Colors.red("\nCancelando ...\n")
            );
            Thread.sleep(1000);
            return;
        }

        Profesor p = profesores.get(aModificar - 1);

        db.eliminar(p);
        System.out.println(Colors.green("\nElimininado exitosamente\n"));
        Thread.sleep(1000);
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    @Override public String toString() {
        return "Profesor: {\n\tid: " + getId() + ",\n\tnombre: " + getNombre()
               + ",\n\tapellidos: " + getApellidos() + "\n}";
    }

    public void modificarDesdeTermial() {
        System.out.println("Ingrese los nuevos nombres para los campos."
                           + " Dejelos en blanco si no desea cambiarlos");

        String posibleNombre = Input.leerNombreOVacio();
        if (posibleNombre != null) {
            nombre = posibleNombre;
        }

        String possiblesApellidos = Input.leerApellidoOVacio();
        if (possiblesApellidos != null) {
            apellidos = possiblesApellidos;
        }
        
    }

}
