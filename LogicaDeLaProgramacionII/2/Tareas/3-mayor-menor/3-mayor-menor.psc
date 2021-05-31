Algoritmo main
	cantidad_numeros <- 10
	
	Dimension nums[cantidad_numeros]
	
	Para i<-1 Hasta cantidad_numeros Con Paso 1
		Escribir "Ingrese un numero: "
		Leer nums[i]
	FinPara
	
	max <- nums[1]
	min <- nums[1]
	
	Para i<-1 Hasta cantidad_numeros Con Paso 1
		Si nums[i] < min
			min <- nums[i]
		FinSi
		Si nums[i] > max
			max <- nums[i]
		FinSi
	FinPara
	
	Escribir "Mayor: ", max
	Escribir "Menor: ", min
FinAlgoritmo
