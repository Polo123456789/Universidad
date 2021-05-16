Funcion suma <- suma_primeros_n (n)
	suma = 0
	Para i<-1 Hasta n Con Paso 1 Hacer
		suma <- suma + i
	Fin Para
	
Fin Funcion

Algoritmo main
	Escribir "Hasta que numero se tiene que realizar la suma?"
	Leer n
	
	Escribir "La suma de los numeros de 1 hasta el ", n, " es ", suma_primeros_n(n)
FinAlgoritmo
