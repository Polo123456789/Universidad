---
title: "Teoria de Conjuntos"
date: "18/1/2020"
toc: true
---

Elementos
=========

* Un conjunto es un ente no definido. En el curso se le tratara como una
  agrupación o colección de elementos.

* Los conjuntos los nombramos con letras mayúsculas latinas. Y no es necesario
  que todos los elementos tengan algo en común. 

* Para indicar que un elemento pertenece a un conjunto usamos: $a \in A$.
  Ejemplo: $Guatemala \in America$

* Para indicar que no pertenece al conjunto usamos: $a \notin A$. Ejemplo: $8
  \notin Alfabeto$, $a \notin Consonantes$.

* Un conjunto tiene que estar bien determinado. Esto significa que la expresión
  "el elemento $a$ pertenece al conjunto $A$" tiene que ser verdadera o falsa,
  no puede ser ambigua. Por ejemplo, un conjunto que no esta bien definido
  serian los productos baratos del supermercado. Aquí la ambigüedad esta en que
  es "barato"?

* En un conjunto los elementos no se repiten. Si aparecen mas de una vez los
  contamos solo una. Entonces las letras de Galileo serian: $\{G, a, l, i, e,
  o\}$. Las letras de coco serian: $\{c, o\}$.

* Los elementos no tienen que estar en un orden especifico

Notación
--------

Para separar los conjuntos los separaremos en:

1. Finitos: Los que podemos contar
2. Infinitos: Los que no podemos contar

### Enumerativa o Tabular

Los elementos del un conjunto se ponen entre llaves, separados por comas.

$$
    A = \{\pi, 1, @, +\}
$$

### Descriptiva o por Comprensión

En la que se da una descripción de los elementos.

$$
    A = \{Ciudadanos \, Guatemaltecos\}
$$

Este $B = \{x/x$ es letra del alfabeto español$\}$ se lee como: "x
tal que x pertenece al alfabeto español".

Subconjuntos
------------

$\subset$ significa que los elementos de uno están contenidos en el otro.

Ejemplo:

$$
    A = \{a, b, c, d, e\}
$$
$$
    B = \{a, e\}
$$
$$
    C = \{a, b, c, d, e\}
$$

Aquí podemos afirmar que $B \subset A$. De forma equivalente $A \supset B$. 

Si nota, todos los elementos de $A$ están en $C$, por lo que podemos decir que:
$C$ esta contenido o es igual a $A$. O matemáticamente $C \subseteq A$. Se puede
afirmar que si $C \subseteq A$ y $C \supseteq A$ entonces $A=C$.

Conjuntos especiales
--------------------

### Unitario

El que tiene un solo elemento: $A=\{2\}$

### Par

El que tiene un dos elementos: $A=\{2, 3\}$

### Vacio

El que no tiene elementos: $A=\{\}$ o $A=\Phi$

Conjunto Potencia
-----------------

Es la cantidad de subconjuntos que se pueden crear de un conjunto.

Se define de la siguiente manera:

$$
    P(A)=2^n
$$

Donde:

* $A$ es el conjunto
* $n$ es la cantidad de elementos de $A$

Diagramas de Venn
-----------------

Es una representación gráfica de los elementos, conteniendo los elementos en
figuras geométricas.

![](https://upload.wikimedia.org/wikipedia/commons/6/6f/Diagrama_de_Venn_1b.png)

Álgebra de conjuntos
====================

Unión
-----

Son todos los elementos de ambos conjuntos. Símbolo: $\cup$

Intersección
------------

Son los elementos comunes entre ambos conjuntos. Símbolo: $\cap$

Diferencia
----------

$A - B$, son todos los elementos de $A$ que no estén en $B$.

Complemento
-----------

$A'$ o también escrito $\overline{A}$ es lo que le falta a $A$ para ser el
conjunto universo ($U$).

Diferencia Simétrica
--------------------

$A \vartriangle B$ son todos los elementos que $A$ y $B$ no comparten. También
se puede ver como $(A-B) \cup (B-A)$
