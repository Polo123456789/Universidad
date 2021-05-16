
const mitad = (n) => {
    alert(n);
    if (n <= 1) {
    } else {
        mitad(n / 2);
    }
}

const n = parseInt(prompt("Ingrese un numero:"));
mitad(n / 2);

