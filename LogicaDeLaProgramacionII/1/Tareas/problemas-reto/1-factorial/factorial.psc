Funcion f <- fibonnacci (n)
	Si n = 0
		f <- n
	SiNo
		Si n = 1
			f <- n
		SiNo
			f <- fibonnacci(n-1) + fibonnacci(n-2)
		FinSi
	FinSi
Fin Funcion

Algoritmo main
	Escribir "Ingrese un numero: "
	Leer n
	
	Escribir "El numero ", n, " de la secuencia de Fibonacci es: ", fibonnacci(n)
FinAlgoritmo
