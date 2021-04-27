---
title: "Interes compuesto"
date: "26/04/2021"
toc: true
---

Con el interés simple el interés se mantiene constante en todos los periodos.
Pero en la vida real, los intereses tienen que dar mas intereses.

Ejemplo, un capital de 1000 a una tasa de interés simple de 12% en un año
genera 120 quetzales de interés.

Pero si vamos de mes en mes nos queda:

1. Primer mes: $1000*(1+0.01) = 1010.0$
2. Segundo mes: $1010*(1+0.01) = 1020.1$
3. Segundo mes: $1020.10*(1+0.01) = 1030.20$

Y sigue así.

Para no hacer los cálculos de esa manera, se puede utilizar el interés
compuesto.

Interés Compuesto
=================

Monto Compuesto
---------------

$$
M = C(1+i)^n
$$

**Donde:**

* $M$ es el monto compuesto
* $C$ es el capital
* $i$ es la tasa de capitalización por periodo
* $n$ es el numero de periodos

Regresando al ejemplo anterior, lo podemos colocar formalmente como:

> Un capital de 1000 tiene una tasa de 12% anual con capitalización mensual.
> Cual es el monto al final del año?

La tasa de interés es anual, entonces la dividimos en la cantidad de periodos
que tiene un año. La formula nos queda:

$$
M = 1000*(1+0.12/12)^{12} = 1126.825
$$

### Ejemplo 1

> Un cliente recibe de su banco Q60,000 de un deposito que realizo hace 3 años.
> El banco le pago una tasa del 8.5% anual capitalizable bimestral mente. Cual
> fue el deposito original?

Despejamos $C$.

$$
C = \frac{M}{(1+i)^n}
$$

Tenemos 6 bimestres en un año.

Tenemos:

* $M = 60,000$
* $i = \frac{0.085}{6} = 0.014166$
* $n= 3 \times 6 = 18$

$$
C = \frac{60,0000}{(1+0.014166)^{18}} = 46,578.26
$$

### Ejemplo 2

> Para acumular un total de Q40,000 se necesitan depositar Q32,000 durante
> 4 años a una tasa de interés capitalizable trimestralmente. Cual es la tasa
> de interés anual.

Despejamos $i$.

$$
i = \sqrt[n]{\frac{M}{C}}-1
$$

Tenemos 4 trimestres en un año.

$$
i_{trimestral} = \sqrt[4 \times 4]{\frac{40,000}{32,000}} - 1 = 0.014
$$

$$
i_{trimestral} \times 4 = i_{anual} = 0.056
$$

La tasa de interés es de 5.6% anual con capitalización trimestral.


### Ejemplo 3

> Un capital de Q20,000 se deposita a una tasa anual de el 18% convertible
> mensualmente. Cuantos años devén pasar para que se convierta en Q38,000?

Despejamos $n$

$$
n = \frac{\log(\frac{M}{C})}{\log(1+i)}
$$

Tenemos:

* $C = 20,000$
* $M = 38,000$
* $i = \frac{0.18}{12} = 0.015$

$$
n = \frac{\log(\frac{38,000}{20,000})}{\log(1+0.015)} = 43.11
$$

Tienen que pasar 43.11 meses (Porque la tasa es convertible mensualmente).

$$
\frac{43.11}{12} = 3.59
$$

Tienen que pasar 3.59 años.

Taza de interés equivalente
===========================

Es una tasa que genere los mismos intereses que otra tasa pero en diferente
periodo.

$$
(1 + \frac{i}{n})^n = (1 + \frac{j}{m})^m
$$

Donde $j$ y $m$ son los valores conocidos

### Ejemplo

> Tasa anual del 18% con capitalización mensual. Que tasa paga los mismos
intereses pero con capitalización trimestral?

$$
(1 + \frac{i}{4})^4 = (1 + \frac{0.18}{12})^{12}
$$

$$
(1 + \frac{i}{4})^4 = 1.195618171
$$

$$
1 + \frac{i}{4} = \sqrt[4]{1.195618171}
$$

$$
\frac{i}{4} = \sqrt[4]{1.195618171} - 1 = 0.04567
$$

Tiene que ser una tasa del 4.56%.

**Nota:** Se queda como $\frac{i}{4}$ porque estamos buscando la trimestral.
Solo $i$ seria la anual.
