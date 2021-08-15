public class Administrador extends Empleado {
    public Administrador(Integer DPI,
                         String  nombres,
                         String  apellidos,
                         Integer departamento,
                         String  telefono,
                         String  correo) {

        super(DPI, nombres, apellidos, departamento, telefono, correo);
    }

    @Override
    public String trabajar() {
        return organizarEmpleados();
    }

    public String planearProyecto(String nombreProyecto) {
        return nombreCompleto() + " se encargara de planear para el proyecto: "
                                + nombreProyecto;
    }

    public String organizarEmpleados() {
        return nombreCompleto() + " vera que todos los empleados realizen lo"
                                + " que les corresponde";
    }

    public String coordinarReuniones() {
        return nombreCompleto() + " va a coordinar las reuniones de esta semana";
    }
}
