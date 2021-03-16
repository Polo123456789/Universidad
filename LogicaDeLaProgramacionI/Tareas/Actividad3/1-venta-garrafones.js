function mostrar_existencias(almacenados, vendidos) {
    alert(`Se han vendido ${vendidos} garrafones`);
    alert(`Se tienen aun ${almacenados} garrafones en existencia`);
}


function venta_garrafones() {
    const limite_por_venta = 5;
    const limite_garrafones = 5200;
    let garrafones_alamcenados = 0;

    do {
        garrafones_alamcenados = parseInt(prompt("Ingrese la cantidad de garrafones almacenados (Con un limite de 5200)"));
    } while (garrafones_alamcenados > limite_garrafones);

    let garrafones_vendidos = 0;
    let vendiendo = true;
    let garrafones_a_vender = 0;
    while (vendiendo) {
        if (garrafones_alamcenados != 0) {
            garrafones_a_vender = Number(prompt("Ingrese la candidad de garrafones a vender (0 para terminar el dia)"));
            if (garrafones_a_vender != 0) {
                if (garrafones_a_vender > limite_por_venta) {
                    alert(`Hay un limite de ${limite_por_venta} garafones por venta`);
                } else {
                    if (garrafones_a_vender > garrafones_alamcenados) {
                        alert(`Esta solicitando mas garrafones que los que tenemos disponibles (${garrafones_alamcenados} disponibles)`);
                    } else {
                        garrafones_vendidos = garrafones_vendidos + garrafones_a_vender;
                        garrafones_alamcenados = garrafones_alamcenados - garrafones_a_vender;
                        mostrar_existencias(garrafones_alamcenados, garrafones_vendidos);
                    }
                }
            } else {
                vendiendo = false;
            }
        } else {
            alert("Se han agotado las existencias");
            vendiendo = false;
        }
    }
    alert("---------- Resumen del dia ----------");
    mostrar_existencias(garrafones_alamcenados, garrafones_vendidos);
}

venta_garrafones();
