import java.util.ArrayList;

public class GestorUsuarios {
    private static GestorUsuarios instancia = null;
    private Integer cuentaId = 0;
    private Usuario usuarioActivo = null;
    private final ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public static GestorUsuarios instanciar() {
        if (instancia == null) {
            instancia = new GestorUsuarios();
        }
        return instancia;
    }

    public Usuario buscaUsuario(final String nombre) {
        for (final Usuario u : usuarios) {
            if (u.getNombre().equals(nombre)) {
                return u;
            }
        }
        return null;
    }

    public Usuario buscaUsuario(final Integer id) {
        for (final Usuario u : usuarios) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    public Usuario crearUsuario() {
        final Usuario u = new Usuario();

        System.out.println("Nombre de usuario:");
        u.setNombre(IO.leerLinea());

        System.out.println("Nombre Completo:");
        u.setNombreCompleto(IO.leerLinea());

        System.out.println("Contraseña:");
        u.setPasswd(IO.leerLinea());

        System.out.println("Correo:");
        u.setCorreo(IO.leerLinea());

        final Integer id = cuentaId;
        u.setId(id);
        cuentaId++;

        usuarios.add(u);
        return u;
    }

    public Usuario getUsuarioActivo() {
        return usuarioActivo;
    }

    public void setUsuarioActivo(final Usuario usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }
}
