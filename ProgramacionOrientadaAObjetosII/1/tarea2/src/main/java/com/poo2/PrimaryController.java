package com.poo2;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML
    TextField dia;
    @FXML
    TextField mes;
    @FXML
    TextField ano;
    @FXML
    TextField edad;
    @FXML
    TextField fechaEnTexto;

    @FXML
    public void calcularEdad() {
        String sDia = dia.getText();
        String sMes = mes.getText();
        String sAno = ano.getText();

        //
        // Revisamos que tengamos datos
        //
        if (sDia.isBlank() || sMes.isBlank() || sAno.isBlank()) {
            System.out.println("Los campos no pueden estar en blanco");
            return;
        }

        //
        // Si el mes o año son con solo un digito, añadimos el 0 que requiere el
        // formato
        //
        if (sMes.length() == 1) {
            sMes = "0" + sMes;
        }

        if (sDia.length() == 1) {
            sDia = "0" + sDia;
        }

        //
        // Mostramos la edad
        //
        final Integer anosPasados = calcularAnosPasados(sDia, sMes, sAno);
        if (anosPasados == -1) {
            return; // El error ya se indico en calcularAnosPasados
        }
        edad.setText(anosPasados.toString());


        //
        // Volvemos la fecha texto
        //
        final String enTexto = convertirATexto(sDia, sMes, sAno);
        fechaEnTexto.setText(enTexto);
    }

    private static Integer calcularAnosPasados(String dia,
                                               String mes,
                                               String ano) { 
        //
        // Obtenemos las fechas
        //
        String sFecha = ano + "-" + mes + "-" + dia;
        LocalDate fecha = null;
        try {
            fecha = LocalDate.parse(sFecha);
        } catch (final DateTimeParseException e) {
            System.out.println("El formato de la fecha es incorrecto");
            System.out.println(e.getMessage());
            return -1;
        }
        LocalDate hoy = LocalDate.now();
        
        //
        // Calculamos nos años que han pasado
        //
        Integer anoNacimiento = fecha.getYear();
        Integer anoActual = hoy.getYear();
        Integer anosPasados = anoActual - anoNacimiento;

        //
        // Y si no ha cumplido este año, le restamos 1
        //
        LocalDate fechaAjustada = fecha.plusYears(anosPasados);
        if (fechaAjustada.compareTo(hoy) > 0) {
            anosPasados--;
        }

        return anosPasados;
    }

    private static String convertirATexto(String sDia,
                                          String sMes,
                                          String sAno) { 

        Integer dia = Integer.parseInt(sDia);
        Integer mes = Integer.parseInt(sMes);
        Integer ano = Integer.parseInt(sAno);

        return convertirDobleDigitoATexto(dia)
               + " de "
               + nombresMeses[mes - 1]
               + " del "
               + convertirAnoATexto(ano);
    }

    private static String[] nombresMeses = {
        "Enero",
        "Febrero",
        "Marzo",
        "Abril",
        "Mayo",
        "Junio",
        "Julio",
        "Agosto",
        "Septiembre",
        "Octubre",
        "Noviembre",
        "Diciembre"
    };

    private static Boolean esDecimal(Integer n) {
        return n < 10 && n > -1;
    }
    private static String[] nombresDecimales = {
        "cero",
        "uno",
        "dos",
        "tres",
        "cuatro",
        "cinco",
        "seis",
        "siete",
        "ocho",
        "nueve",
    };

    private static Boolean esEspecial(Integer n) {
        return n > 9 && n < 16;
    }
    private static String[] nombresNumerosEspeciales = {
        "dies",
        "once",
        "doce",
        "trece",
        "catorce",
        "quince",
    };

    private static String[] nombresDecenas = {
        "dies",
        "veinte",
        "treinta",
        "cuarenta",
        "cincuenta",
        "sesenta",
        "setenta",
        "ochenta",
        "noventa",
    };

    private static String convertirDobleDigitoATexto(final Integer n) {
        if (esDecimal(n)) {
            return nombresDecimales[n];
        }

        
        if (esEspecial(n)) {
            return nombresNumerosEspeciales[n - 10];
        }

        final Integer unidades = n % 10;
        final Integer decenas = (n - unidades) / 10;

        final String nombreDecena = nombresDecenas[decenas - 1];
        final String nombreUnidades = (unidades != 0)
                                      ? " y " + nombresDecimales[unidades]
                                      : "";

        return nombreDecena + nombreUnidades;
    }

    private static String convertirAnoATexto(final Integer ano) {
        final Integer digitosBajos = ano % 100;
        final Integer digitosAltos = (ano - digitosBajos) / 100;
        final String nombreAno = (digitosAltos == 19)
                                    ? "mil novecientos "
                                    : "dos mil ";
        return nombreAno
            + convertirDobleDigitoATexto(digitosBajos);
    }
}
