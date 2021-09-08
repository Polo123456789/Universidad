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

        while (rs.next()) {
            EscuelaAcademica e = new EscuelaAcademica();
            e.id = rs.getInt("id");
            e.nombre = rs.getString("nombre");
            escuelas.add(e);
        }

        return escuelas;
    }

    public static EscuelaAcademica leerDesdeTerminal() {
        EscuelaAcademica e = new EscuelaAcademica();
        System.out.println("Ingrese los datos de la escuela:");

        e.nombre = Input.leerNombre();
        e.id = noId;

        return e;
    }

    public static void gestionar(DB db) throws SQLException, InterruptedException {
        TermUtil.limpiarPantalla();
        System.out.println(Colors.blue("Gestion de Escuelas Academicas\n"));

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

        EscuelaAcademica e = leerDesdeTerminal();
        db.insertar(e);
        System.out.println(Colors.green("Insertada correctamente"));
        Thread.sleep(1000);

    }

    private static void gestionModificar(DB db)
        throws SQLException, InterruptedException {

        ArrayList<EscuelaAcademica> escuelas = cargarDesde(db);

        if (escuelas.size() == 0) {
            System.out.println(
                Colors.red("\nTiene que crear al menos una escuela "
                           + "antes de poder modificarlas.\n")
            );

            Thread.sleep(1000);
            return;
        }

        enlistarEscuelas(escuelas);

        System.out.print(Colors.blue("Que escuela quiere modificar? "));
        final int aModificar = Input.leerNumero(
            new Input.Rango(1, escuelas.size())
        );

        EscuelaAcademica e = escuelas.get(aModificar - 1);

        System.out.println("Quiere modificar la escuela en si, o sus "
                           + "carreras? (1 para escuela, 2 para carreras)");

        final int seleccion = Input.leerNumero(
                new Input.Rango(1, 2)
        );

        if (seleccion == 1) {
            e.modificarDesdeTermial();
            db.actualizar(e);
            System.out.println(Colors.green("\nModificado exitosamente\n"));
            Thread.sleep(1000);
        } else {
            Carrera.gestionar(db, e);
        }
    }

    private static void gestionEliminar(DB db)
        throws SQLException, InterruptedException {

        ArrayList<EscuelaAcademica> escuelas = cargarDesde(db);

        if (escuelas.size() == 0) {
            System.out.println(
                Colors.red("\nTiene que crear al menos una escuela "
                           + "antes de tratar de eliminarla.\n")
            );
            Thread.sleep(1000);
            return;
        }

        enlistarEscuelas(escuelas);

        
        System.out.print(Colors.blue("Que escuela quiere eliminar?")
                         + " (0 para cancelar) ");
        final int aModificar = Input.leerNumero(
                new Input.Rango(0, escuelas.size())
        );

        if (aModificar == 0) {
            System.out.println(
                Colors.red("\nCancelando...\n")
            );
            Thread.sleep(1000);
            return;
        }

        EscuelaAcademica e = escuelas.get(aModificar - 1);
        // TODO(pabsa) Mostrar los hijos afectados
        db.eliminar(e);
        System.out.println(Colors.green("\nEliminada exitosamente\n"));
        Thread.sleep(1000);
    }

    public static void enlistarEscuelas(ArrayList<EscuelaAcademica> escuelas) {
        for (int i = 0; i < escuelas.size(); i++) {
            System.out.println((i+1) + ") " + escuelas.get(i).getNombre());
        }
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void modificarDesdeTermial() {
        System.out.println("Ingrese los nuevos nombres para los campos."
                           + " Dejelos en blanco si no desea cambiarlos");
        String posibleNombre = Input.leerNombreOVacio();

        if (posibleNombre != null) {
            nombre = posibleNombre;
        }
    }

}
