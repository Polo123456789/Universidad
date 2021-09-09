package poo.proyecto_final;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Horario {
    protected final static Integer noId = -1;

    //
    // Las horas se guardaran en un formato como el de 24 horas
    //
    // Los 2 digitos inferiores indican los minutos, y los 2 superiores indican
    // las horas.
    //

    // Las clases pueden empezar lo mas temprano a las 6:00 AM
    public final static Integer inicioMinimo = 600;

    // Las clases pueden terminar a mas tardar a las 9:30 PM
    public final static Integer finalMaximo = 2130;

    // Las clases pueden durar como maximo 1 hora y media
    public final static Integer duracionMaxima = 130;

    public final static Integer minimoMinutos = 0;
    public final static Integer maximoMinutos = 59;

    public final static Integer aulaMinima = 1;
    public final static Integer aulaMaxima = 100;


    public final static String[] diasSemana = {
        "Lunes",
        "Martes",
        "Miercoles",
        "Jueves",
        "Viernes",
        "Sabado",
        "Domingo"
    };

    /** Utilidad para que `getHoras` nos retorne el horario completo */
    private static class Horas {
        public Integer inicio;
        public Integer fin;
    }

    private Integer id;
    private Integer aula;
    private Integer dia;
    private Integer inicio;
    private Integer fin; // En la base de datos es `final`, pero ese nombre no
                         // puede ser en java ya que es una palabra reservada
    
    public static Horario porId(DB db, Integer id) throws SQLException {
        Horario h = new Horario();

        ResultSet rs = 
            db.ejecutarQuery("SELECT * FROM horario WHERE id = " + id)
              .getResultSet();

        if (!rs.next()) {
            // El horario no existe, aunque por el uso, esto no deberia pasar
            // nunca
            return null;
        }

        h.id = rs.getInt("id");
        h.aula = rs.getInt("aula");
        h.dia = rs.getInt("dia");
        h.inicio = rs.getInt("inicio");
        h.fin = rs.getInt("final");

        return h;
    }

    public static ArrayList<Horario> porAula(DB db, Integer aula) 
        throws SQLException {

        ArrayList<Horario> horarios = new ArrayList<Horario>();
        ResultSet rs = 
            db.ejecutarQuery("SELECT * FROM horario WHERE aula = " + aula)
              .getResultSet();

        while (rs.next()) {
            Horario h = new Horario();

            h.id = rs.getInt("id");
            h.aula = rs.getInt("aula");
            h.dia = rs.getInt("dia");
            h.inicio = rs.getInt("inicio");
            h.fin = rs.getInt("final");
        }
        return horarios;
    }

    public static Horario leerDesdeTerminal(DB db)
        throws SQLException {

        Horario h = new Horario();

        System.out.print("En que aula se impartira? (" + aulaMinima + "-"
                         + aulaMaxima + ") ");

        h.aula = Input.leerNumero(
            new Input.Rango(aulaMinima, aulaMaxima)
        );

        System.out.println("Los dias en los que se puede impartir el curso son: ");
        TermUtil.imprimirOpciones(diasSemana);

        System.out.print("Que dia quiere impartir el curso? ");
        h.dia = Input.leerNumero(
            new Input.Rango(1, diasSemana.length)
        );

        System.out.println(explicacionFormato);

        boolean horarioInterfiere = true;
        loopExterna: while (horarioInterfiere) {
            Horas horas = leerHoras();
            h.inicio = horas.inicio;
            h.fin = horas.fin;

            ArrayList<Horario> horariosDeAula = porAula(db, h.aula);
            for (Horario horario : horariosDeAula) {
                if (h.interfiereCon(horario)) {
                    System.out.println(
                        Colors.red(
                            "\nHay otro horario en la misma aula que va de "
                            + horario.inicio + " a " + horario.fin + "\n"
                            + "Porfavor ingrese unas horas diferentes.\n"
                        )
                    );
                    continue loopExterna;
                }
            }

            horarioInterfiere = false;
        }

        return h;
    }

    public void modificarDesdeTerminal() {
        System.out.println("Ingrese los nuevos valores para los campos (o "
                           + "0 para mantener los valores que ya tienen)");

        System.out.print("Aula: ");
        final Integer posibleAula = Input.leerNumero(
            new Input.Rango(0, aulaMaxima)
        );
        if (posibleAula == 0) {
            aula = posibleAula;
        }

        System.out.println("Los dias en los que se puede impartir el curso son: ");
        TermUtil.imprimirOpciones(diasSemana);

        System.out.print("Dia: ");
        final Integer posibleDia = Input.leerNumero(
            new Input.Rango(1, diasSemana.length)
        );
        if (posibleDia == 0) {
            dia = posibleDia;
        }

        final Integer horaSinCambio = inicioMinimo - 1;
        System.out.println(explicacionFormato);
        System.out.println("Ingrese las nuevas horas, o " + horaSinCambio
                           + " para mantener");

        System.out.print("Inicio: ");
        final Integer posibleInicio = leerHora(
            new Input.Rango(horaSinCambio, finalMaximo)
        );
        if (posibleInicio != horaSinCambio) {
            inicio = posibleInicio;
        }

        System.out.print("Final: ");
        final Integer posibleFin = leerHora(
            new Input.Rango(horaSinCambio, finalMaximo)
        );
        if (posibleFin != horaSinCambio) {
            fin = posibleFin;
        }

    }

    public static Horas leerHoras() {
        Horas h = new Horas();

        boolean horarioInvalido = true;
        while (horarioInvalido) {
            System.out.print("Inicio: ");
            h.inicio = leerHora();

            System.out.print("Final: ");
            h.fin = leerHora();

            final Integer duracion = h.fin - h.inicio;

            if (duracion < 0) {
                System.out.println(
                    Colors.red("\nEl inicio tiene que estar antes que el final\n")
                );
                continue;
            }

            if (duracion > duracionMaxima) {
                System.out.println(
                    Colors.red("\nLas clases pueden durar como maximo una "
                               + "hora y media\n")
                );
                continue;
            }

            horarioInvalido = false;
        }

        return h;
    }

    public static Integer leerHora() {
        return leerHora(new Input.Rango(inicioMinimo, finalMaximo));
    }

    public static Integer leerHora(Input.Rango posiblesMinutos) {
        Integer hora = 0;
        boolean minutosInvalidos = true;
        while (minutosInvalidos) {
            hora = Input.leerNumero(
                new Input.Rango(inicioMinimo, finalMaximo)
            );

            final Integer minutos = getMinutos(hora);

            if (posiblesMinutos.enRango(minutos)) {
                minutosInvalidos = false;
                continue;
            }

            System.out.println(
                Colors.red("\nLos minutos pueden ser valoes desde 0 hasta 59\n")
            );
            System.out.print("Ingrese otra hora: ");
        }

        return hora;
    }

    public static Integer getMinutos(Integer hora) {
        return hora % 100;
    }

    public static Integer getHoras(Integer hora) {
        return (hora - getMinutos(hora)) / 100;
    }

    public boolean interfiereCon(Horario otro) {
        Input.Rango r = new Input.Rango(otro.getInicio(), otro.getFin());

        return r.enRango(this.inicio) || r.enRango(this.fin);
    }

    public Integer getId() {
        return id;
    }

    public Integer getAula() {
        return aula;
    }

    public Integer getInicio() {
        return inicio;
    }

    public Integer getFin() {
        return fin;
    }

    public Integer getDia() {
        return dia;
    }

    public Integer getMinutosInicio() {
        return getMinutos(inicio);
    }

    public Integer getHorasInicio() {
        return getHoras(inicio);
    }

    public Integer getMinutosFinal() {
        return getMinutos(fin);
    }

    public Integer getHorasFinal() {
        return getHoras(fin);
    }

    public Integer getDuracion() {
        return fin - inicio;
    }

    private static final String explicacionFormato =
        Colors.green("===================    Nota   ===================\n")
        + "Las horas tienen que ingresarse en el formato de 24 horas.\n"
        + "\n"
        + "Si la hora es pasada del medio dia, sumele al numero de la hora un 12.\n"
        + Colors.blue("Ejemplo:") + " 3:00 PM pasa a ser 15:00,"
        + " 6:00 PM pasa a ser 18:00, 7:00 AM se queda como 7:00.\n\n"
        + "Al ingresar las horas, omita el ':'."
        + Colors.blue("Ejemplo:") + " 3:00 PM pasa a ser 1500\n"
        + Colors.green("=================================================\n");
}
