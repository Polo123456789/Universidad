import java.util.ArrayList;

public class GestorEventos {
    private static GestorEventos instancia = null;
    private Integer cuentaId = 0;
    private ArrayList<Evento> eventos = new ArrayList<Evento>();

    public static GestorEventos instanciar() {
        if (instancia == null) {
            instancia = new GestorEventos();
        }
        return instancia;
    }

    public Evento getEvento(Integer id) {
        for (Evento e : eventos) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    public void crearEvento() {
        Evento e = new Evento();

        System.out.println("Nombre:");
        e.setNombre(IO.leerLinea());

        System.out.println("Descripcion:");
        e.setDescripcion(IO.leerLinea());

        System.out.println("Fecha:");
        e.setFecha(IO.leerLinea());

        Usuario actual = GestorUsuarios.instanciar().getUsuarioActivo();
        e.setIdUsuario(actual.getId());

        Integer id = cuentaId;
        cuentaId++;
        e.setId(id);

        eventos.add(e);
    }

    public void listarEventos() {
        Integer idUsuario = GestorUsuarios
                                .instanciar()
                                .getUsuarioActivo()
                                .getId();

        for (Evento e : eventos) {
            if (e.getIdUsuario().equals(idUsuario)) {
                System.out.println("ID: '" + e.getId()
                                   + "', Nombre: '" + e.getNombre()
                                   + "', Fecha: '" + e.getFecha() + "'");
            }
        }
    }

    public void eliminarEvento() {
        Integer idUsuario = GestorUsuarios
                                .instanciar()
                                .getUsuarioActivo()
                                .getId();

        System.out.println("Eventos:");
        listarEventos();
        System.out.println("Ingrese el 'ID' del evento que quiera eliminar:");
        Integer idEvento = Integer.parseInt(IO.leerLinea());
        Evento e = getEvento(idEvento);

        if (e == null) {
            System.out.println("Tiene que elegir un 'ID' valido");
            return;
        }

        if (!e.getIdUsuario().equals(idUsuario)) {
            System.out.println("No puede eliminar un evento que no sea suyo");
            return;
        }

        System.out.println("Esta es una accion irreversible."
                           + " Escriba 'confirmar' en minusculas y sin espacios"
                           + " para confirmar la eliminacion.");
        String confirmacion = IO.leerLinea();
        if (confirmacion.equals("confirmar")) {
            eventos.remove(e);
            System.out.println("Registro eliminado.");
        } else {
            System.out.println("Cancelando eliminacion");
        }
    }

    public void editarEvento() {
        Integer idUsuario = GestorUsuarios
                                .instanciar()
                                .getUsuarioActivo()
                                .getId();

        System.out.println("Eventos:");
        listarEventos();
        System.out.println("Ingrese el 'ID' del evento que quiera modificar:");
        Integer idEvento = Integer.parseInt(IO.leerLinea());
        Evento e = getEvento(idEvento);

        if (e == null) {
            System.out.println("Tiene que elegir un 'ID' valido");
            return;
        }

        if (!e.getIdUsuario().equals(idUsuario)) {
            System.out.println("No puede modificar un evento que no sea suyo");
            return;
        }

        String tmp = "";
        System.out.println("Deje en blanco los campos que no quiera modificar.");

        System.out.println("Nombre ('" + e.getNombre() + "')");
        System.out.print("Valor: ");
        tmp = IO.leerLinea();
        if (!tmp.isBlank()) {
            e.setNombre(tmp);
        }

        System.out.println("Descripcion ('" + e.getDescripcion() + "')");
        System.out.print("Valor: ");
        tmp = IO.leerLinea();
        if (!tmp.isBlank()) {
            e.setDescripcion(tmp);
        }

        System.out.println("Fecha ('" + e.getFecha() + "')");
        System.out.print("Valor: ");
        tmp = IO.leerLinea();
        if (!tmp.isBlank()) {
            e.setFecha(tmp);
        }
    }

}
