Funcion mostrar_existencias (almacenados, vendidos)
	Escribir "Se han vendido ", vendidos, " garrafones"
	Escribir "Se tienen aun ", almacenados, " garrafones en existencia"
Fin Funcion

Algoritmo venta_garrafones
	Definir limite_por_venta Como Entero
	limite_por_venta = 5
	Definir limite_garrafones Como Entero
	limite_garrafones = 5200
	
	Definir garrafones_alamcenados Como Entero
	Hacer
		Escribir "Ingrese la cantidad de garrafones almacenados (Con un limite de 5200)"
		Leer garrafones_alamcenados
	Hasta Que garrafones_alamcenados <= limite_garrafones
	
	Definir garrafones_vendidos Como Entero
	garrafones_vendidos = 0
	
	Definir vendiendo Como Logico
	vendiendo = Verdadero
	Definir garrafones_a_vender Como Entero
	garrafones_a_vender = 0
	Mientras vendiendo
		si garrafones_alamcenados <> 0
			Escribir "Ingrese la candidad de garrafones a vender (0 para terminar el dia)"
			Leer garrafones_a_vender
			si garrafones_a_vender <> 0
				Si garrafones_a_vender > limite_por_venta
					Escribir "Hay un limite de ", limite_por_venta, " garafones por venta"
				SiNo
					Si garrafones_a_vender > garrafones_alamcenados
						Escribir "Esta solicitando mas garrafones que los que tenemos disponibles (", garrafones_alamcenados, " disponibles)"
					SiNo
						garrafones_vendidos <- garrafones_vendidos + garrafones_a_vender
						garrafones_alamcenados <- garrafones_alamcenados - garrafones_a_vender
						mostrar_existencias(garrafones_alamcenados, garrafones_vendidos)
					FinSi
				FinSi
			SiNo
				vendiendo <- Falso
			FinSi
		SiNo
			Escribir "Se han agotado las existencias"
			vendiendo <- Falso
		FinSi
	FinMientras
	
	Escribir "---------- Resumen del dia ----------"
	mostrar_existencias(garrafones_alamcenados, garrafones_vendidos)
FinAlgoritmo
