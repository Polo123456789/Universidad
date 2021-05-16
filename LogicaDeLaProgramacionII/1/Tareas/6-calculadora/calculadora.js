/**
 * @param {number} a
 * @param {number} b
 */
const suma = (a, b) => {
    return a + b;
}

/**
 * @param {number} a
 * @param {number} b
 */
const resta = (a, b) => {
    return a - b;
}

/**
 * @param {number} a
 * @param {number} b
 */
const multiplicacion = (a, b) => {
    return a * b;
}

/**
 * @param {number} a
 * @param {number} b
 */
const divicion = (a, b) => {
    if (b != 0) {
        return a / b;
    }
    throw "b Tiene que ser un numero distinto de 0"
}

/**
 * Funcion que muestra el menu y pide los datos al usuario
 */
const menu = () => {
    const a = parseInt(prompt("Ingrese un numero"));
    const b = parseInt(prompt("Ingrese otro numero"));
    const op = prompt("Ingrese una operacion (+, -, *, /)");

    let res = 0;
    switch (op) {
        case "+":
            res = suma(a, b);
            break;
        case "-":
            res = resta(a, b);
            break;
        case "*":
            res = multiplicacion(a, b);
            break;
        case "/":
            res = divicion(a, b);
            break;
        default:
            alert("Esa no es una operacion valida");
            return;
    }
    alert("El resultado de " + a + op + b + " es " + res);
}

menu();

