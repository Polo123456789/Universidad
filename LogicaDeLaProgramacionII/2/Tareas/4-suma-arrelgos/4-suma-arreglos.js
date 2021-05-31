"use strict";

const llenar_arrelgo = (arreglo, cantidad) => {
    for (let i = 0; i < cantidad; i++) {
        arreglo[i] = Math.floor(Math.random() * 100) + 1;
    }
}

const cantidad_numeros = 10;

let a1 = [];
let a2 = [];
let resultado = [];

llenar_arrelgo(a1, cantidad_numeros);
llenar_arrelgo(a2, cantidad_numeros);

for (let i = 0; i < cantidad_numeros; i++) {
    resultado[i] = a1[i] + a2[i];
}

alert(a1);
alert(a2);
alert(resultado);
