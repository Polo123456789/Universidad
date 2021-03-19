Algoritmo decimal_a_binario
	Definir base Como Entero;
	base = 2;
	Definir potencia Como Entero;
	potencia = 0;
	
	Escribir "Ingrese un numero:"
	Definir n Como Entero;
	Leer n;
	
	Definir res, temp Como Caracter
	res <- ""
	
	Definir actual Como Entero
	potencia = redon(rc(n))
	
	Mientras potencia >= 0
		si n <> 0
			actual <- base^potencia
			si n >= actual
				temp <- "1"
				n <- n - actual
			SiNo
				temp <- "0"
			FinSi
		SiNo
			temp <- "0"
		FinSi
		res <- res + temp
		potencia <- potencia - 1
	FinMientras
	
	Escribir "El resultado es: ", res
FinAlgoritmo
