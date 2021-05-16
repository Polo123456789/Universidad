Funcion kelvin <- a_kelvin (celsius)
	kelvin <- celsius + 273.15
Fin Funcion

Funcion fahrenheit <- a_fahrenheit (celsius)
	fahrenheit <- (celsius*1.8) + 32
Fin Funcion

Algoritmo main
	Escribir "Ingrese una temperatura en celsius"
	Leer celsius
	
	Escribir "A que lo quiere convertir? (f para fahrenheit, k para kelvin)"
	Leer op
	
	Segun op
		"f":
			Escribir "El equivalente en Fahrenheit es de ", a_fahrenheit(celsius)
		"k":
			Escribir "El equivalente en Kelvin es de ", a_kelvin(celsius)
		De Otro Modo:
			Escribir "Tiene que elegir uno entre k y f"
	FinSegun
FinAlgoritmo
