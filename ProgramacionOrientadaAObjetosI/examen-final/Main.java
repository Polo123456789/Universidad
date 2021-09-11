import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(menuPrincipal);

            Clinica clinica = crearClinica();
            ArrayList<Paciente> pacientes = crearPacientes();
            gestionarTratamientos(clinica, pacientes);

            System.out.println("Finalizado");
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static void gestionarTratamientos(Clinica c, ArrayList<Paciente> p) {
        System.out.println("Ahora sus pacientes pueden recibir sus tratamientos:");
        do {
            // Enlistamos los datos
            System.out.println("Los tratamientos disponibles son:");
            enlistar(c.getTratamientos());
            System.out.println("Y los pacientes disponibles son:");
            enlistar(p);

            System.out.print("\ntratamiento: ");
            final Integer tratamientoSeleccionado = Input.leerNumero(
                new Input.Rango(1, c.getTratamientos().size())
            );

            System.out.print("paciente: ");
            final Integer pacienteSeleccionado = Input.leerNumero(
                new Input.Rango(1, p.size())
            );

            Tratamiento t = c.getTratamientos().get(tratamientoSeleccionado - 1);
            Paciente paciente = p.get(pacienteSeleccionado - 1);

            Pago pago = new Pago(t.getCosto());
            PagoConTarjeta pct = new PagoConTarjeta();

            if (pct.realizarPago(pago)) {
                System.out.println(paciente + " ha pagado exitosamente para"
                                   + " recibir " + t);
            } else {
                System.out.println(paciente + " no ha podido pagar para"
                                   + " recibir " + t);
            }
        } while (quiereContinuar());
    }

    public static void enlistar(ArrayList l) {
        for (int i = 0; i < l.size(); i++) {
            System.out.println((i+1) + ") " + l.get(i).toString());
        }
    }
 
    public static ArrayList<Paciente> crearPacientes() {
        ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
        System.out.println("Ahora crearemos a los pacientes:");
        do {
            System.out.println("\nIngrese los datos del paciente:");
            final String nombre = Input.leerNombre();
            final String apellido = Input.leerApellido();
            pacientes.add(new Paciente(nombre, apellido));
        } while(quiereContinuar());
        return pacientes;
    }

    public static Clinica crearClinica() {
        final Dentista dentista = leerDentista();
        
        System.out.println("\nIngrese los datos de la clinica:");
        final String nombre = Input.leerNombre();
        final String direccion = Input.leerDireccion();

        final Clinica c = new Clinica(nombre, direccion, dentista);
        llenarAsistentes(c);
        llenarTratamientos(c);

        return c;
    }

    public static Dentista leerDentista() {
        System.out.println("Ingrese los datos del dentista:");
        final String nombre = Input.leerNombre();
        final String apellido = Input.leerApellido();

        return new Dentista(nombre, apellido);
    }

    public static void llenarAsistentes(final Clinica c) {
        System.out.println("Ahora crearemos a las asistentes:");
        do {
            System.out.println("\nIngrese los datos de la asistente:");
            final String nombre = Input.leerNombre();
            final String apellido = Input.leerApellido();
            c.getAsistentes().add(new Asistente(nombre, apellido));
        } while(quiereContinuar());
    }

    public static void llenarTratamientos(final Clinica c) {
        System.out.println("Ahora crearemos a los tratamientos:");
        do {
            System.out.println("\nIngrese los datos de la tratamiento:");
            final String nombre = Input.leerNombre();
            System.out.print("costo: ");
            final Integer costo = Input.leerNumero(
                new Input.Rango(Tratamiento.costoMinimo,
                                Tratamiento.costoMaximo)
            );
            c.getTratamientos().add(new Tratamiento(nombre, costo));
        } while(quiereContinuar());

    }

    public static boolean quiereContinuar() {
        Scanner s = new Scanner(System.in);
        System.out.print("Quiere continuar ingresando? [s/n] ");
        String input = s.nextLine();

        if (input.equals("s")) {
            return true;
        }
        if (input.equals("n")) {
            return false;
        }

        System.out.println("Puede ingresar unicamente una 's' o una 'n'");
        return quiereContinuar();
    }


    private static String menuPrincipal =
        "Bienvenido\n"
        + "Gestionaremos una clinica. Crearemos la clinica, su dentista,\n"
        + "sus asistentes, y los tratamientos que provean.\n"
        + "Luego podra crear pacientes y elegir que tratamientos tendran\n";
}
