"use strict";

const width = 3;
const heigth = 3;

const transpose_matrix = (m) => {
    let transposed_matrix = [];
    for (let i = 0; i < width; i++) {
        transposed_matrix[i] = [];
    }

    for (let row = 0; row < width; row++) {
        for (let column = 0; column < heigth; column++) {
            transposed_matrix[column][row] = m[row][column];
        }
    }
    return transposed_matrix;
}

const print_matrix = (m) => {
    let result = "";
    for (let row = 0; row < width; row++) {
        for (let column = 0; column < heigth; column++) {
            result += m[row][column] + " "
        }
        result += "\n";
    }
    return result;
}

const read_matrix = () => {
    const m = [];
    for (let row = 0; row < width; row++) {
        m[row] = [];
        for (let column = 0; column < heigth; column++) {
            m[row][column] = prompt();
        }
    }
    return m;
}

const matrix = read_matrix();

alert(print_matrix(transpose_matrix(matrix)));

//transpose_matrix(matrix, width, heigth, transposed_matrix);
//print_matrix(transposed_matrix, width, heigth);
