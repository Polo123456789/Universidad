package poo.proyecto_final;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Decano {
    protected final static Integer noId = -1;

    private Integer id;
    private String nombre;
    private String apellidos;


    public static ArrayList<Decano> cargarDesde(DB db)
        throws SQLException {
        ArrayList<Decano> decanos =
            new ArrayList<Decano>();
        ResultSet rs = 
            db.ejecutarQuery("SELECT * FROM decano").getResultSet();

        while (rs.next()) {
            Decano d = new Decano();
            d.id = rs.getInt("id");
            d.nombre = rs.getString("nombre");
            d.apellidos = rs.getString("apellidos");
            decanos.add(d);
        }

        return decanos;
    }

    public static Decano porId(DB db, Integer id) throws SQLException {
        Decano d = new Decano();

        // TODO implementar

        return d;
    }
    
    public static Decano leerDesdeTerminal() {
        Decano d = new Decano();
        System.out.println("Ingrese los datos del decano");

        d.nombre = Input.leerNombre();
        d.apellidos = Input.leerApellido();
        d.id = noId;

        return d;
    }

    public static void enlistarDecanos(ArrayList<Decano> decanos) {
        for (int i = 0; i < decanos.size(); i++) {
            System.out.println((i + 1) + ") " + decanos.get(i).nombre + " "
                                       + decanos.get(i).apellidos);
        }
    }

    public static void gestionar(DB db)
        throws SQLException, InterruptedException {

        TermUtil.limpiarPantalla();
        System.out.println(Colors.blue("Gestion de Decanos\n"));

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

        Decano d = leerDesdeTerminal();
        db.insertar(d);
        System.out.println(Colors.green("Insertado correctamente"));
        Thread.sleep(1000);
    }

    private static void gestionModificar(DB db)
        throws SQLException, InterruptedException {

        ArrayList<Decano> decanos = cargarDesde(db);

        if (decanos.size() == 0) {
            System.out.println(
                Colors.red("\nTiene que crear al menos un decano "
                           + "antes de poder modificarlos.\n")
            );
            Thread.sleep(1000);
            return;
        }

        enlistarDecanos(decanos);

        System.out.print(Colors.blue("Que decano quiere modificar? "));
        final int aModificar = Input.leerNumero(
            new Input.Rango(1, decanos.size())
        );

        Decano d = decanos.get(aModificar - 1);

        d.modificarDesdeTermial();
        db.actualizar(d);

        System.out.println(Colors.green("\nModificado exitosamente\n"));
        Thread.sleep(1000);
    }

    private static void gestionEliminar(DB db)
        throws SQLException, InterruptedException {

        ArrayList<Decano> decanos = cargarDesde(db);

        if (decanos.size() == 0) {
            System.out.println(
                Colors.red("\nTiene que crear al menos un decano "
                           + "antes de poder eliminarlos.\n")
            );

            Thread.sleep(1000);
            return;
        }

        enlistarDecanos(decanos);

        System.out.print(Colors.blue("Que decano quiere eliminar?")
                         + " (0 para cancelar) ");
        final int aModificar = Input.leerNumero(
            new Input.Rango(0, decanos.size())
        );

        if (aModificar == 0) {
            System.out.println(
                Colors.red("\nCancelando ...\n")
            );
            Thread.sleep(1000);
            return;
        }

        Decano p = decanos.get(aModificar - 1);

        if (p.tieneAsigandaCarrera(db)) {
            System.out.println(
                Colors.red("\nEste decano esta a cargo de una carrera, tiene "
                           + "que asignar otro decano a esta carrera si quiere"
                           + " eliminarlo.\n")
            );
            Thread.sleep(1000);
            return;
        }

        db.eliminar(p);

        System.out.println(Colors.green("\nElimininado exitosamente\n"));
        Thread.sleep(1000);
    }

    public static ArrayList<Decano> decanosSinCarrera(DB db)
        throws SQLException {

        String query =
            "SELECT * FROM decano WHERE id NOT IN (SELECT idDecano FROM carrera)";

        ArrayList<Decano> decanos =
            new ArrayList<Decano>();
        ResultSet rs = 
            db.ejecutarQuery(query).getResultSet();

        while (rs.next()) {
            Decano d = new Decano();
            d.id = rs.getInt("id");
            d.nombre = rs.getString("nombre");
            d.apellidos = rs.getString("apellidos");
            decanos.add(d);
        }

        return decanos;
    }
     
    public boolean tieneAsigandaCarrera(DB db) throws SQLException {
        int cuenta = db.ejecutarQuery(
            "SELECT COUNT(*) FROM carrera WHERE idDecano = " + id
        ).getUpdateCount();

        return cuenta != 0;
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
