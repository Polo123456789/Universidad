Funcion imprimir_n(n)
	Para v<-1 Hasta n Con Paso 1 Hacer
		Imprimir "*" Sin Saltar
	Fin Para
	Imprimir ""
Fin Funcion

Funcion histograma (a, b, c, d, e)
	imprimir_n(a)
	imprimir_n(b)
	imprimir_n(c)
	imprimir_n(d)
	imprimir_n(e)
Fin Funcion

Algoritmo main
	Definir max_azar Como Entero
	max_azar <- 10
	Definir a, b, c, d ,e Como Entero
	
	// Segun lo que vi en internet la funcion se usa: azar(x) y da un
	// numero al azar entre 0 y x-1. Pero no importa que le coloque
	// como parametro me dice "Constante numerica no valida"
	//
	// 		a <- azar(max_azar) + 1
	// 		b <-.azar(max_azar) + 1
	// 		c <-.azar(max_azar) + 1
	// 		d <-.azar(max_azar) + 1
	// 		e <-.azar(max_azar) + 1
	// 		histograma(a, b , c, d, e)
	//
	// En la version de javascript si va con numeros al azar, pero
	// aqui no me deja
	
	histograma(5, 3, 2, 4, 1)
FinAlgoritmo
