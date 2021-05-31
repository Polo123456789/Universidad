"use strict";

const cantidad_numeros = 10;
const nums = [];

for (let i = 0; i < cantidad_numeros; i++) {
    nums[i] = parseInt(prompt("Ingrese un numero: "));
}

let max = nums[0];
let min = nums[0];

for (let i = 0; i < cantidad_numeros; i++) {
    if (nums[i] < min) {
        min = nums[i];
    }
    if (nums[i] > max) {
        max = nums[i];
    }
}

alert("Mayor: " + max);
alert("Menor: " + min);
