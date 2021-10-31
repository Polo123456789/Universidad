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
        // TODO: Cambio. Resta los años, iguala los años en la fecha, y ve si
        // cumplio ya este año.
        String sDia = dia.getText();
        String sMes = mes.getText();
        String sAno = ano.getText();

        // Revisamos que tengamos datos
        if (sDia.isBlank() || sMes.isBlank() || sAno.isBlank()) {
            System.out.println("Los campos no pueden estar en blanco");
            return;
        }

        // Si el mes o año son con solo un digito, añadimos el 0 que requiere el
        // formato
        if (sMes.length() == 1) {
            sMes = "0" + sMes;
        }

        if (sDia.length() == 1) {
            sDia = "0" + sDia;
        }

        // Obtenemos las fechas
        String sFecha = sAno + "-" + sMes + "-" + sDia;
        LocalDate fecha = null;
        try {
            fecha = LocalDate.parse(sFecha);
        } catch (final DateTimeParseException e) {
            System.out.println("El formato de la fecha es incorrecto");
            System.out.println(e.getMessage());
            return;
        }
        LocalDate hoy = LocalDate.now();
        
        double diasPasados =
            Duration.between(fecha.atStartOfDay(), hoy.atStartOfDay()).toDays();

        edad.setText(Double.toString(diasPasados/365));
    }
}
