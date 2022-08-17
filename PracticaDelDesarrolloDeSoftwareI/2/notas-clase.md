---
title: "Notas clase 2"
date: "16/08/22"
author: ""
---


Lo idóneo es que haya un usuario administrador, y con ese usuario administrador
agregar a otros.



El ranking que le parece a los usuarios es del primero al ultimo de todos los
usuarios de las personas. Para los administradores pueden ver los top 10
mejores y los top 10 peores.



La URL del web service recibe 2 parámetros:

* **nivel:** Numero entero del 1 al 10.
* **grupo:** El numero de grupo que somos.

URL: `http://ec2-44-203-35-246.compute-1.amazonaws.com/preguntas.php`



El avatar tiene que ser tridimensional y con animación. Luego de 24 horas de
haberse conectado el avatar cambia a mostrar algún descontento.



El nombre del proyecto es "Trivia Guatemala".



La aplicación tiene que tener colores atractivos.

Acuerdo: Tenemos que buscar los colores y mandarlos a mas tardar el día Jueves.



No existirán usuarios anónimos.



Enviar correo luego de cada 7 días en racha, y luego de cada 7 días sin
actividad.

El usuario puede desactivar las notificaciones.



Opcionalmente le gustaría que la implementación se pueda migrar fácilmente
a una versión móvil.



Compromiso: El profesor nos actualizara las instrucciones de la actividad.

La actividad es únicamente perfeccionar los requerimientos.



Los criterios de aceptación no tienen que definirse completamente.



Se tomara una política de password seguros:

* Longitud mínima de 6 dígitos
* Mínimo un numero
* Mínimo un carácter especial (`.,¿?!#$`)
* Mínimo una letra
* Máximo 12 caracteres
* Sin usar espacio
* Tiene que almacenarse en un hash

El password tiene que estar oculto.

Nombre y apellidos:

* Longitud: 2-30
* Sin números
* Se admiten tildes
* No se aceptan caracteres especiales

Correo:

* Tiene que tener una `@`
* Longitud 5-30
* Uno o varios `.`
* Puede llevar caracteres especiales
* Después del ultimo punto debe llevar por lo menos 2 caracteres

Fecha de nacimiento:

* 1-1-1922 hasta la fecha actual



Opcional puede haber un captcha



Las cuentas no se pueden eliminar



El correo tiene que tratar de enviarse siempre, no importa si rebota.
