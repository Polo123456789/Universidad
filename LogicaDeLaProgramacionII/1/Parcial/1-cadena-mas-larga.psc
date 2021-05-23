Funcion return <-  cadena_mas_larga(c1, c2)
	Si Longitud(c1) > Longitud(c2)
		return <- c1
	SiNo
		return <- c2
	FinSi
Fin Funcion

Algoritmo main
	Escribir "Ingrese una cadena: "
	Leer c1
	Escribir "Ingrese una cadena: "
	Leer c2
	
	
	Escribir "La cadena mas larga es: ", cadena_mas_larga(c1, c2)
FinAlgoritmo
