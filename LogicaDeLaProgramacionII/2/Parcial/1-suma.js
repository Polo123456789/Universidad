"use strict";

const size = 10;
const numbers = [];

for (let i = 0; i < size; i++) {
    numbers[i] = Number(prompt("Ingrese el numero " + (i + 1) + ":"));
}

let sum = 0;
for (let i = 0; i < 10; i++) {
    sum = sum + numbers[i];
}

alert(numbers);
alert("La suma de los valores es: " + sum);
