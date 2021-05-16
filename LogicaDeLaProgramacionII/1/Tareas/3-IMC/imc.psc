Funcion indice <- imc (peso, altura)
	indice <- 703 * peso / (altura*altura)
Fin Funcion

Algoritmo main
	Escribir "Ingrese su altura"
	Leer altura
	Escribir "Ingrese su peso"
	Leer peso
	
	Escribir "Su indice de masa corporal es: ", imc(peso, altura)
FinAlgoritmo
