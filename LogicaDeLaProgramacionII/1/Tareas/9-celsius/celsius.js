/**
 * @param {number} celsius
 * @returns {number}
 */
const a_kelvin = (celsius) => {
    return celsius + 273.15;
}

/**
 * @param {number} celsius
 * @returns {number}
 */
const a_fahrenheit = (celsius) => {
    return (celsius * 1.8) + 32;
}

const celsius = parseInt(prompt("Ingrese una temperatura en celsius"));
const op = prompt(
    "A que lo quiere convertir? (f para fahrenheit, k para kelvin)"
);
switch (op) {
    case "f":
        alert("El equivalente en Fahrenheit es de " + a_fahrenheit(celsius));
        break;
    case "k":
        alert("El equivalente en Kelvin es de " + a_kelvin(celsius));
        break;
    default:
        alert("Tiene que elegir uno entre k y f");
}
