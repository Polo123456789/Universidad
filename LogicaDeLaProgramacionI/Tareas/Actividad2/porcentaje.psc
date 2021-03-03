Algoritmo Porcentaje
	Definir a, b Como Entero
	// Porcentaje parece ser una palabra reservada, asi que
	// recurrire a escribirlo con un error ortografico
	Definir porsentaje Como Real
	Definir finalizar Como Logico
	finalizar <- Falso
	
	Mientras !finalizar
		Escribir "Ingrese dos numeros (Deje el primer numero como 0 para terminar):"
		Leer a
		Leer b
		Si a != 0
			porsentaje <- 100 * b / a
			Escribir b, " representa el ", porsentaje, "% de ", a
		SiNo
			Escribir "Que tenga un buen dia"
			finalizar <- Verdadero
		FinSi
	FinMientras
FinAlgoritmo
