package poo.proyecto_final;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Curso {
    // Para indicar que no se ha ingresado a la base de datos
    protected final static Integer noId = -1;

    private Integer id;
    private String nombre;
    private Integer idHorario;
    private Integer idProfesor;

    /**
     * @param db La base de datos.
     * @param c De ser nula se retornaran todos los cursos, de lo contrario lo
     *          que se retorne dependera de `todosMenosDeCarreera`.
     * @param todosMenosDeCarreera De ser verdadero, buscara todos los cursos
     *                             que no formen parte de la carrera dada. De
     *                             ser falso retornara todos los cursos
     *                             relacionados con esa carrera
     */
    public static ArrayList<Curso> cargarDesde(DB            db,
                                               final Carrera c,
                                               Boolean       todosMenosDeCarreera)
        throws SQLException {

        String query = "SELECT * FROM curso";

        if (c != null) {
            if (todosMenosDeCarreera) {
                query += " WHERE id NOT IN "
                         + "(SELECT idCurso FROM carreraTieneCurso "
                         + "WHERE idCarrera = " + c.getId() + ")";
            } else {
                query += " WHERE id IN "
                         + "(SELECT idCurso FROM carreraTieneCurso "
                         + "WHERE idCarrera = " + c.getId() + ")";
            }
        }

        ArrayList<Curso> cursos = new ArrayList<Curso>();
        ResultSet rs = db.ejecutarQuery(query).getResultSet();

        while (rs.next()) {
            Curso curso = new Curso();
            curso.id = rs.getInt("id");
            curso.nombre = rs.getString("nombre");
            curso.idHorario = rs.getInt("idHorario");
            curso.idProfesor = rs.getInt("idProfesor");
            cursos.add(curso);
        }
        return cursos;
    }

    public static void enlistarCursos(ArrayList<Curso> cursos) {
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + ") " + cursos.get(i).nombre);
        }
    }

    public static Curso leerDesdeTerminal(DB db) 
        throws SQLException, InterruptedException {

        Curso curso = new Curso();
        ArrayList<Profesor> profesores = Profesor.cargarDesde(db);
        if (profesores.size() == 0) {
            System.out.println(
                Colors.red("\nTiene que crear al menos un profesor "
                           + "que pueda impartir el curso antes de crearlo.\n")
            );
            Thread.sleep(1000);
            return null;
        }

        curso.nombre = Input.leerNombre();

        System.out.println("Los profesores que pueden dar el curso son:");
        Profesor.enlistarProfesores(profesores);
        System.out.print("Profesor: ");
        final int profesorSeleccionado = Input.leerNumero(
            new Input.Rango(1, profesores.size())
        );
        curso.idProfesor = profesores.get(profesorSeleccionado - 1).getId();

        System.out.println("Ahora tiene que crear un horario para el curso:");
        Horario horario = Horario.leerDesdeTerminal(db);
        curso.idHorario = db.insertar(horario);

        curso.id = noId;

        return curso;
    }

    public void modificarDesdeTermial(DB db) throws SQLException {
        ArrayList<Profesor> profesores = Profesor.cargarDesde(db);

        System.out.println("Ingrese los nuevos valores para los campos, o "
                           + "dejelos en blanco para conservar el valor que "
                           + "ya tienen");

        String posibleNombre = Input.leerNombreOVacio();
        if (posibleNombre != null) {
            nombre = posibleNombre;
        }

        System.out.println("Los profesores que pueden dar el curso son:");
        Profesor.enlistarProfesores(profesores);
        System.out.print("Profesor (o 0 para dejar el profesor que ya"
                         + " la imparte): ");
        final int profesorSeleccionado = Input.leerNumero(
            new Input.Rango(0, profesores.size())
        );
        if (profesorSeleccionado != 0) {
            idProfesor = profesores.get(profesorSeleccionado - 1).getId();
        }

        Horario horario = Horario.porId(db, idHorario);
        horario.modificarDesdeTerminal();
        db.actualizar(horario);
    }

    public static void gestionar(DB db, Carrera c)
        throws SQLException, InterruptedException {

        TermUtil.limpiarPantalla();
        System.out.println(
            Colors.blue("Gestion de cursos de \"" + c.getNombre() + "\"")
        );

        TermUtil.imprimirOpcionesGestion();
        System.out.print(Colors.blue("Opcion: "));
        final int opcion = Input.leerNumero(
                new Input.Rango(1, TermUtil.opcionesDeGestion.length + 1)
        );

        switch (opcion) {
            case 1: 
                gestionAgregar(db, c);
                break;

            case 2: 
                gestionModificar(db, c);
                break;

            case 3:
                gestionEliminar(db, c);
                break;

            case 4:
                // Salir
                return;
        }
    }

    private static void gestionAgregar(DB db, final Carrera c) 
        throws SQLException, InterruptedException {

        System.out.println("1 para crear un nuevo curso, o 2 para añadir un "
                           + "curso existente:");

        final Integer opcion = Input.leerNumero(
            new Input.Rango(1, 2)
        );


        if (opcion == 1) {
            Curso curso = leerDesdeTerminal(db);
            if (curso == null) {
                // El error ya se imprimio en `leerDesdeTerminal`
                return;
            }
            curso.id = db.insertar(curso);
            db.crearRelacion(c, curso);
            System.out.println(Colors.green("Insertado correctamente"));
            Thread.sleep(1000);
            return;
        }
        
        ArrayList<Curso> cursosDisponibles = cargarDesde(db, c, true);
        if (cursosDisponibles.size() == 0) {
            System.out.println(
                Colors.red(
                    "\nNo hay cursos disponibles que no esten asignados ya a "
                    + "esta carrera.\n"
                )
            );
            Thread.sleep(1000);
            return;
        }
        System.out.println("Los cursos que no estan asignados a esta carrera "
                           + "son:");
        Curso.enlistarCursos(cursosDisponibles);
        final Integer seleccionado = Input.leerNumero(
            new Input.Rango(1, cursosDisponibles.size())
        );
        Curso curso = cursosDisponibles.get(seleccionado - 1);

        db.crearRelacion(c, curso);
        System.out.println(Colors.green("Insertado correctamente"));
        Thread.sleep(1000);
    }

    private static void gestionModificar(DB db, final Carrera c)
        throws SQLException, InterruptedException {

        ArrayList<Curso> cursos = cargarDesde(db, c, false);

        if (cursos.size() == 0) {
            System.out.println(
                Colors.red(
                    "\nNo hay cursos disponibles que esten asignados a "
                    + "esta carrera.\n"
                )
            );
            Thread.sleep(1000);
            return;
        }

        enlistarCursos(cursos);

        System.out.print(Colors.blue("Que curso quiere modificar? "));
        final int aModificar = Input.leerNumero(
            new Input.Rango(1, cursos.size())
        );

        Curso curso = cursos.get(aModificar - 1);
        c.modificarDesdeTerminal(db);
        db.actualizar(curso);
        System.out.println(Colors.green("\nModificado exitosamente\n"));
        Thread.sleep(1000);
    }

    private static void gestionEliminar(DB db, final Carrera c)
        throws SQLException, InterruptedException {

        ArrayList<Curso> cursos = cargarDesde(db, c, false);

        if (cursos.size() == 0) {
            System.out.println(
                Colors.red(
                    "\nNo hay cursos disponibles que esten asignados a "
                    + "esta carrera.\n"
                )
            );
            Thread.sleep(1000);
            return;
        }

        enlistarCursos(cursos);

        System.out.print(Colors.blue("Que curso quiere modificar? "));
        final int aModificar = Input.leerNumero(
            new Input.Rango(1, cursos.size())
        );

        Curso curso = cursos.get(aModificar - 1);

        if (curso.cantidadDeCarrerasEnLasQueEsta(db) == 1) {
            // Solo esta en esta carrera, lo podemos borrar
            Horario horario = Horario.porId(db, curso.getIdHorario());

            db.eliminar(horario);
            db.eliminarRelacion(c, curso);
            db.eliminar(curso);
        } else {
            // Otras carreras tambien lo tienen, solo borramos la relacion
            db.eliminarRelacion(c, curso);
        }
        System.out.println(Colors.green("\nElimininado exitosamente\n"));
        Thread.sleep(1000);
    }

    public Integer cantidadDeCarrerasEnLasQueEsta(DB db) throws SQLException {
        ResultSet rs = db.ejecutarQuery("SELECT COUNT(*) FROM carreraTieneCurso"
                                + " WHERE idCurso = " + id).getResultSet();
        rs.next();

        return rs.getInt(1);
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }
}
