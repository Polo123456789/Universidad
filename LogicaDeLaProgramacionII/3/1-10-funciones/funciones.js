// @ts-check

/*
--------------------------------------------------------------------------------
1. Hacer una función que reciba un número y que devuelva un arreglo vacío de
   ese tamaño
--------------------------------------------------------------------------------
 */

/**
 * @param {number} size Tamaño del array a crear
 */
const arregloVacio = (size) => {
    return Array(size);
};



/*
--------------------------------------------------------------------------------
2. Hacer una función que genere un número aleatorio
--------------------------------------------------------------------------------
 */

const numeroAleatorio = () => {
    const min = 0;
    const max = 100;
    return Math.floor(Math.random() * max) + min;
}



/*
--------------------------------------------------------------------------------
3. Hacer una función que reciba un número y llene un arreglo de ese tamaño
   con un números aleatorios y que devuelva el arreglo. (haga uso de las
   funciones realizadas en los ejercicios anteriores)
--------------------------------------------------------------------------------
 */

/**
 * @param {number} size Tamaño del array
 * @return {number[]}
 */
const arrayAleatorio = (size) => {
    const temp = arregloVacio(size);
    for (let i = 0; i < size; i++) {
        temp[i] = numeroAleatorio();
    }
    return temp;
}



/*
--------------------------------------------------------------------------------
4. Hacer una función que reciba un arreglo y un valor, la función debe
   buscar el valor en el arreglo y devolver la posición donde se encuentra
   el valor, si el valor no se encuentra en el arreglo debe devolver -1.
--------------------------------------------------------------------------------
 */

/**
 * @param {any[]} arreglo
 * @param {any} val
 */
const buscarEnArreglo = (arreglo, val) => {
    for (let i = 0; i < arreglo.length; i++) {
        if (arreglo[i] === val) {
            return i;
        }
    }
    return -1;
}



/*
--------------------------------------------------------------------------------
5. Hacer una función que reciba un arreglo y una posición, la función debe
   retornar el contenido del arreglo que se encuentra en la posición
   indicada.
--------------------------------------------------------------------------------
 */

/**
 * @param {any[]} arreglo
 * @param {number} pos
 */
const arregloEn = (arreglo, pos) => {
    return arreglo[pos];
}



/*
--------------------------------------------------------------------------------
6. Hacer una función que reciba un arreglo y un dato, la función debe
   agregar el dato al final del arreglo y retornar el arreglo
--------------------------------------------------------------------------------
 */

/**
 * @param {any[]} arreglo
 * @param {any} val
 */
const agregarAlFinal = (arreglo, val) => {
    // arreglo.push(val);
    arreglo[arreglo.length] = val;
    return arreglo;
}



/*
--------------------------------------------------------------------------------
7. Hacer una función que reciba un arreglo y que elimine el último elemento
   del arreglo.  Al finalizar la función debe devolver el arreglo.
--------------------------------------------------------------------------------
 */

/**
 * @param {any[]} arreglo
 */
const eliminarUltimo = (arreglo) => {

    // No estoy seguro de si esto es correcto:
    //      
    //      arreglo.length--;
    //
    // Supongo que funcionara, pero no estoy seguro de que sea una buena forma
    // de hacerlo
    //
    // Asi que lo dejo con `pop`:

    arreglo.pop();
    return arreglo;
}



/*
--------------------------------------------------------------------------------
8. Hacer una función que reciba un arreglo y que elimine el primer dato del
   arreglo. Al finalizar la función debe retornar el arreglo
--------------------------------------------------------------------------------
 */

/**
 * @param {any[]} arreglo
 */
const eliminarPrimero = (arreglo) => {
    // arreglo.shift();
    
    // Movemos todos los elementos uno hacia atras y eliminamos el ultimo.
    for (let i = 0; i < arreglo.length - 1; i++) {
        arreglo[i] = arreglo[i + 1];
    }
    eliminarUltimo(arreglo);

    return arreglo;
}



/*
--------------------------------------------------------------------------------
9. Hacer una función que reciba un arreglo, una posición y un dato. La función
   debe insertar un dato en una posición definida. Al finalizar debe retornar
   el arreglo.
--------------------------------------------------------------------------------
 */

/**
 * @param {any[]} arreglo
 * @param {number} pos Posicion en la que se ingresara
 * @param {any} val Valor a ingresar
 */
const insertarEnArreglo = (arreglo, pos, val) => {
    // arreglo.splice(pos, 0, val);

    // Movemos todos los elementos un espacio hacia adelante a partir de pos
    for (let i = arreglo.length - 1; i > pos - 1; i--) {
        arreglo[i + 1] = arreglo[i];
    }
    // Y insertamos el nuevo valor
    arreglo[pos] = val;

    return arreglo;
}



/*
--------------------------------------------------------------------------------
10. Hacer una función que reciba un arreglo y que devuelva un arreglo con un
    formato definido por ustedes. (sea creativo y original para el formato a
    visualizar). Por ejemplo:

        Entrada: [1,5,9,6]
        Salida: “| 1 | 5 | 9 | 6 |”
--------------------------------------------------------------------------------
 */

/**
 * Le da el siguiente formato al arrelgo:
 *
 *      (e1, e2, e3, ...)
 *
 * @param {any[]} arreglo
 */
const formatearArreglo = (arreglo) => {
    let result = "(";
    for (let i = 0; i < arreglo.length - 1; i++) {
        result += arreglo[i] + ", ";
    }
    result += arreglo[arreglo.length - 1] + ")";
    return result;
}



/*
--------------------------------------------------------------------------------
11. Hacer un programa que haga uso de las funciones anteriores:

    En el programa debe crear una matriz 3x3 y llenarla con números aleatorios.

    Luego de haber creado la matriz, debe eliminar los valores de la primera
    fila, reemplazar la primera fila y llenarla con números solicitados al
    usuario.

    Luego debe eliminar el dato de la matriz en la posición [2][2] y colocarle
    su nombre, al finalizar debe mostrar en pantalla la matriz utilizando la
    función que muestra los arreglos en un formato definido por ustedes

--------------------------------------------------------------------------------
 */

const ejercicio11 = () => {
    const size = 3;

    // En el programa debe crear una matriz 3x3 y llenarla con numeros
    // aleatorios
    const matriz = arregloVacio(size);
    for (let i = 0; i < size; i ++) {
        matriz[i] = arrayAleatorio(size);
    }

    // debe eliminar los valores de la primera fila
    for (let i = 0; i < size; i ++) {
        eliminarUltimo(matriz[0]);
    }

    // reemplazar la primera fila
    matriz[0] = arregloVacio(size);

    // llenarla con números solicitados al usuario
    for (let i = 0; i < size; i ++) {
        matriz[0][i] = prompt("Ingrese un numero");
    }

    // Luego debe eliminar el dato de la matriz en la posición [2][2] y
    // colocarle su nombre
    matriz[2][2] = "Pablo Sanchez";


    // Al finalizar debe mostrar en pantalla la matriz utilizando la función
    // que muestra los arreglos en un formato definido por ustedes
    let res = "";
    for (let i = 0; i < size; i ++) {
        res += formatearArreglo(matriz[i]) + "\n";
    }

    alert(res);
}

ejercicio11();
