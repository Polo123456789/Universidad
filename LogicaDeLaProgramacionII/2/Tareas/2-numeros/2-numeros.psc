Algoritmo main
	cantidad_numeros <- 10
	Dimension nums[cantidad_numeros]
	
	Para i <- 1 Hasta 10 Con Paso 1 
		Escribir "Ingrese un numero: "
		Leer nums[i]
	FinPara
	
	Para i <- 1 Hasta 9 Con Paso 1 
		Escribir nums[i], ", " Sin Saltar
	FinPara
	Escribir nums[10]
FinAlgoritmo
