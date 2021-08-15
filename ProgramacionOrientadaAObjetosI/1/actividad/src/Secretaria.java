public class Secretaria extends Empleado {
    public Secretaria(Integer DPI,
                      String  nombres,
                      String  apellidos,
                      Integer departamento,
                      String  telefono,
                      String  correo) {

        super(DPI, nombres, apellidos, departamento, telefono, correo);
    }

    public String llevarRegistros() {
        return nombreCompleto() + " esta llevando registros de las visitas";
    }

    public String recordarAlAdministrador(Administrador admin) {
        return nombreCompleto() + " le recordara a " + admin.nombreCompleto()
                                + " que tiene una reunion en 10 minutos";
    }

    public String organizarEvento(String nombre) {
        return nombreCompleto() + " empezara a organizar " + nombre;
    }
}
