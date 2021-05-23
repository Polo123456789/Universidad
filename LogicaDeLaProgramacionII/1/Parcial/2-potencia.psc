Funcion return <- calcular_potencia (base, potencia)
	Si potencia = 0
		return <- 1
	SiNo
		return <- base * calcular_potencia(base, potencia - 1)
	FinSi
Fin Funcion

Algoritmo main
	Escribir "Ingrese una base entera: "
	Leer base
	
	Escribir "Ingrese una potencia entera:"
	Leer potencia
	
	Escribir base, "^", potencia, "=", calcular_potencia(base, potencia)
FinAlgoritmo
