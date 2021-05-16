
/**
 * @param {number} peso
 * @param {number} altura
 * @return {number} El indice de masa corporal
 */
const imc = (peso, altura) => {
    return 703 * peso / (altura * altura);
}


const altura = parseInt(prompt("Ingrese su altura"));
const peso = parseInt(prompt("Ingrese su peso"));

alert("Su indice de masa corporal es: " + imc(peso, altura));
