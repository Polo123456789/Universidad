Algoritmo main
	Definir size Como Entero
	size <- 10
	
	Dimension numbers[size]
	
	Para i <- 1 Hasta 10 Con Paso 1
		Escribir "Ingrese el numero ", i, ":"
		Leer numbers[i]
	FinPara
	
	Definir sum Como Entero
	sum <- 0
	
	Escribir "[ " Sin Saltar
	Para i <- 1 Hasta 10 Con Paso 1
		Escribir numbers[i], " " Sin Saltar
		sum <- sum + numbers[i]
	FinPara
	Escribir " ]"
	
	Escribir "La suma de los valores es: ", sum
FinAlgoritmo
