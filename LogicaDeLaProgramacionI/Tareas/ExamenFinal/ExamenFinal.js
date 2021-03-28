
function calcular_area() {
	let correr = true;
	let figura = "";
	let largo = 0;
	let alto = 0;
	while (correr) {
		figura = prompt("Seleccione una figura para calcular su area\n1. circulo\n2.\ rectangulo\n3. triangulo\nEscriba el nombre de la figura en minusculas, o (salir) para salir.");
		switch (figura) {
		case "circulo":
			largo = Number(prompt("Ingrese el radio del circulo"));
			alert("El area del circulo es: " + (Math.pow(largo,2))*Math.PI);
			break;
		case "rectangulo":
			largo = Number(prompt("Ingrese el largo de el rectangulo"));
			alto = Number(prompt("Ingrese el alto del rectangulo"));
			alert("El area del rectangulo es: " + largo*alto)
			break;
		case "triangulo":
			largo = Number(prompt("Ingrese el largo de el triagulo"));
			alto = Number(prompt("Ingrese el alto del triagulo"));
			alert("El area del triagulo es: " + largo*alto/2);
			break;
		case "salir":
			correr = false;
			break;
		default:
			alert("Seleccione una opcion valida");
		}
	}
}


calcular_area();
