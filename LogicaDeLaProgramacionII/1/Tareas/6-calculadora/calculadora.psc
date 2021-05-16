Funcion res <- suma (a, b)
	res <- a + b
Fin Funcion

Funcion res <- resta (a, b)
	res <- a - b
Fin Funcion

Funcion res <- multiplicacion (a, b)
	res <- a * b
Fin Funcion

Funcion res <- divicion (a, b)
	Si b <> 0 Entonces
		res <- a / b
	SiNo
		Escribir "No se puede dividir por 0"
		res <- 0
	Fin Si
Fin Funcion

Algoritmo main
	Escribir  "Ingrese un numero"
	Leer a
	
	Escribir "Ingrese otro numero"
	Leer b
	
	Escribir "Ingrese una operacion (+, -, *, /)"
	Leer op
	
	Segun op Hacer
		"+":
			res <- suma(a, b)
		"-":
			res <- resta(a, b)
		"*":
			res <- multiplicacion(a, b)
		"/":
			res <- divicion(a, b)
		De Otro Modo:
			Escribir "Esa no es una operacion valida"
	Fin Segun
	
	Escribir "El resultado de ", a, op, b, " es ", res
FinAlgoritmo
