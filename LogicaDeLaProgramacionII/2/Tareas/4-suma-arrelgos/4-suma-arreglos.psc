Funcion mostrar_arreglo (arreglo, cantidad)
	Para i <- 1 Hasta cantidad - 1 Con Paso 1
		Escribir arreglo[i], ", " Sin Saltar
	FinPara
	Escribir arreglo[cantidad]
Fin Funcion

Funcion llenar_arrelgo(arreglo, cantidad)
	Para i <- 1 Hasta cantidad Con Paso 1
		arreglo[i] <- azar(100) + 1
	FinPara
Fin Funcion

Algoritmo main
	cantidad_numeros <- 10
	Dimension a1[cantidad_numeros]
	Dimension a2[cantidad_numeros]
	Dimension resultado[cantidad_numeros]
	
	llenar_arrelgo(a1, cantidad_numeros)
	llenar_arrelgo(a2, cantidad_numeros)
	
	Para i <- 1 Hasta cantidad_numeros Con Paso 1
		resultado[i] <- a1[i] + a2[i]
	FinPara
	
	mostrar_arreglo(a1, cantidad_numeros)
	mostrar_arreglo(a2, cantidad_numeros)
	mostrar_arreglo(resultado, cantidad_numeros)
FinAlgoritmo
