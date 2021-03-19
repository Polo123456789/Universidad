Algoritmo binario_a_decimal
	Definir base Como Entero;
	base <- 2
	Definir potencia Como Entero
	potencia <- 0
	Definir res Como Entero
	res <- 0
	
	Definir n Como Caracter
	Escribir "Ingrese un numero en binario:"
	Leer n
	
	Definir largo Como Entero
	largo <- Longitud(n)
	potencia <- largo - 1
	
	Mientras potencia >= 0
		res <- res + (ConvertirANumero(Subcadena(n, largo - potencia, largo - potencia))*base^potencia)
		potencia <- potencia - 1
	FinMientras
	Escribir "El numero en decimal es: ", res
FinAlgoritmo
