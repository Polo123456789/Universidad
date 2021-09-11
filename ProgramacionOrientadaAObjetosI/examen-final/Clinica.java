import java.util.ArrayList;

public class Clinica {
    private String nombre;
    private String direccion;
    private Dentista dentista;
    private ArrayList<Asistente> asistentes = new ArrayList<Asistente>();
    private ArrayList<Tratamiento> tratamientos = new ArrayList<Tratamiento>();

    public Clinica(String nombre, String direccion, Dentista dentista) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.dentista = dentista;
    }

    protected Clinica setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    protected Clinica setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Asistente> getAsistentes() {
        return asistentes;
    }
    
    public ArrayList<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public Dentista getDentista() {
        return dentista;
    }
}
