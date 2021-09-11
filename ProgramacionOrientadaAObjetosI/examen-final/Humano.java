public abstract class Humano {
    private String nombre;
    private String apellidos;

    public Humano(final String nombre, final String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    protected Humano setNombre(final String nombre) {
        this.nombre = nombre;
        return this;
    }

    protected Humano setApellido(final String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    @Override
    public String toString() {
        return getNombre() + " " + getApellidos();
    }
}
