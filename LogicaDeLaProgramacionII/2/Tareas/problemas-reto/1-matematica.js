// En el material complemetario nos da el link al libro: Speaking Javascript
//
// Aqui uso lo que menciona de los objetos:
// http://speakingjs.com/es5/ch01.html#_objects_and_constructors

const lista_estudiantes = [];
const lista_clases = [];

const cantidad_estudiantes = parseInt(
    prompt("Ingrese la cantidad de estudiantes:")
);

const cantidad_tareas = parseInt(
    prompt("Ingrese la cantidad de tareas:")
);

for (let i = 0; i < cantidad_estudiantes; i++) {
    const nombre = prompt("Ingrese el nombre del estudiante"); 
    lista_estudiantes[i] = {
        nombre: nombre,
        tareas: [],
    };
}

for (let i = 0; i < cantidad_tareas; i++) {
    lista_clases[i] = prompt("Ingrese el nombre de la tarea " + (i + 1) + ": ");
}

for (let estudiante of lista_estudiantes) {
    for (let clase of lista_clases) {
        
        const nota = parseInt(
            prompt("Ingrese la nota de '" + clase + "' de " + estudiante.nombre)
        );

        estudiante.tareas.push({
            clase: clase,
            nota: nota
        });
    }
}

let opciones = "Consultar notas de:\n\n";

lista_estudiantes.forEach((estudiante, index) => {
    opciones += `${index + 1}. ${estudiante.nombre}\n`;
});

const opcion = parseInt(prompt(opciones)) - 1;

let resultado = "";

lista_estudiantes[opcion].tareas.forEach((tarea) => {
    resultado += `${tarea.clase}: ${tarea.nota}\n`;
});

alert(resultado);
