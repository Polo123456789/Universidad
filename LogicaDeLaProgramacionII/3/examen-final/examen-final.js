// @ts-check

"use strict";

/**
 * @typedef {Object} listadoCompras
 * @property {string} proyecto
 * @property {string} mes
 * @property {number} costo
 */

/**
 * @typedef {Object} costoProyecto
 * @property {string} proyecto
 * @property {number[]} costosMensuales
 * @property {number} total
 */

/** @type {listadoCompras[]} */
const listado = [
    {
        proyecto: "Plaza Europa",
        mes: "Octubre",
        costo: 15000
    },
    {
        proyecto: "Plaza Europa",
        mes: "Octubre",
        costo: 25000
    },
    {
        proyecto: "Plaza Europa",
        mes: "Diciembre",
        costo: 17500
    },
    {
        proyecto: "Edificio Marbella",
        mes: "Agosto",
        costo: 12000
    },
    {
        proyecto: "Edificio Marbella",
        mes: "Julio",
        costo: 36000
    },
    {
        proyecto: "Edificio Marbella",
        mes: "Septiembre",
        costo: 20000
    },
];

const meses = [
    "Enero",
    "Febrero",
    "Marzo",
    "Abril",
    "Mayo",
    "Junio",
    "Julio",
    "Agosto",
    "Septiembre",
    "Octubre",
    "Noviembre",
    "Diciembre",
];

// Si es de los meses del 0-5, tenemos que mostrar los datos del primer
// semestre. Si son los datos del 6-11, tenemos que mostrar los del segundo
const semestre = meses.indexOf(listado[0].mes) < 6 ? 1 : 2;

/**
 * Funcion para ver si el mes que se esta ingresando corresponde con el semestre
 * del que se estan ingresando los datos
 *
 * @param {number} mes
 */
const mesEnSemestre = (mes) => {

    if (semestre == 1) {
        // El semestre 1 ocupa los meses del 0 al 5
        if (mes < 6) {
            return true;
        }
        // Pasado de eso esta fuera del semestre
        return false;
    }
    // Antes del mes 6 esta fuera del semestre 2
    if (mes < 6) {
        return false;
    }
    return true;
}

/**
 * Crea un array con 12 ceros para indicar los costos mensuales de los
 * proyectos.
 *
 * @return {number[]}
 */
const mesesEn0 = () => {
    const temp = [];
    for (let i = 0; i < meses.length; i++) {
        temp.push(0);
    }
    return temp;
}

/**
 * Busca el proyecto nombrado, retornado su indice si no es encontrado retorna
 * -1
 *
 * @param {string} proyecto
 * @param {costoProyecto[]} costos
 */
const buscarProyecto = (proyecto, costos) => {
    for (let i = 0; i < costos.length; i++) {
        if (proyecto === costos[i].proyecto) {
            return i;
        }
    }
    return -1;
}

const calcularCostos = () => {
    /** @type {costoProyecto[]} */
    const costos = [];

    // Sacamos los costos
    for (const compra of listado) {
        let posicion = buscarProyecto(compra.proyecto, costos);

        // Si no existe creamos el proyecto
        if (posicion === -1) {

            /** @type {costoProyecto} */
            const costoDeProyecto = {
                proyecto: compra.proyecto,
                costosMensuales: mesesEn0(),
                total: 0,
            };

            costos.push(costoDeProyecto);
            posicion = costos.length - 1;
        }

        // Y inlcuimos los costos dependiendo del mes
        const mes = meses.indexOf(compra.mes);
        if (!mesEnSemestre(mes)) {
            alert(
                `Se estan ingresando los datos para el semestre ${semestre},` + 
                ` y el mes ${compra.mes} esta fuera de el. Estos datos no ` +
                `se mostraran en el resultado final`
            );
        }
        costos[posicion].costosMensuales[mes] += compra.costo;
        costos[posicion].total += compra.costo;
    }

    return costos;
}

/**
 * @param {number} esperado El largo esperado del string
 * @param {number} actual El largo actual del string
 * @param {string} caracter Caracter que se usara para relleno
 */
const crearPadding = (esperado, actual, caracter = " ") => {
    const necesario = esperado - actual;
    let padding = "";
    for (let i = 0; i < necesario; i++) {
        padding += caracter;
    }
    return padding;
}

const largoProyecto = 20;
const largoMeses = 12;

/**
 * @param {costoProyecto[]} costos
 */
const crearTabla = (costos) => {
    // Y lo pasamos a una tabla
    const primerMes = semestre == 1 ? 0 : 6;
    const ultimoMes = semestre == 1 ? 6 : 12;

    // Largos esperados
    let res = "Proyecto" + crearPadding(largoProyecto, 8);
    for (let i = primerMes; i < ultimoMes; i++) {
        res += `${meses[i]}` + crearPadding(largoMeses, meses[i].length);
    }
    res += "Total\n";

    for (let costo of costos) {
        res += `${costo.proyecto}` + crearPadding(largoProyecto, costo.proyecto.length);
        for (let i = primerMes; i < ultimoMes; i++) {
            const mensual = costo.costosMensuales[i].toString();
            res += `${mensual}` + crearPadding(largoMeses, mensual.length);
        }
        res += `${costo.total}\n`;
    }
    return res;
}

const costos = calcularCostos();
const formatoLegible = crearTabla(costos);

alert(
    "En el alert se mira mal el formato, mire la consola para ver el resultado"
);
console.log(formatoLegible);
