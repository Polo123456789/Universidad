function poblacion_por_pais(pais) {
    let poblacion;
    switch (pais) {
        case "Guatemala":
            poblacion = 17500000;
            break;
        case "Belice":
            poblacion = 383071;
            break;
        case "Costa Rica":
            poblacion = 5000000;
            break;
        case "El Salvador":
            poblacion = 6421000;
            break;
        case "Honduras":
            poblacion = 9588000;
            break;
        case "Nicaragua":
            poblacion = 6466000;
            break;
        case "Panama":
            poblacion = 4177000;
            break;
        default:
            poblacion = 0;
    }
    return poblacion;
}

function idioma_por_pais(pais) {
    let idioma;
    switch (pais) {
        case "Guatemala":
            idioma = "castellano, garifuna, xinka, y lenguas mayas";
            break;
        case "Belice":
            idioma = "ingles y espa�ol";
            break;
        case "Costa Rica":
            idioma = "espa�ol";
            break;
        case "El Salvador":
            idioma = "espa�ol y nahuatl";
            break;
        case "Honduras":
            idioma = "espa�ol";
            break;
        case "Nicaragua":
            idioma = "espa�ol";
            break;
        case "Panama":
            idioma = "espa�ol, ng�be, bugl�, kuna, ember�, wounaan, naso tjerdi y bri bri";
            break;
        default:
            idioma = "Ninguno";
    }
    return idioma;
}

function capital_por_pais(pais) {
    let capital;
    switch (pais) {
        case "Guatemala":
            capital = "Guatemala";
            break;
        case "Belice":
            capital = "Belmopan";
            break;
        case "Costa Rica":
            capital = "San Jose";
            break;
        case "El Salvador":
            capital = "San Salvador";
            break;
        case "Honduras":
            capital = "Tegucigalpa";
            break;
        case "Nicaragua":
            capital = "Managua";
            break;
        case "Panama":
            capital = "Panama";
            break;
        default:
            capital = "Ninguna";
    }
    return capital;
}

function libro_virtual() {
    let usando_el_libro = true;
    let pais = "";
    let poblacion = 0;
    let continuar = "";

    while (usando_el_libro) {
        pais = prompt("De que pais de centroamerica quiere obtener la informacion?");
        poblacion = poblacion_por_pais(pais);

        if (poblacion != 0) {
            alert(`La poblacion de ${pais} es: ${poblacion}`);
            alert(`En ${pais} se habla: ${idioma_por_pais(pais)}`);
            alert(`La capital de ${pais} es: ${capital_por_pais(pais)}`);
            
            continuar = prompt("Descea continuar? [si/no]");
            if (continuar == "no" || continuar == "No" || continuar == "n") {
                usando_el_libro = false;
            }
        } else {
            alert("Ese no es un pais de centro america. Recuerde que tiene que capitalizar los nombres");
        }
    }
    alert("Muchas gracias por usar el libro virtual SDT. Que tenga un buen dia");
}
libro_virtual();

