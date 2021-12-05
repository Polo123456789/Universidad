// @ts-check

// Para llenar rapido las encuestas al final de bloque
function marcarTodos() {
    let inputs = document.querySelectorAll("input");
    let areas = document.querySelectorAll("textarea");

    for (let i of inputs) {
        if (i.type == "radio") {
           i.checked = true;
        }
    }
    for (let a of areas) {
        a.value = ".";
    }
    for (let i of inputs) {
        if (i.value == "Enviar") {
            i.click();
            return;
        }
    }
}
marcarTodos();
