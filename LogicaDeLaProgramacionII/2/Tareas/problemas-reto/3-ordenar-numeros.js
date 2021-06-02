const size = 10;
const numbers = [];

for (let i = 0; i < size; i++) {
    numbers[i] = parseInt(prompt("Ingrese un numero"));
}

// numbers.sort((a, b) => a - b);

let had_changes = true;
while (had_changes) {
    had_changes = false;
    for (let i = 0; i < size - 1; i++) {
        if (numbers[i] > numbers[i + 1]) {
            const temp = numbers[i];
            numbers[i] = numbers[i + 1];
            numbers[i + 1] = temp;
            had_changes = true
        }
    }
}

alert(numbers);
