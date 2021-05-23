const calcular_potencia = (base, potencia) => {
    if (potencia == 0) {
        return 1;
    }
    return base * calcular_potencia(base, potencia - 1);
}

const base = parseint(prompt("ingrese una base entera: "));
const potencia = parseint(prompt("ingrese una potencia entera:"));
alert(base + "^" + potencia + "=" + calcular_potencia(base, potencia));
