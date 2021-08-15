public class Contador extends Empleado {
    public Contador(Integer DPI,
                    String  nombres,
                    String  apellidos,
                    Integer departamento,
                    String  telefono,
                    String  correo) {

        super(DPI, nombres, apellidos, departamento, telefono, correo);
    }

    public String revisarLibrosContables() {
        return nombreCompleto() + " esta revisando los libros de la empresa";
    }

    public String crearInformes() {
        return nombreCompleto() + " esta creando un informe de los gastos";
    }

    public String analizarGanancias() {
        return nombreCompleto() + " esta haciendo cuentas de las ganancias";
    }
}
