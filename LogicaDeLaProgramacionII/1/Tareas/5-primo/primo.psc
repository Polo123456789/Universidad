Funcion primo <- es_primo(n)
	primo <- Verdadero
	limite_superior = redon(rc(n))
	Para i<-2 Hasta limite_superior Con Paso 1 Hacer
		Si n MOD i = 0 Entonces
			primo <- Falso
		Fin Si
	Fin Para
Fin Funcion

Algoritmo test
	Si es_primo(7)  Y es_primo(11) Y no es_primo(4) Y no es_primo(10) Y es_primo(97)
		
	SiNo
		Escribir "Error"
	FinSi
FinAlgoritmo
