public class Empleado {

    private Integer DPI;
    private String  nombres;
    private String  apellidos;
    private Integer departamento;
    private String  telefono;
    private String  correo;

    public Empleado(Integer DPI,
                    String  nombres,
                    String  apellidos,
                    Integer departamento,
                    String  telefono,
                    String  correo) {

        this.DPI = DPI;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.departamento = departamento;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String trabajar() {
        return nombreCompleto() + " esta trabajando";
    }

    public String nombreCompleto() {
        return nombres + " " + apellidos;
    }
}
