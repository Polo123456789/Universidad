/**
 * @param {number} m
 * @param {number} n
 * @returns {number}
 */
const ackermann = (m, n) => {
    console.log("ackerman(" + m + ", " + n + ")");
    if (m == 0) {
        return n + 1;
    }
    if (m > 0 && n == 0) {
        return ackermann(m - 1, 1);
    }
    if (m > 0 && n > 0) {
        return ackermann(m - 1, ackermann(m, n - 1));
    }
}

console.log("Aqui esta")
const m = prompt("Ingrese un numero m");
const n = prompt("Ingrese un numero n");
alert("ackerman(" + m + ", " + n + ") = " + ackermann(m, n));
