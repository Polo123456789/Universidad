/**
 * @param {number} n
 * @returns {number}
 */
const fibonnacci = (n) => {
    if (n == 0 || n == 1) {
        return n;
    }
    return fibonnacci(n - 1) + fibonnacci(n - 2);
}

const n = parseInt(prompt("Ingrese un numero: "));
alert("El numero " + n + " de la secuencia de Fibonacci es: " + fibonnacci(n));
