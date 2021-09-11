public class Tratamiento {
    private final String nombre;
    private final Integer costo;

    public static final Integer costoMinimo = 100;
    public static final Integer costoMaximo = 15000;


    public Tratamiento(String nombre, Integer costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
