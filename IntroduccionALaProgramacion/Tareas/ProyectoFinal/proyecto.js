//Variables utiles 
//Precio base de la cotización, en quetzales, lo puede cambiar
const precio_base = 2000

//Valores de los recargos 
const edad_18 = 0.1 // 10%
const edad_25 = 0.2 // 20%
const edad_50 = 0.3 // 30%

const porcentaje_recargo_por_edad = (edad) => {
    if (edad >= 18 && edad < 25) {
        return edad_18;

    }//aqui puede colocar un else if() con el siguiente rango
    else if (edad >= 25 && edad < 50) {
        return edad_25;

    } else if (edad >= 50) {
        return edad_50;

    } else {
        throw "Edad invalida, tiene que ser mayor de 18 años";
    }
}

const hijos = 0.2 // 20%

//Recargo
let recargo = 0
let recargo_total = 0

//Precio final 
let precio_final = 0

//Mensajes de alerta para ingresar datos 
const nombre = prompt("Ingrese su nombre, por favor")
const edad = prompt("¿Cuantos años tiene? Ingrese solamente números ")
const casado = prompt("¿Está casado actualmente?", "si/no")

//Comprobamos la edad del cónyuge, solamente si se está casado/a
let edad_conyuge = "";
if ("SI" == casado.toUpperCase()) {
    edad_conyuge = prompt("¿Que edad tiene su esposo/a?")
}

//convirtiendo las edades ingresadas a números 
const edad_numero = parseInt(edad)

let edad_conyuge_numero = 0
//convirtiendo la edad del cónyuge si se esta casado/a
if ("SI" == casado.toUpperCase()) {
    edad_conyuge_numero = parseInt(edad_conyuge)
}

const tiene_hijos = prompt("¿Tiene hijos o hijas?").toUpperCase() == "SI";

//Comprobamos la cantidad de hijos solamente si los tienen
let cantidad_hijos = "";
if (tiene_hijos) {
    cantidad_hijos = prompt("Cuantos hijos tiene?")
}

/**
 * 1. convierta la cantidad de hijos a numero
 */
let cantidad_hijos_numero = 0;
if (tiene_hijos) {
    cantidad_hijos_numero = parseInt(cantidad_hijos);
}

//Aquí debe calcular el recargo total basado en las respuestas ingresadas

//Aquí es donde debe de calcular los recargos y el valor final
//Ejemplo (Debe completar los condicionales): 

// -------------------------------
// Recargo por edad del asegurado 
// -------------------------------

recargo = precio_base * porcentaje_recargo_por_edad(edad_numero);
recargo_total += recargo;

/** 
 * 2. Recargo por la edad del conyuge
 */

if (casado.toUpperCase() == "SI") {
    recargo = precio_base * porcentaje_recargo_por_edad(edad_conyuge_numero);
    recargo_total += recargo;
}

/**
 * 3. Recargo por la cantidad de hijos 
 */

if (tiene_hijos) {
    const recargo_por_hijo = precio_base * hijos;
    recargo = recargo_por_hijo * cantidad_hijos_numero;
    recargo_total += recargo;
}


precio_final = precio_base + recargo_total

//Resultado
alert("Para el asegurado " + nombre)
alert("El recargo total sera de: " + recargo_total)
alert("El precio sera de: " + precio_final)
