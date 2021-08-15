import static java.lang.System.out;

final public class Main {
    public static void main(String[] args) {
        out.println("-------------------------------------------");
        out.println("-           Seccion de empleado           -");
        out.println("-------------------------------------------");

        out.println("\nClase base: Empleado");
        out.println("====================");

        Empleado empleado = new Empleado(1234566,
                                         "Pedro",
                                         "Perez Garcia",
                                         115,
                                         "3723-2445",
                                         "pedroG@gmail.com");

        out.println(empleado.trabajar());

        out.println("\nClase derivada: Administrador");
        out.println("=============================");

        Administrador admin = new Administrador(203948,
                                                "Juan",
                                                "Martines Garcia",
                                                115,
                                                "3723-3345",
                                                "juanMa@gmail.com");

        // Trabajar ha sido sobrecargado para ser igual a organizarEmpleados.
        out.println(admin.trabajar());
        out.println(admin.planearProyecto("Puente la paz"));
        out.println(admin.organizarEmpleados());
        out.println(admin.coordinarReuniones());

        out.println("\nClase derivada: Secretaria");
        out.println("============================");

        Secretaria secretaria = new Secretaria(3093432,
                                                "Marga",
                                                "Martines Perez",
                                                115,
                                                "3723-4563",
                                                "marmp@gmail.com");

        out.println(secretaria.trabajar());
        out.println(secretaria.llevarRegistros());
        out.println(secretaria.recordarAlAdministrador(admin));
        out.println(secretaria.organizarEvento("fiesta de fin de año"));

        out.println("\nClase derivada: Contador");
        out.println("============================");

        Contador contador = new Contador(2034783098,
                                         "Maria",
                                         "Alma Perez",
                                         115,
                                         "3949-4563",
                                         "maria-alma@gmail.com");

        out.println(contador.trabajar());
        out.println(contador.revisarLibrosContables());
        out.println(contador.crearInformes());
        out.println(contador.analizarGanancias());

        out.println("\n-------------------------------------------");
        out.println("-           Seccion de animal             -");
        out.println("-------------------------------------------");

        out.println("\nClase base: Animal");
        out.println("==================");

        Animal a = new Animal(3);

        out.println(a.alimentarse());
        out.println(a.dormir());

        out.println("\nClase derivada: Perro");
        out.println("=======================");

        Perro p = new Perro(1, "Carlos");

        out.println(p.alimentarse());
        out.println(p.dormir());
        out.println(p.jugar());
        out.println(p.romperAlgo());

        out.println("\nClase derivada: Paloma");
        out.println("========================");

        Paloma pa = new Paloma(4);

        out.println(pa.alimentarse());
        out.println(pa.dormir());
        out.println(pa.volar());

        out.println("\nClase derivada: Delfin");
        out.println("========================");

        Delfin d = new Delfin(4);

        out.println(d.alimentarse());
        out.println(d.dormir());
        out.println(d.nadar());
    }
}
