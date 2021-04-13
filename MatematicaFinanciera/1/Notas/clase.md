---
title: "Exponentes y radicales"
---

Exponente
=========

Es un numero de la forma

$$
a^n
$$

Propiedades
-----------

$$
a^n \times a^m = a^{n + m}
$$

$$
(a^n)^m = a^{n \times m}
$$

$$
\frac{a^n}{a^m} = a^{n-m}
$$

$$
(ab)^n = a^n b^n
$$

$$
\left(\frac{a}{b}\right)^n = \frac{a^n}{b^n}
$$

$$
a^1=a
$$

$$
a^0 = 1 \Leftrightarrow a \neq 0
$$

$$
a^{-n} = \frac{1}{a^n}
$$

Radicales
=========

$$
a^{\frac{n}{m}} = \sqrt[m]{a^n}
$$

Logaritmos
==========

$$
\log_a(N) = x \Leftrightarrow a^x = N
$$

Si es base $10$ lo se escribe únicamente $\log$, y se le llama logaritmo común.
Si es base $e$ se escribe $\ln$, y se llama logaritmo natural.

Propiedades
-----------

$$
\log_a(b^n) = n \times \log_a(b)
$$

### Ecuación de cambio de base

$$
\log_a(b) = \frac{\log_c(b)}{\log_c(a)}
$$

Progresiones
============

Aritméticas
-----------

Son los que tienen una distancia entre elementos:

Ejemplo (distancia = 2):

~~~
{2, 4, 6, 8, 10}

t1 = 2
t2 = 4
t3 = 6
t4 = 8
t5 = 10
~~~

Para saber si una progresión es aritmética se usa la siguiente formula:

$$
t_2 - t_1 = t_3 - t_2
$$

En este caso nos queda que $2=2$, por lo que sabemos que es aritmética y la
distancia es $2$.

### n'esimo termino

Para obtener el termino $n$ se usa la siguiente formula:

$$
t_n = t_1 + (n-1)d
$$

**Donde:**

* $t_1$ es el primer elemento
* $n$ es el termino que buscamos
* $d$ es la distancia

### Sumatoria

La suma de todos los elementos hasta $n$ es:

$$
S = \frac{n}{2} \left[2t_1 + (n-1)d\right]
$$

Geométricas
-----------

Son las que tienen una razón entre los términos.

Ejemplo (razón = 2):

~~~
{2, 4, 8, 16, 32}

t1 = 2
t2 = 4
t3 = 8
t4 = 16
t5 = 32
~~~

### n'esimo termino

$$
t_n = t_1 \times r^{n-1}
$$

### Sumatoria

Si la razón es mayor a uno:

$$
S = t_1 \left[\frac{r^n - 1}{r - 1}\right]
$$

Si la razón es menor a uno:

$$
S = t_1 \left[\frac{1 - r^n}{1 - r}\right]
$$
