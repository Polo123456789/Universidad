// De aparecer 2 veces, se devolvera la ultima posicion
Funcion posicion <- posicion_en_arreglo (arreglo, cantidad, dato_a_buscar)
	posicion <- -1
	Para i <- 1 Hasta cantidad Con Paso 1
		Si arreglo[i] = dato_a_buscar
			posicion <- i
		FinSi
	FinPara
Fin Funcion

Funcion llenar_arrelgo(arreglo, cantidad)
	Para i <- 1 Hasta cantidad Con Paso 1
		arreglo[i] <- azar(100) + 1
	FinPara
Fin Funcion

Funcion mostrar_arreglo (arreglo, cantidad)
	Para i <- 1 Hasta cantidad - 1 Con Paso 1
		Escribir arreglo[i], ", " Sin Saltar
	FinPara
	Escribir arreglo[cantidad]
Fin Funcion

Algoritmo main
	cantidad_numeros <- 10
	Dimension arreglo[cantidad_numeros]
	
	llenar_arrelgo(arreglo, cantidad_numeros)
	mostrar_arreglo(arreglo, cantidad_numeros)
	
	Escribir "Ingreso:"
	Leer ingreso
	
	posicion <- posicion_en_arreglo(arreglo, cantidad_numeros, ingreso)
	Escribir "Respuesta: ", posicion
	

FinAlgoritmo
