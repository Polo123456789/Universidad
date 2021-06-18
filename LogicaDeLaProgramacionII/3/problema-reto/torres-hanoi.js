// @ts-check

/*
 * La solucion se basa en el articulo de wikipedia citado.
 *
 * Si es un paso impar, al mas pequeño se le movera en una direccion [^1].
 *
 * Si es un paso par, solo habra un movimiento legal que no involucre al mas
 * pequeño.
 *
 * [^1]: A la izquierda si es un numero impar (empezando por la de destino), y
 *       a la derecha si es par (empezando por el auxiliar).
 */

/** La cantidad de discos que se usara.
 *
 * Nota: Segun lo que comentamos en la reunion, y me dijo que estaba bien. Para
 * obtener la solucion del ejercicio 1, esta constante tendira que ser 3. Y para
 * obtener la solucion del ejercicio 2, esta constante deveria ser 4.
 */
const number_of_discs = 3;

/*------------------------------ Utilidades ----------------------------------*/

const number_of_towers = 3;

/**
 * La torre en la que estan inicialmente todos los discos.
 */
const base = 0;

/**
 * @typedef {number[]} hanoi_tower
 *
 * @typedef {{
 *      from: number;
 *      to: number;
 * }} hanoi_move
 */

const number_of_steps = (2 ** number_of_discs) - 1;
const even_discs = (number_of_discs % 2) === 0;
const no_disc = number_of_discs + 1;

/**
 * Convierte las torres de hanoi a un formato legible para ser impreso
 *
 * @param {hanoi_tower[]} towers
 */
const print_towers = (towers) => {
    let res = "";
    towers.forEach((tower, index) => {
        res += "Torre " + (index + 1) + " ";

        for (let disc of tower) {
            for (let i = 0; i < disc; i++) {
                res += "*";
            }
            res += " ";
        }

        res += "\n";
    })
    return res;
}


/**
 * Da el disco mas alto de la torre.
 *
 * @param {hanoi_tower} tower
 * @return {number} El valor del disco, o `no_disc` si no tiene discos
 */
const tower_top = (tower) => {
    if (tower.length !== 0) {
        return tower[tower.length - 1];
    }
    return no_disc;
}


/**
 * Mueve el disco de la torre `origin` a `destination`
 *
 * @param {hanoi_tower[]} towers
 * @param {hanoi_move} m
 */
const move = (towers, m) => {
    towers[m.to].push(towers[m.from].pop());
}


/**
 * Indica la posicion a la izquierda de la torre dada.
 *
 * @param {number} position
 */
const to_left = (position) => {
    let new_position = position - 1;
    if (new_position < 0) {
        new_position += number_of_towers;
    }
    return new_position;
}


/**
 * Indica la posicion a la derecha de la torre dada.
 *
 * @param {number} position
 */
const to_right = (position) => {
    return (position + 1) % number_of_towers;
}



/**
 * Indica en que torre esta el disco mas pequeño. (Tiene el valor 1).
 *
 * @param {hanoi_tower[]} towers
 */
const find_smallest = (towers) => {
    for (let i = 0; i < towers.length; i++) {
        if (tower_top(towers[i]) === 1) {
            return i;
        }
    }
}


/**
 * Para los pasos impares, se movera el mas pequeño tal como se indica al
 * principio.
 *
 * @param {hanoi_tower[]} towers
 */
const odd_step = (towers) => {
    const smallest_position = find_smallest(towers);
    const new_position = even_discs
                         ? to_right(smallest_position)
                         : to_left(smallest_position);

    move(towers, {from: smallest_position, to: new_position});
}


/**
 * Para los pasos pares, se busca el unico movimiento legal que no involucra al
 * miembro mas pequeño.
 *
 * @param {hanoi_tower[]} towers
 */
const even_step = (towers) => {
    const smallest_position = find_smallest(towers);

    const a = to_right(smallest_position);
    const b = to_right(a);

    // Nota: Ya que `no_disc` es un valor mas grande que cualquiera de los
    // discos, esta implementacion funciona sin tener que chequear por que la
    // torre este vacia, ya que movera el disco a esa torre.

    if (tower_top(towers[a]) < tower_top(towers[b])) {
        move(towers, {from: a, to: b});
    } else {
        move(towers, {from: b, to: a});
    }
}

/*------------------------------- Programa -----------------------------------*/

/**
 * Las torres en las que estan los discos
 *
 * @type {hanoi_tower[]}
 */
const towers = [];

// Llenamos las torres
for (let i = 0; i < number_of_towers; i++) {
    towers[i] = [];
}

for (let i = 0; i < number_of_discs; i++) {
    towers[base].push(number_of_discs - i);
}

console.log(`---------- Inicial ----------\n${print_towers(towers)}`)

// Solucion de la torre
//
// Nota: El cilo empieza en 1, para que sea mas facil el revisar si es un paso
// par o impar y imprimir el paso actual.
for (let i = 1; i <= number_of_steps; i++) {
    if (i % 2 === 0) {
        even_step(towers);
    } else {
        odd_step(towers);
    }

    console.log(`---------- Paso ${i} ----------\n` + print_towers(towers));
}
