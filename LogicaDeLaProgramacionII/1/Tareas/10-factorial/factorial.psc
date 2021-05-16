Funcion f <- factorial (n)
	Si n = 0
		f <- 1
	SiNo
		f <- n*factorial(n-1)
	FinSi
Fin Funcion

Algoritmo main
	Escribir  "Ingrese un numero: "
	Leer n
	
	Escribir "El factorial de ", n, " es: ", factorial(n)
FinAlgoritmo
