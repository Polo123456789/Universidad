Algoritmo caluladora
	Definir a Como Real
	Escribir "Ingrese el primer numero"
	Leer a
	
	Definir operacion Como Caracter
	Escribir "Que operacion quiere realizar?"
	Escribir "     * sum  -> suma"
	Escribir "     * rest -> resta"
	Escribir "     * mult -> multiplicacion"
	Escribir "     * div  -> divicion"
	Leer operacion
	
	Definir b Como Real
	Escribir "Ingrese el segundo numero"
	Leer b
	
	Definir resultado Como Real
	Segun operacion Hacer
		"sum":
			resultado <- a + b
		"rest":
			resultado <- a - b
		"mult":
			resultado <- a * b
		"div":
			resultado <- a / b
		De Otro Modo:
			Escribir "Operacion invalida"
	Fin Segun
	
	Escribir "El resultado es: ", resultado
FinAlgoritmo
