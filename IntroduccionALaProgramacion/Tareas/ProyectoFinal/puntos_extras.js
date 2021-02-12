// Base para calcular los recargos
const precio_base = 2000;


// Recargos por edad
const porcentaje_recargo_por_edad = (edad) => {
    const edad_18 = 0.1;
    const edad_25 = 0.2;
    const edad_50 = 0.3;

    if (edad >= 18 && edad < 25) {
        return edad_18;

    } else if (edad >= 25 && edad < 50) {
        return edad_25;

    } else if (edad >= 50) {
        return edad_50;

    } else {
        throw "Edad invalida, tiene que ser mayor de 18 años";
    }
}
const regargo_por_edad = () => {
    const edad = parseInt(prompt("Cual es su edad?"));
    return porcentaje_recargo_por_edad(edad) * precio_base;
}


// Recargo por conyugye
const recargo_por_conyuge = () => {
    const respuesta = prompt("¿Esta casado actualmente?", "si/no").toLowerCase();
    const casado = respuesta === "si";
    if (!casado) {
        return 0;
    }

    const edad = parseInt(prompt("¿Que edad tiene su esposo/a?"));
    return porcentaje_recargo_por_edad(edad) * precio_base;
}


// Recargo por hijos
const porcentaje_recargo_por_hijo = 0.2;
const recargo_por_hijos = () => {
    const respuesta = prompt("¿Tiene hijos o hijas?", "si/no").toLowerCase();
    const tiene_hijos = respuesta === "si";
    if (!tiene_hijos) {
        return 0;
    }
    const cantidad = parseInt(prompt("Cuantos hijos tiene?"));
    if (cantidad <= 0) {
        throw "De tener hijos, tiene que ingresar un numero positivo";
    }
    return cantidad * porcentaje_recargo_por_hijo * precio_base;
}


// Recargo por propiedades
const porcentaje_recargo_por_propiedad = 0.35;
const recargo_por_propiedad = () => {
    const cantidad = parseInt(prompt("Cuantas propiedades tiene?"));
    if (cantidad < 0) {
        throw "Tiene que ingresar un numero positivo o '0'";
    }
    return cantidad * porcentaje_recargo_por_propiedad;
}


// Recargo por salario
const porcentaje_recargo_por_salario = 0.05;
const recargo_por_salario = () => {
    const salario = parseInt(prompt("Cual es su salario?"))
    if (salario < 0) {
        throw "Tiene que ingresar un numero positivo o '0'";
    }
    return salario * porcentaje_recargo_por_salario;
}


const recargos_por_factores = [
    regargo_por_edad,
    recargo_por_conyuge,
    recargo_por_hijos,
    recargo_por_propiedad,
    recargo_por_salario,
];

let cotizar = true;
while (cotizar) {
    const nombre = prompt("Ingrese su nombre (O 'Salir' para terminar)");
    if (nombre.toLowerCase() === "salir") {
        cotizar = false;
        continue;
    }

    let recargo_total = 0;
    try {
        for (let recargo_por_factor of recargos_por_factores) {
            const recargo = recargo_por_factor();
            recargo_total += recargo;
        }

    } catch (error) {
        alert(error);
        continue;
    }

    const precio_final = precio_base + recargo_total;
    alert("Para el asegurado " + nombre)
    alert("El recargo total sera de: " + recargo_total)
    alert("El precio sera de: " + precio_final)
}
