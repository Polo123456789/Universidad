Algoritmo main
	Definir size Como Entero
	size <- 10
	
	Dimension numbers[size]
	
	Para i <- 1 Hasta 10 Con Paso 1
		numbers[i] <- azar(10) + 1
	FinPara
	
	Escribir "[" Sin Saltar
	Para i <- 1 Hasta 9 Con Paso 1
		Escribir numbers[i], ", " Sin Saltar
	FinPara
	Escribir numbers[10], "]"
FinAlgoritmo

