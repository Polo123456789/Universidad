
const factorial = (n) => {
    if (n == 0) {
        return 1;
    } else {
        return n * factorial(n - 1);
    }
}

const n = parseInt(prompt("Ingrese un numero: "));
alert("El factorial de " + n + " es: " + factorial(n));

