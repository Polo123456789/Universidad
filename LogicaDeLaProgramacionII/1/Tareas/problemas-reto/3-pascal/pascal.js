// Triangulo de pascal
// ===================
// 
//     1
//    1 1
//   1 2 1
//  1 3 3 1
// 1 4 6 4 1
// 
// Y sigue
// 
// Calculo de una fila
// ===================
// 
// Los datos de la hilera n en el triangulo de pascal son los coeficientes de
// la siguiente ecuacion:
//
//      (x + y)^n
//
// Por ejemplo:
//
//      (x + y)^0 = 1                | La hilera 0 es (1)
//      (x + y)^2 = x^2 + 2xy + y^2  | La hilera 2 es (1 2 1)
//
// Una forma de calcular los exponentes es la siguiente para todo n natural:
//
// 1. Empezamos con
//
//      1(x^n)(y^0)
//
// Nuestro primer coeficiente es 1.
//
// 2. El siguiente coeficiente se calcula usando la siguiente formula:
//
//      C*X/I
//
// Donde:
// * C es el ultimo coeficiente que obtuviste
// * X es el ultimo exponente de x
// * I es el numero del elemento por el que vamos
//
// Ya con el siguiente coeficiente disminuimos la potencia de x en
// 1 y aumentamos la de y en 1
//
// 3. Repita el paso 2 hasta que el expoenente de y sea n
//
// Como nota, la hilera n para un triangulo de tamaño m la cantidad de espacios
// antes de colocar la hilera para que mantenga la forma de triangulo es igual
// a m-n

/**
 * @param {number} n La cantidad de espacios
 * @returns {string} Un string que contiene n espacios
 */
const padding = (n) => {
    let res = "";
    for (let i = 1; i <= n; i++) {
        res += " ";
    }
    return res;
}

/**
 * @param {number} n La hilera deseada del triangulo de pascal
 * @returns {string}
 */
const crearHilera = (n) => {
    let hilera = "";
    let exponenteX = n;
    let exponenteY = 0;
    let coeficiente = 1;

    for (let i = 1; i < n + 2; i++) {
        // Coeficiente actual
        hilera += coeficiente;
        hilera += padding(1);

        // Calculamos el siguiete
        coeficiente = (coeficiente * exponenteX) / i;
        exponenteX = exponenteX - 1;
        exponenteY = exponenteY + 1;
    }
    hilera += "\n";

    return hilera;
}

const cantidadHileras = parseInt(
    prompt("Cuantas hileras quiere del triangulo de pascal?")
) - 1;

let triangulo = "";
for (let i = 0; i < cantidadHileras + 1; i++) {
    triangulo += padding(cantidadHileras - i);
    triangulo += crearHilera(i);
}

alert(triangulo);
