/**
 * @param {number} n La cantidad de veces que se va a concatenar caracter
 * @param {string} character El caracter que se va a concatenar
 * @returns {string}
 */
const string_of_n = (n, character) => {
    let res = "";
    for (let i = 0; i < n; i++) {
        res += character;
    }
    return res;
}

/**
 * @param {number} a
 * @param {number} b
 * @param {number} c
 * @param {number} d
 * @param {number} e
 * @returns {string}
 */
const histograma = (a, b, c, d, e) => {
    let res = string_of_n(a, "*") + "\n";
    res += string_of_n(b, "*") + "\n";
    res += string_of_n(c, "*") + "\n";
    res += string_of_n(d, "*") + "\n";
    res += string_of_n(e, "*") + "\n";
    return res;
}

const max_rand = 10;
const min_rand = 1;
const rand = () => {
    return Math.floor((Math.random() * max_rand) + min_rand)
}

alert(
    histograma(
        rand(),
        rand(),
        rand(),
        rand(),
        rand()
    )
);
