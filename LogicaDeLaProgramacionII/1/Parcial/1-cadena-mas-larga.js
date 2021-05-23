const cadena_mas_larga = (c1, c2) => {
    if (c1.length > c2.length) {
        return c1;
    } else {
        return c2;
    }
}

const c1 = prompt("Ingrese una cadena: ");
const c2 = prompt("Ingrese una cadena: ");
alert("La cadena mas larga es: " + cadena_mas_larga(c1, c2));

