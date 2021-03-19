function binario_a_decimal() {
    let base = 2;
    let potencia = 0;
    let res = 0;
    let n = prompt("Ingrese un numero en binario:");
    let largo = n.length;
    potencia = largo - 1;

    while (potencia >= 0) {
        res = res + (Number(n[largo - potencia - 1]) * Math.pow(base, potencia));
        potencia = potencia - 1;
    }
    alert(`El numero en decimal es: ${res}`);
}
binario_a_decimal();
