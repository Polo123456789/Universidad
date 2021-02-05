---
title: "Calculo Proposicional"
date: "2/02/2021"
toc: true
---

Lógica
======

Es el estudio del razonamiento. Se refiere específicamente a si el razonamiento
es correcto.

Elementos
---------

### Proposición

Toda expresión que su significado puede ser verdadero o falso.

**Ejemplo:** Todo Guatemalteco es centroamericano.

### Proposición simple o atómica

Es aquella que no tiene conectores lógicos (Se representan usando letras).

**Ejemplos:**

* p
* q
* r
* s

### Conectivos lógicos

| Conectivo         | Símbolo           | Significado  |
|-------------------|-------------------|--------------|
| Disyuncion        | $\lor$            | o            |
| Conjuncion        | $\land$           | y            |
| Implicacion       | $\implies$        | entonces     |
| Doble implicacion | $\Leftrightarrow$ | si y solo si |
| Negacion          | $\lnot$           | no           |

### Proposición Compuesta

Son proposiciones atómicas unidas por conectores lógicos.

**Ejemplos:** $p \land q$, $s \Leftrightarrow r$.

### Tablas de verdad

Esta muestra todas las posibles combinaciones de las proposiciones simples
o compuestas. Para saber la cantidad de filas, se calcula con $2^n$, donde $n$
es la cantidad de proposiciones simples.

**Ejemplo:**

| p   | q   |
|-----|-----|
| $V$ | $V$ |
| $V$ | $F$ |
| $F$ | $V$ |
| $F$ | $F$ |

#### Conjunción

| p   | q   | p $\land$ q |
|-----|-----|-------------|
| $V$ | $V$ | $V$         |
| $V$ | $F$ | $F$         |
| $F$ | $V$ | $F$         |
| $F$ | $F$ | $F$         |

#### Disyunción

| p   | q   | p $\lor$ q |
|-----|-----|------------|
| $V$ | $V$ | $V$        |
| $V$ | $F$ | $V$        |
| $F$ | $V$ | $V$        |
| $F$ | $F$ | $F$        |

#### Implicación

| p   | q   | p $\implies$ q |
|-----|-----|----------------|
| $V$ | $V$ | $V$            |
| $V$ | $F$ | $F$            |
| $F$ | $V$ | $V$            |
| $F$ | $F$ | $V$            |

#### Doble implicación

| p   | q   | p $\Leftrightarrow$ q |
|-----|-----|-----------------------|
| $V$ | $V$ | $V$                   |
| $V$ | $F$ | $F$                   |
| $F$ | $V$ | $F$                   |
| $F$ | $F$ | $V$                   |
