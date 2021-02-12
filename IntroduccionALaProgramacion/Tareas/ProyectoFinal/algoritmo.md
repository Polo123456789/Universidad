Instrucciones
=============

Diseñe un algoritmo en base al procedimiento presentado, enumere cada acción
como un paso e indique las posibles decisiones que se pueden tomar. 

Algoritmo
=========

~~~
1. Para cada uno de los factores:
    1.1 Leer de el usuario los datos necesarios para determinar el porcentaje de 
        recargo
    1.2 Calcular el recargo (porcentaje * precio base)
    1.3 Sumar el recargo al recargo total

2. Mostrar los resultados a los usuarios.
~~~

Porcentaje por factores
-----------------------

Las posibles decisiones a tomar, usando la estructura que se tiene arriba, es
unicamente el porcentaje por cada factor. Los porcentajes serian los
siguientes:

### Edad

| Edad  | Porcentaje |
|-------|------------|
| 18-24 | 10%        |
| 25-49 | 20%        |
| 50+   | 30%        |

### Cónyugue

De tenerlo, el porcentaje dependerá de la edad, calculado de la misma manera
que para la edad de el asegurado.

### Hijos

`20%` por cada hijo.
