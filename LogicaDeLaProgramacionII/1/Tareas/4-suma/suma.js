
/**
 * @param {number} n
 */
const suma_primeros_n = (n) => {
    let suma = 0;
    for (let i = 0; i < n + 1; i++) {
        suma += i;
    }
    return suma;
}

const n = parseInt(prompt("Hasta que numero se tiene que realizar la suma?"));
alert(`La suma de los numeros de 1 hasta el ${n} es ${suma_primeros_n(n)}`);

