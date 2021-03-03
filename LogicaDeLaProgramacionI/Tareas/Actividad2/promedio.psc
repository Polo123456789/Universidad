Algoritmo promedio
	Definir ingresado Como Entero
	Definir suma Como Entero; suma <- 0
	Definir cantidad Como Entero; cantidad <- 0
	Definir finalizar Como Logico; finalizar <- Falso
	
	Escribir "Calculadora de promedios."
	Escribir "Ingrese tantos numeros enteros como quiera. Escriba un 0 para finalizar"
	
	Repetir
		Leer ingresado
		Si ingresado = 0
			finalizar = Verdadero
		SiNo
			suma     <- suma + ingresado
			cantidad <- cantidad + 1
		FinSi
	Hasta Que finalizar
	
	// Parece que promedio es una palabra reservada, asi que usare
	// media
	Definir media Como Entero
	media <- suma / cantidad
	
	Escribir "La suma de los numeros es: ", suma
	Escribir "El promedio de los numeros es: ", media
FinAlgoritmo
