Funcion r <- romano_por_valor (n)
	Segun n Hacer
		500:
			r<-"D"
		400:
			r <- "CD"
		100:
			r <- "C"
		90:
			r <- "XC"
		50:
			r <- "L"
		40:
			r <- "XL"
		10:
			r <- "X"
		9:
			r <- "IX"
		5:
			r <- "V"
		4:
			r <- "IV"
		1:
			r <- "I"
		De Otro Modo:
			r <- "`n` no se traduce directamente a un numero romano"
	Fin Segun
Fin Funcion

Funcion romano <- a_romano (n)
	// Si los vemos como una lista del mayor al menor serian:
	//
	// D: 500
	// CD: 400
	// C: 100
	// XC: 90
	// L: 50
	// XL: 40
	// X: 10
	// IX: 9
	// V: 5
	// IV: 4
	// I: 1
	//
	// Entonces se puede comparar si el numero es mayor a su equivalente en
	// romano, si lo es, añadimos a la solucion su version romana y le restamos
	// su valor.
	
	Dimension valores[11]
	valores[1] <- 500
	valores[2] <- 400
	valores[3] <- 100
	valores[4] <- 90
	valores[5] <- 50
	valores[6] <- 40
	valores[7] <- 10
	valores[8] <- 9
	valores[9] <- 5
	valores[10] <- 4
	valores[11] <- 1
	
	
	romano <- ""
	
	Para i<-1 Hasta 11 Con Paso 1 Hacer
		Mientras  valores[i] <= n
			n <- n - valores[i]
			romano <- romano + romano_por_valor(valores[i])
		FinMientras
		
	Fin Para
	
Fin Funcion

Funcion azar_a_romano()
	max_azar <- 500
	n <- azar(max_azar)
	Escribir "Numero ", n, " a romano es: ", a_romano(n)
	
FinFuncion

Algoritmo main
	azar_a_romano()
	azar_a_romano()
	azar_a_romano()
FinAlgoritmo
