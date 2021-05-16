/**
 * @param {number} n
 * @returns {boolean}
 */
const es_primo = (n) => {
    let primo = true;
    const limite_superior = Math.round(Math.sqrt(n));
    for (let i = 2; i < limite_superior + 1; i++) {
        if (n % i == 0) {
            primo = false;
        }
    }
    return primo;
}

if (es_primo(7) && es_primo(11) && !es_primo(4) && !es_primo(10) && es_primo(97)) {
    // El la funcion funciona
} else {
    alert("Error");
}

