// @ts-check
// import {describe} from 'mocha';
// import chai from 'chai';

// El ejercicio 1 no necesita. Y los 2 y 3 dependen de numeros aleatorios

mocha.setup('bdd');
mocha.checkLeaks();

describe('Ejercicio 4', () => {
    const prueba = [1, 2, 3, 4];
    it('Encontrar el valor si existe', () => {
        chai.assert.equal(buscarEnArreglo(prueba, 1), 0);
        chai.assert.equal(buscarEnArreglo(prueba, 2), 1);
        chai.assert.equal(buscarEnArreglo(prueba, 3), 2);
        chai.assert.equal(buscarEnArreglo(prueba, 4), 3);
    });
    it('Retornar -1 si no existe', () => {
        chai.assert.equal(buscarEnArreglo(prueba, 10), -1);
        chai.assert.equal(buscarEnArreglo(prueba, 13), -1);
        chai.assert.equal(buscarEnArreglo(prueba, 15), -1);
        chai.assert.equal(buscarEnArreglo(prueba, 40), -1);
    });
});

describe('Ejercicio 5', () => {
    const prueba = [1, 2, 3, 4];
    prueba.forEach((val, index) => {
        it("Da el valor correcto", () => {
            chai.assert.equal(arregloEn(prueba, index), val);
        })
    })
});

describe("Ejercicio 6", () => {
    const prueba = [1, 2, 3, 4];
    it("Ingresa correctamente el valor", () => {
        agregarAlFinal(prueba, 5);
        chai.assert.ok(prueba.every((val, index) => val === index + 1));
    })
})

describe("Ejercicio 7", () => {
    const prueba = [1, 2, 3, 4];
    it("Elimina el ultimo valor", () => {
        eliminarUltimo(prueba);
        chai.assert.equal(prueba.length, 3, "No disminuyo su tamaño");
        chai.assert.ok(prueba.every((val, index) => val === index + 1), 
                       "Los valores no son los esperados");
    })
})

describe("Ejercicio 8", () => {
    const prueba = [0, 1, 2, 3, 4];
    it("Elimina el primer valor", () => {
        eliminarPrimero(prueba);
        chai.assert.equal(prueba.length, 4, "No disminuyo su tamaño");
        chai.assert.ok(prueba.every((val, index) => val === index + 1), 
                       "Los valores no son los esperados");
    })
})

describe("Ejercicio 9", () => {
    const prueba = [1, 3, 4];
    it("Inserta el valor en la posicion esperada", () => {
        insertarEnArreglo(prueba, 1, 2);
        chai.assert.equal(prueba.length, 4, "No aumento su tamaño");
        chai.assert.ok(prueba.every((val, index) => val === index + 1), 
                       "Los valores no son los esperados");
    })
})

describe("Ejercicio 9", () => {
    const prueba = [1, 3, 4];
    it("Inserta el valor en la posicion esperada", () => {
        insertarEnArreglo(prueba, 1, 2);
        chai.assert.equal(prueba.length, 4, "No aumento su tamaño");
        chai.assert.ok(prueba.every((val, index) => val === index + 1), 
                       "Los valores no son los esperados");
    })
})

describe("Ejercicio 10", () => {
    const prueba = [1, 2, 3, 4];
    it("Formatea el array de la forma correcta", () => {
        chai.assert.ok(formatearArreglo(prueba), "(1, 2, 3, 4)");
    })
})

// El 11 requiere de prueba manual

mocha.run();
