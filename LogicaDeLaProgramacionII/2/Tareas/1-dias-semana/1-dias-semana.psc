Algoritmo main
	cantidad_dias <- 7
	Dimension dias_semana[cantidad_dias]
	
	dias_semana[1] <- "Domingo"
	dias_semana[2] <- "Lunes"
	dias_semana[3] <- "Martes"
	dias_semana[4] <- "Miercoles"
	dias_semana[5] <- "Jueves"
	dias_semana[6] <- "Viernes"
	dias_semana[7] <- "Sabado"
	
	entrada <- 0
	Mientras entrada <> -1
		Escribir "Ingrese un numero del 1 al 7 para obtener el dia equivalente en la semana (-1 para terminar)"
		Leer entrada
		
		Si entrada <> -1
			Si entrada > 7 O entrada < 1
				Escribir "Tiene que ser un numero entre el 1 y el 7"
			SiNo
				Escribir "El dia equivalente es: ", dias_semana[entrada]
			FinSi
		FinSi
	FinMientras
	
FinAlgoritmo
