const size = 10;
const numbers = [];

for (let i = 0; i < size; i++) {
    numbers[i] = Math.floor(Math.random() * 10) + 1;
}

let res = "[";
for (let i = 0; i < size; i++) {
    res += numbers[i] + ", ";
}
res += numbers[9] + "]";

alert(res)
