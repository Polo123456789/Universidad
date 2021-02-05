---
author: "Pablo Sanchez"
date: "28/01/2021"
---

Instrucciones
=============

Escriba en una página la diferencia entre if, if… else, if… else if… else
y switch case y escriba un ejemplo de cada uno. Utilice ejemplos de su vida
diaria. 

if
==

El `if` tiene la siguiente estructura:

~~~js
    if (condicion)
        // Instrucción a ejecutar si "condicion" es verdadera
~~~

O si quiere ejecutar mas de una instrucción puede hacerlo de la siguiente
manera:

~~~js
    if (condicion) {
        // Serie
        // de
        // instrucciones
        // para
        // ejecutar
    }
~~~

Ejemplo
-------

~~~js
    if (son_las_2())
        comer();
~~~

if... else
==========

También puede dar una instrucción a ejecutar en caso de que la condición sea
falsa.

~~~js
    if (condicion)
        // Instrucción a ejecutar si "condicion" es verdadera
    else
        // Instrucción a ejecutar si "condicion" es falsa
~~~

Ejemplo
-------

~~~js
    if (es_de_dia())
        trabajar();
    else
        dormir();
~~~

if... else if... else
=====================

En ciertos casos podemos necesitar revisar mas de una condición. Y como el `if`
también es una instrucción, lo que hacemos es concatenar varios `if` de la
siguiente manera:

~~~js
    if (condicion)
        // Instrucción a ejecutar si "condicion" es verdadera
    else
        if (condicion2)
            // Instrucción a ejecutar si "condicion2" es verdadera
        else
            if (condicion3)
                // Instrucción a ejecutar si "condicion3" es verdadera
            else
                // ...
~~~

Lo que podemos resumir de la siguiente forma para no indentar tanto el código:

~~~js
    if (condicion)
        // Instrucción a ejecutar si "condicion" es verdadera

    else if (condicion2)
        // Instrucción a ejecutar si "condicion2" es verdadera

    else if (condicion3)
        // Instrucción a ejecutar si "condicion3" es verdadera

    else
        // ...
~~~

Ejemplo
-------

~~~js
    if (tengo_tarea())
        hacer_tareas();

    else if (la_casa_esta_sucia()) 
        limpiar_la_casa();

    else
        descanzar();
~~~

switch case
===========

En otros casos, puede que necesitemos comprobar una variable contra varios
valores, como en el siguiente caso:

~~~js
    if (color === "rojo")
        // Hacer algo

    else if (color === "verde")
        // Hacer algo

    else if (color === "azul")
        // Hacer algo

    else if (color === "negro")
        // Hacer algo

    else if (color === "amarillo")
        // Hacer algo

    else
        // Hacer algo
~~~

En este caso lo que podemos hacer es convertirlo en un switch:

~~~js
    switch (color) {
    case "rojo":
        // Hacer algo
        break;
    
    case "verde":
        // Hacer algo
        break;
    
    case "azul":
        // Hacer algo
        break;
    
    case "negro":
        // Hacer algo
        break;
    
    case "amarillo":
        // Hacer algo
        break;
    
    default:
        // Hacer algo
        break;
    }
~~~

Que de hecho, si hay una cantidad considerable de casos, el `switch` es mas
optimo que la serie de `if`s[^1].

Ejemplo
-------

~~~js
    switch (estado_salud) {
    case "dolor de cabeza":
        tomar_panadol();
        break;
    
    case "dolor de estomago":
        tomar_ulcogant();
        break;
    
    case "dolor del cuerpo":
        aplicar_cofal();
        break;
    
    default:
        vivir_normalmente();
        break;
~~~

[^1]: Fuente: https://www.oreilly.com/library/view/high-performance-javascript/9781449382308/ch04.html#if-else_versus_switch
