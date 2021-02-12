Proyecto final
==============

**Links:**

* [Descripción del problema](descripcion-problema.md)
* [Explicacion del algoritmo](algoritmo.md)
* [Solucion a los 3 incisos](proyecto.js)
* [Solucion para puntos extra](puntos_extras.js)

Funcionamiento del programa
---------------------------

El funcionamiento del programa se puede resumir con la explicación en
[algoritmo.md](algoritmo.md), en su forma mas simple, sigue la siguiente
estructura:

~~~
1. Para cada uno de los factores:
    1.1 Leer de el usuario los datos necesarios para determinar el porcentaje de 
        recargo
    1.2 Calcular el recargo (porcentaje * precio base)
    1.3 Sumar el recargo al recargo total

2. Mostrar los resultados a los usuarios.
~~~

La solución en [proyecto.js](proyecto.js) sigue esa estructura, pero
"desenrollando" el loop. Va de uno en uno. 

La solución en [puntos_extras.js](puntos_extras.js), ya que tiene mas factores
a tomar en cuenta, la hice siendo mas fiel al loop. Así me ahorro repetir el
calculo y la suma, la parte principal del código se ve mas ordenada.

Partes a considerar
-------------------

Para el programa:

* Edad
* Cónyugue
* Hijos
* Propiedades (Extra)
* Salario (Extra)

A la hora de escribirlo, creo que lo único que hay que considerar es como se va
a estructurar.

Que se puede mejorar?
---------------------

Las cosas que pensaba que se podían mejorar ya las aplique al programa.

### Eliminación de var

Prácticamente el único cambio que hice fue eliminar `var` del código,
reemplazándolo con `let` y `const`. Haciendo eso me ahorro la posibilidad de
cometer algunos errores.

### Eliminación de constantes redundantes

~~~js
//Variables utiles 
//Precio base de la cotización, en quetzales, lo puede cambiar
const precio_base = 2000

//Valores de los recargos 
const edad_18 = 0.1 // 10%
const edad_25 = 0.2 // 20%
const edad_50 = 0.3 // 30%

const hijos = 0.2 // 20%
~~~

Elimine las constantes que trataban con la edad de el cónyugue, ya que eran
iguales a las de la edad de la persona.

### Pasar datos a números directamente

No me gusta para nada la notación húngara. Considero que solo hace el código
mas difícil de leer. Me gusta que el código sea explicito, que transmita tanta
información como sea posible, pero el colocar el tipo en la variable creo que
es demasiado verboso.

Considero que en lugar de:

~~~js
var edad = prompt("¿Cuantos años tiene? Ingrese solamente números ")
var edad_numero = parseInt(edad)
~~~

Se puede aprovechar que javascript no es estrictamente typeado y se puede hacer
esto:

~~~js
var edad = prompt("¿Cuantos años tiene? Ingrese solamente números ")
var edad = parseInt(edad)
~~~

Pero la verdad es que no hay necesidad de modificar la edad una vez la leímos,
así que considero la mejor alternativa la siguiente:

~~~js
const edad = parseInt(prompt("Cual es su edad?"));
~~~
