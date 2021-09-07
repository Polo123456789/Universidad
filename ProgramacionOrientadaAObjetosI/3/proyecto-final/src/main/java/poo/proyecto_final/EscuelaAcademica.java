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
            // Agregar
            case 1: {
                EscuelaAcademica e = leerDesdeTerminal();
                db.insertar(e);
                System.out.println(Colors.green("Insertada correctamente"));
                Thread.sleep(1000);
                break;
            }

            // Modificar
            case 2: {
                ArrayList<EscuelaAcademica> escuelas = cargarDesde(db);
                enlistarEscuelas(escuelas);

                
                System.out.print(Colors.blue("Que escuela quiere modificar? "));
                final int aModificar = Input.leerNumero(
                        new Input.Rango(1, escuelas.size() + 1)
                );

                EscuelaAcademica e = escuelas.get(aModificar - 1);
                e.modificarDesdeTermial();
                db.actualizar(e);
                System.out.println(Colors.green("\nModificado exitosamente\n"));
                Thread.sleep(1000);
                break;
            }
                

            // Eliminar
            case 3:
                ArrayList<EscuelaAcademica> escuelas = cargarDesde(db);
                enlistarEscuelas(escuelas);

                
                System.out.print(Colors.blue("Que escuela quiere eliminar?")
                                 + " (0 para cancelar) ");
                final int aModificar = Input.leerNumero(
                        new Input.Rango(0, escuelas.size() + 1)
                );

                if (aModificar == 0) {
                    System.out.println(
                        Colors.red("\nCancelando...\n")
                    );
                    Thread.sleep(1000);
                    return;
                }

                EscuelaAcademica e = escuelas.get(aModificar - 1);
                db.eliminar(e);
                System.out.println(Colors.green("\nEliminada exitosamente\n"));
                Thread.sleep(1000);
                break;

            // Salir
            case 4:
                return;
        }
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

    @Override
    public String toString() {
        return "Escuela academica: {\n\tid: " + getId()
                +",\n\tnombre: \"" + getNombre() + "\"\n}";
    }

    public void modificarDesdeTermial() {
        nombre = Input.leerNombre();
    }

}
