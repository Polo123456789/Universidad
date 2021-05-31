// De aparecer 2 veces, se devolvera la primera posicion
const posicion_en_arreglo = (arreglo, cantidad, dato_a_buscar) => {
    for (let i = 0; i < cantidad; i++) {
        if (arreglo[i] == dato_a_buscar) {
            return i;
        }
    }
    return -1;
}

const llenar_arrelgo = (arreglo, cantidad) => {
    for (let i = 0; i < cantidad; i++) {
        arreglo[i] = Math.floor(Math.random() * 100) + 1;
    }
}

const cantidad_numeros = 10;
const arreglo = [];

llenar_arrelgo(arreglo, cantidad_numeros);
alert(arreglo)

const ingreso = parseInt(prompt("Ingreso:"));
const posicion = posicion_en_arreglo(arreglo, cantidad_numeros, ingreso);
alert("Respuesta: " + (posicion == -1 ? posicion : posicion + 1));
