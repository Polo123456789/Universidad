"use strict";

const cantidad_dias = 7;
const dias_semana = [];

dias_semana[0] = "Domingo";
dias_semana[1] = "Lunes";
dias_semana[2] = "Martes";
dias_semana[3] = "Miercoles";
dias_semana[4] = "Jueves";
dias_semana[5] = "Viernes";
dias_semana[6] = "Sabado";

let entrada = 0;
while (entrada != -1) {

    entrada = parseInt(
        prompt("Ingrese un numero del 1 al 7 para obtener el dia equivalente"
            + " en la semana (-1 para terminar)")
    );

    if (entrada == -1) {
        continue;
    }

    if (entrada > 7 || entrada < 1) {
        alert("Tiene que ser un numero entre el 1 y el 7");
        continue;
    }

    alert("El dia equivalente es: " + dias_semana[entrada - 1]);
}
