package poo.proyecto_final;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Director {
    protected final static Integer noId = -1;
    protected final static Integer sinCarrera = 0;

    private Integer id;
    private String nombre;
    private String apellidos;
    private Integer idCarrera;

    public static ArrayList<Director> cargarDesde(DB db) throws SQLException {
        ArrayList<Director> directores = new ArrayList<Director>();
        ResultSet rs =
            db.ejecutarQuery("SELECT * FROM director").getResultSet();

        while (rs.next()) {
            Director d = new Director();

            d.id = rs.getInt("id");
            d.nombre = rs.getString("nombre");
            d.apellidos = rs.getString("apellidos");
            d.idCarrera = rs.getInt("idCarrera");

            directores.add(d);
        }
        return directores;
    }

    public static void enlistarDirectores(ArrayList<Director> directores) {
        for (int i = 0; i < directores.size(); i++) {
            System.out.println((i + 1) + ") " + directores.get(i).nombre + " "
                                       + directores.get(i).apellidos);
        }
    }

    public static Director leerDesdeTerminal(DB db) throws SQLException {
        Director d = new Director();

        d.nombre = Input.leerNombre();
        d.apellidos = Input.leerApellido();

        ArrayList<Carrera> carreras = Carrera.cargarDesde(db, null);

        if (carreras.size() != 0) {
            System.out.println("Las carreras que puede administrar son:");
            Carrera.enlistarCarreras(carreras);

            System.out.print("Ingrese el numero de la carrera, o 0 para no"
                             + " administrar ninguna de momento: ");

            final int elegida = Input.leerNumero(
                new Input.Rango(0, carreras.size())
            );

            if (elegida == sinCarrera) {
                d.idCarrera = sinCarrera;
            } else {
                d.idCarrera = carreras.get(elegida - 1).getId();
            }
        } else {
            System.out.println("De momento no hay carreras que puedan "
                               + "asignarse al director.\n"
                               + "Cree una escuela, en ella carreras, y luego"
                               + " regrese\n"
                               + "Mientras tanto el director existira sin una"
                               + " carrera que administar.");
            d.idCarrera = sinCarrera;
        }

        return d;
    }

    public static void gestionar(DB db)
        throws SQLException, InterruptedException {

        TermUtil.limpiarPantalla();
        System.out.println(Colors.blue("Gestion de Directores\n"));

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

        Director d = leerDesdeTerminal(db);
        db.insertar(d);
        System.out.println(Colors.green("Insertado correctamente"));
        Thread.sleep(1000);
    }

    private static void gestionModificar(DB db) 
        throws SQLException, InterruptedException {

        ArrayList<Director> directores = cargarDesde(db);

        if (directores.size() == 0) {
            System.out.println(
                Colors.red("\nTiene que crear al menos un director "
                           + "antes de poder modificarlos.\n")
            );

            Thread.sleep(1000);
            return;
        }

        enlistarDirectores(directores);

        System.out.print(Colors.blue("Que director quiere modificar? "));
        final int aModificar = Input.leerNumero(
            new Input.Rango(1, directores.size())
        );

        Director d = directores.get(aModificar - 1);

        d.modificarDesdeTermial(db);
        db.actualizar(d);
        System.out.println(Colors.green("\nModificado exitosamente\n"));
        Thread.sleep(1000);
    }

    private static void gestionEliminar(DB db)
        throws SQLException, InterruptedException {

        ArrayList<Director> directores = cargarDesde(db);

        if (directores.size() == 0) {
            System.out.println(
                Colors.red("\nTiene que crear al menos un director "
                           + "antes de poder modificarlos.\n")
            );

            Thread.sleep(1000);
            return;
        }

        System.out.print(Colors.blue("Que director quiere eliminar?")
                         + " (0 para cancelar)");
        final int aModificar = Input.leerNumero(
            new Input.Rango(0, directores.size())
        );

        if (aModificar == 0) {
            System.out.println(
                Colors.red("\nCancelando ...\n")
            );
            Thread.sleep(1000);
            return;
        }

        Director d = directores.get(aModificar - 1);

        db.eliminar(d);
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
    
    public Integer getIdCarrera() {
        return idCarrera;
    }

    public void modificarDesdeTermial(DB db) throws SQLException {
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

        ArrayList<Carrera> carreras = Carrera.cargarDesde(db, null);

        if (carreras.size() != 0) {
            System.out.println("Las carreras que puede administrar son:");
            Carrera.enlistarCarreras(carreras);

            System.out.print("Ingrese el numero de la carrera, o 0 para no"
                             + " administrar ninguna de momento, o -1 si no"
                             + " decea cambiar la carrera: ");

            final int elegida = Input.leerNumero(
                new Input.Rango(-1, carreras.size())
            );
            if (elegida == -1) {
                // No hacer nada
            } else if (elegida == sinCarrera) {
                idCarrera = sinCarrera;
            } else {
                idCarrera = carreras.get(elegida - 1).getId();
            }
        } else {
            System.out.println("De momento no hay carreras que puedan "
                               + "asignarse al director.\n"
                               + "Cree una escuela, en ella carreras, y luego"
                               + " regrese\n"
                               + "Mientras tanto el director seguira sin una"
                               + " carrera que administar.");
            idCarrera = sinCarrera;
        }
    }

}
