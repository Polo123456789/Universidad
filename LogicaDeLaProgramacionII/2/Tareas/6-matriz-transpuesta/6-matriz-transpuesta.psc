Funcion transpose_matrix (m, width, heigth, transposed_matrix)
	Para row <- 1 Hasta width Con Paso 1
		Para column <- 1 Hasta heigth Con Paso 1
			transposed_matrix[(column-1) * width + row] <- m[(row-1) * width + column]
		FinPara
		Escribir ""
	FinPara
Fin Funcion

Funcion  print_matrix(m, width, heigth)
	Para row <- 1 Hasta width Con Paso 1
		Para column <- 1 Hasta heigth Con Paso 1
			Escribir m[(row-1) * width + column], " " Sin Saltar
		FinPara
		Escribir ""
	FinPara
Fin Funcion

Funcion  read_matrix(m, width, heigth)
	Para row <- 1 Hasta width Con Paso 1
		Para column <- 1 Hasta heigth Con Paso 1
			Leer m[(row-1) * width + column]
		FinPara
	FinPara
Fin Funcion

Algoritmo main
	width <- 3
	heigth <- 3
	
	// matrix[heigth][width] no funciona
	Dimension matrix[width * heigth]
	Dimension transposed_matrix[width * heigth]
	
	// matrix[row][column] pasa a ser matrix[(row-1) * width + column]
	// Tiene que ser (row-1) porque los indices empiezan en 1

	read_matrix(matrix, width, heigth)
	
	transpose_matrix(matrix, width, heigth, transposed_matrix)
	
	print_matrix(transposed_matrix, width, heigth)
FinAlgoritmo
