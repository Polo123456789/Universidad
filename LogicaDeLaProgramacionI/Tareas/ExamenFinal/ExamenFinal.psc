Algoritmo calcular_area
	Definir correr Como Logico
	correr = Verdadero
	Definir figura Como Caracter
	Definir largo, alto Como Real
	
	Mientras correr
		Escribir "Seleccione una figura para calcular su area"
		Escribir "1. circulo"
		Escribir "2. rectangulo"
		Escribir "3. triangulo"
		Escribir "Escriba el nombre de la figura en minusculas, o (salir) para salir."
		Leer figura
		
		Segun figura Hacer
			"circulo":
				Escribir "Ingrese el radio del circulo"
				Leer largo
				Escribir "El area del circulo es: ", (largo^2)*PI
			"rectangulo":
				Escribir "Ingrese el largo de el rectangulo"
				Leer largo
				Escribir "Ingrese el alto del rectangulo"
				Leer alto
				Escribir "El area del rectangulo es: ", largo*alto
			"triangulo":
				Escribir "Ingrese el largo de el triagulo"
				Leer largo
				Escribir "Ingrese el alto del triagulo"
				Leer alto
				Escribir "El area del triagulo es: ", largo*alto/2
			"salir":
				correr = Falso
			De Otro Modo:
				Escribir "Seleccione una opcion valida"
		Fin Segun
	FinMientras
FinAlgoritmo
