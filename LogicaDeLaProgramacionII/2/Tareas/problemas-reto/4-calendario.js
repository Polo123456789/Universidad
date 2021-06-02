const meses = [
    "Enero",
    "Febrero",
    "Marzo",
    "Abril",
    "Mayo",
    "Junio",
    "Julio",
    "Agosto",
    "Septiembre",
    "Octubre",
    "Noviembre",
    "Diciembre",
];

// https://stackoverflow.com/questions/1184334/get-number-days-in-a-specified-month-using-javascript
const today = new Date();
const days_in_month = (month, year) => new Date(year, month, 0).getDate();
const days = days_in_month(today.getMonth() + 1, today.getFullYear());

let result = `${meses[today.getMonth()]} ${today.getFullYear()}\n`;

const columns = 7;
const rows = Math.floor(days / columns) + 1;
const padding = (rows * columns) - days;

for (let i = 0; i < columns * rows; i++) {
    if (i < padding) {
        result += "X ";
    } else {
        result += `${i - padding + 1} `;
    }

    if ((i + 1) % 7 === 0) {
        result += "\n";
    }
}

alert(result);
