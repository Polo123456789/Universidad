// En el material complementario nos da el link al libro: Speaking Javascript
//
// Aquí uso la parte que habla de usar llaves arbitrarias:
// http://speakingjs.com/es5/ch01.html#_objects_and_constructors
//
// De experiencia previa que tengo programando, siento que es como los
// diccionarios de python.

// La llave es el hijo, y el valor es un array de los padres
const family_tree = {};

family_tree["Jorge"] = ["Elena", "Pablo"];
family_tree["Pablo"] = ["Rosa"];
family_tree["Elena"] = ["Mario"];
family_tree["Mario"] = ["Mariano"];

const subject = prompt("Ingrese el nombre de una persona");

const indent = (n) => {
    let r = "";
    for (let i = 0; i < n; i++) {
        r += "  ";
    }
    return r;
}

const generate_tree = (subject, depth) => {
    let result = "";
    // Si ya no tiene padres terminamos
    if (!family_tree[subject]) {
        return result;
    }

    // Si es el primero colocamos el nombre al principio
    if (depth == 1) {
        result += subject + "\n";
    }

    // Y indicamos quien es hijo de quien
    for (let parent of family_tree[subject]) {
        result += `${indent(depth)} es hijo de ${parent}\n`;
        result += generate_tree(parent, depth + 1);
    }

    return result;
}

alert(generate_tree(subject, 1));
console.log(generate_tree(subject, 1));
