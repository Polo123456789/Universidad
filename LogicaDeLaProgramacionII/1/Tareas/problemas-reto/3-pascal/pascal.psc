// Triangulo de pascal
// ===================
// 
//          1
//         1 1
//        1 2 1
//       1 3 3 1
//      1 4 6 4 1
// 
// Y sigue
// 
// Calculo de una fila
// ===================
// 
// Los datos de la hilera n en el triangulo de pascal son los coeficientes de
// la siguiente ecuacion:
// 
//     (x + y)^n
// 
// Por ejemplo:
// 
//     (x + y)^0 = 1                | La hilera 0 es (1)
//     (x + y)^2 = x^2 + 2xy + y^2  | La hilera 2 es (1 2 1)
// 
// Una forma de calcular los exponentes es la siguiente para todo n natural:
// 
// 1. Empezamos con
// 
//         1(x^n)(y^0)
// 
//     Nuestro primer coeficiente es 1.
// 
// 2. El siguiente coeficiente se calcula usando la siguiente formula:
//     
//         C*X/I
// 
//     Donde:
//     * C es el ultimo coeficiente que obtuviste
//     * X es el ultimo exponente de x
//     * I es el numero del elemento por el que vamos
// 
//     Ya con el siguiente coeficiente disminuimos la potencia de x en
//     1 y aumentamos la de y en 1
// 
// 3. Repita el paso 2 hasta que el expoenente de y sea n
// 
// Como nota, la hilera n para un triangulo de tamaño m la cantidad de espacios
// antes de colocar la hilera para que mantenga la forma de triangulo es igual
// a m-n

Funcion  padding(n)
	Para i<-1 Hasta n Con Paso 1 Hacer
		Escribir " " Sin Saltar
	Fin Para
Fin Funcion

Funcion  imprimirHilera(n)
	
	exponenteX <- n
	exponenteY <- 0
	coeficiente <- 1
	
	Para i <- 1 Hasta n + 1 Con Paso 1 Hacer
		// Coeficiente actual
		Escribir coeficiente Sin Saltar
		padding(1)
		
		// Calculamos el siguiete
		coeficiente <- (coeficiente*exponenteX)/i
		exponenteX <- exponenteX - 1
		exponenteY <- exponenteY + 1
	FinPara
	
	Escribir "" // Para tener el salto al final
Fin Funcion

Algoritmo main
	Escribir "Cuantas hileras quiere del triangulo de pascal?"
	Leer cantidadHileras
	
	Para i<-0 Hasta cantidadHileras - 1 Con Paso 1 Hacer
		padding(cantidadHileras - i)
		imprimirHilera(i)
	FinPara
FinAlgoritmo
































