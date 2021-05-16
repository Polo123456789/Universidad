/**
 * @param {number} n Un numero que se traduzca directamente a un numero romano
 * @returns {string} El equivalente romano de n
 */
const romano_por_valor = (n) => {
    switch (n) {
        case 500:
            return "D";
        case 400:
            return "CD";
        case 100:
            return "C";
        case 90:
            return "XC";
        case 50:
            return "L";
        case 40:
            return "XL";
        case 10:
            return "X";
        case 9:
            return "IX";
        case 5:
            return "V";
        case 4:
            return "IV";
        case 1:
            return "I";
        default:
            return "`n` no se traduce directamente a un numero romano";
    }
}

/**
 * @param {number} n Un numero a convertir a romano
 * @returns {string} El equivalente romano de n
 */
const a_romano = (n) => {
    // Para la explicacion del algoritmo ver romanos.psc

    const valores = [
        500,
        400,
        100,
        90,
        50,
        40,
        10,
        9,
        5,
        4,
        1,
    ]

    let romano = "";
    for (i = 1; i < 11; i++) {
        while (valores[i] <= n) {
            n = n - valores[i];
            romano = romano + romano_por_valor(valores[i]);
        }
    }
    return romano;
}


/**
 * Toma un numero al azar y lo convierte a romano
 */
const azar_a_romano = () => {
    const max_azar = 500;
    const n = Math.floor(Math.random() * (max_azar));
    alert("Numero " + n + " a romano es: " + a_romano(n));
}

azar_a_romano();
azar_a_romano();
azar_a_romano();

