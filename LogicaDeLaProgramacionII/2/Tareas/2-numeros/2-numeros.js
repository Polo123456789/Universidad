"use strict";

const cantidad_numeros = 10;
const nums = []

for (let i = 1; i <= 10; i++) {
    nums[i - 1] = prompt("Ingrese un numero: ");
}

alert(nums);
