package poo.proyecto_final;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Carrera {
    // Para indicar que no se ha ingresado a la base de datos
    protected final static Integer noId = -1;

    private Integer id;
    private String nombre;
    private Integer idDecano;
    private Integer idEscuela;

    public static ArrayList<Carrera> cargarDesde(DB                     db,
                                                 final EscuelaAcademica e)
        throws SQLException {

        String query = "SELECT * FROM carrera";

        if (e != null) {
            query += " WHERE idEscuela = " + e.getId();
        }

        ArrayList<Carrera> carreras = new ArrayList<Carrera>();
        ResultSet rs = db.ejecutarQuery(query).getResultSet();

        while (rs.next()) {
            Carrera c = new Carrera();
            c.id = rs.getInt("id");
            c.nombre = rs.getString("nombre");
            c.idDecano = rs.getInt("idDecano");
            c.idEscuela = rs.getInt("idEscuela");
            carreras.add(c);
        }
        return carreras;
    }

    public static Carrera leerDesdeTerminal(final EscuelaAcademica  e,
                                            final ArrayList<Decano> decanos) {
        Carrera c = new Carrera();

        System.out.println("Ingrese los datos de la carrera:");

        c.nombre = Input.leerNombre();

        System.out.println("Los decanos que se pueden encargar de esta "
                           + "carrera son:");
        Decano.enlistarDecanos(decanos);

        System.out.print("A cual de ellos se la quiere asignar? ");
        final int seleccionado = Input.leerNumero(
            new Input.Rango(1, decanos.size() + 1)
        );

        final Decano decano = decanos.get(seleccionado - 1);

        c.idDecano = decano.getId();
        c.idEscuela = e.getId();
        return c;
    }

    public static void enlistarCarreras(ArrayList<Carrera> carreras) {
        for (int i = 0; i < carreras.size(); i++) {
            System.out.println((i + 1) + ") " + carreras.get(i).nombre);
        }
    }

    public static void gestionar(DB db, EscuelaAcademica e) 
        throws SQLException, InterruptedException {

        TermUtil.limpiarPantalla();
        System.out.println(
            Colors.blue("Gestion de carreras de \"" + e.getNombre() + "\"")
        );

        TermUtil.imprimirOpcionesGestion();
        System.out.print(Colors.blue("Opcion: "));
        final int opcion = Input.leerNumero(
                new Input.Rango(1, TermUtil.opcionesDeGestion.length + 1)
        );

        switch (opcion) {
            case 1: 
                gestionAgregar(db, e);
                break;

            case 2: 
                gestionModificar(db, e);
                break;

            case 3:
                gestionEliminar(db, e);
                break;

            case 4:
                // Salir
                return;
        }
    }

    private static void gestionAgregar(DB db, final EscuelaAcademica e) 
        throws SQLException, InterruptedException {

        ArrayList<Decano> disponibles = Decano.decanosSinCarrera(db);
        if (disponibles.size() == 0) {
            System.out.println(
                Colors.red("\nTiene que tener al menos un decano disponible para "
                           + "gestionar la carrera antes de crearla.\n")
            );
            Thread.sleep(1000);
            return;
        }

        Carrera c = leerDesdeTerminal(e, disponibles);
        db.insertar(c);
        System.out.println(Colors.green("Insertado correctamente"));
        Thread.sleep(1000);
    }

    private static void gestionModificar(DB db, final EscuelaAcademica e) 
        throws SQLException, InterruptedException {

        ArrayList<Carrera> carreras = cargarDesde(db, e);

        if (carreras.size() == 0) {
            System.out.println(
                Colors.red("\nTiene que crear al menos una carrera "
                           + "antes de poder modificarlas.\n")
            );
            Thread.sleep(1000);
            return;
        }

        enlistarCarreras(carreras);

        System.out.print(Colors.blue("Que carrera quiere modificar? "));
        final int aModificar = Input.leerNumero(
            new Input.Rango(1, carreras.size())
        );

        System.out.println("Quiere modificar la carrera, o sus cursos? "
                           + "(1: Carrera, 2: Cursos)");

        
        final int seleccion = Input.leerNumero(
                new Input.Rango(1, 2)
        );
        Carrera c = carreras.get(aModificar - 1);

        if (seleccion == 1) {
            c.modificarDesdeTerminal(db);
            db.actualizar(c);
            System.out.println(Colors.green("\nModificado exitosamente\n"));
            Thread.sleep(1000);
        } else {
            Curso.gestionar(db, c);
        }
    }

    private static void gestionEliminar(DB db, final EscuelaAcademica e)
        throws SQLException, InterruptedException {

        ArrayList<Carrera> carreras = cargarDesde(db, e);

        if (carreras.size() == 0) {
            System.out.println(
                Colors.red("\nTiene que crear al menos una carrera "
                           + "antes de poder eliminarlas.\n")
            );
            Thread.sleep(1000);
            return;
        }

        enlistarCarreras(carreras);

        System.out.print(Colors.blue("Que carrera quiere eliminar? "));
        final int aModificar = Input.leerNumero(
            new Input.Rango(1, carreras.size())
        );

        if (aModificar == 0) {
            System.out.println(
                Colors.red("\nCancelando ...\n")
            );
            Thread.sleep(1000);
            return;
        }

        Carrera c = carreras.get(aModificar - 1);

        c.eliminarHijosAfectados(db);
        db.eliminar(c);

        System.out.println(Colors.green("\nElimininado exitosamente\n"));
        Thread.sleep(5000);
    }

    public void modificarDesdeTerminal(DB db) 
        throws SQLException, InterruptedException {
        System.out.println("Ingrese los datos nombres para los campos."
                           + "Deje en blanco los campos de texto, o coloque "
                           + "un 0 en los numericos si no desea cambiarlos");

        String posibleNombre = Input.leerNombreOVacio();
        if (posibleNombre != null) {
            nombre = posibleNombre;
        }

        ArrayList<Decano> disponibles = Decano.decanosSinCarrera(db);
        if (disponibles.size() == 0) {
            System.out.println(
                Colors.red("\nNo hay decanos disponiblesa asi que esta "
                           + "carrera conservara el suyo\n")
            );
        } else {
            System.out.println("Los decanos que se pueden encargar de esta "
                               + "carrera son:");
            Decano.enlistarDecanos(disponibles);

            System.out.print("A cual de ellos se la quiere asignar? ");
            final int seleccionado = Input.leerNumero(
                    new Input.Rango(0, disponibles.size() + 1)
                    );

            if (seleccionado != 0) {
                final Decano decano = disponibles.get(seleccionado - 1);
                idDecano = decano.getId();
            }
        }
    }

    public void eliminarHijosAfectados(DB db) throws SQLException {
        ArrayList<Curso> cursos = Curso.cargarDesde(db, this, false);
        ArrayList<Curso> cursosABorrar = new ArrayList<Curso>();

        for (Curso c : cursos) {
            if (c.cantidadDeCarrerasEnLasQueEsta(db) == 1) {
                cursosABorrar.add(c);
            }
        }

        System.out.println("Al eliminar la carrera " + getNombre()
                           + ", se eliminan los cursos:");
        for (Curso c : cursosABorrar) {
            System.out.println("* " + c.getNombre());
        }

        // 1. Eliminamos las relaciones con la carrera
        for (Curso c : cursos) {
            db.eliminarRelacion(this, c);
        }
        
        // 2. Eliminamos los horarios de los respectivos cursos necesarios
        // 3. Eliminamos los cursos necesarios
        for (Curso c : cursosABorrar) {
            Horario h = Horario.porId(db, c.getIdHorario());
            db.eliminar(c);
            db.eliminar(h);
        }

        // TODO los directores se quedan sin carreras

        // TODO el decano se queda sin carrera
        System.out.println("Al eliminar la carrera " + getNombre()
                           + ", el :");
    }


    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getIdDecano() {
        return idDecano;
    }

    public Integer getIdEscuela() {
        return idEscuela;
    }
}
