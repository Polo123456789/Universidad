function decimal_a_binario() {
    let base = 2;
    let potencia = 0;
    let n = Number(prompt("Ingrese un numero:"));
    let res = "";
    let temp = "";
    let actual = 0;
    potencia = Math.round(Math.sqrt(n));

    while (potencia >= 0) {
        if (n != 0) {
            actual = Math.pow(base, potencia);
            if (n >= actual) {
                temp = "1";
                n = n - actual;
            } else {
                temp = "0";
            }
        } else {
            temp = "0";
        }
        res = res + temp;
        potencia = potencia - 1;
    }
    alert(`El resultado es: ${res}`);
}

decimal_a_binario();
