Funcion a <- ackermann (m, n)
	Si m = 0
		a <- n + 1
	SiNo
		Si m > 0 Y n = 0
			a <- ackermann(m-1, 1)
		SiNo
			Si m > 0 Y n > 0
				a <- ackermann(m-1, ackermann(m, n-1))
			FinSi
		FinSi
	FinSi
Fin Funcion

Algoritmo main
	Escribir "Ingrese dos numeros (m y n)"
	Leer m
	Leer n
	
	Escribir "ackerman(", m, ", ", n, ") = ", ackermann(m, n)
FinAlgoritmo
