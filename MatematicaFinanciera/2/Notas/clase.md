---
title: "Interes simple/Descuento Simple"
toc: true
---

Interés Simple
==============

Interés
-------

La cantidad que genera un capital a una tasa de interés durante un periodo de
tiempo.

Formula
-------

$$
I = C \times i \times t
$$

**Donde:**

* $I$ es el interés (Valor monetario)
* $C$ es el capital (Valor inicial)
* $i$ es la tasa de interés
* $t$ es el tiempo

Ejemplo
-------

### 1

> Se deposita una cantidad de Q10,000 a una tasa del 18% anual durante 3 años.

Sustituyendo los valores:

$$
I = 10,000 \times 0.18 \times 3 = 5,400
$$

Se sacan $5,400$ quetzales de interés.

### 2

> Se deposita una cantidad de Q10,000 a una tasa del 18% anual desde el 16 de
> enero al 15 de octubre del mismo año.

#### Calculo exacto del tiempo

**Días:**

* Quedan 15 días de enero.
* 29 febrero
* 31 marzo
* 30 abril
* 31 mayo
* 30 junio
* 31 julio
* 31 agosto
* 30 septiembre
* 15 octubre

Son 272 días exactos

#### Calculo aproximado

Empezamos en el 16 de enero. Pasan 9 meses para llegar al 16 de octubre.

$$
9 * 30 = 270
$$

Menos el el día para estar en el 15 de octubre, son $269$ días aprox.

#### Interés comercial

Usamos el calculo aproximado

$$
I = 10,000 \times 0.18 \times \frac{269}{360}
$$

#### Interés Exacto

Usamos el calculo exacto

$$
I = 10,000 \times 0.18 \times \frac{272}{365}
$$

Notas
-----

* El año comercial es de 360 días (52 semanas), y el mes es de 30 días.
* Si se pide interés simple exacto se usa una año de 365 días.
* Cuando hablemos de interés simple estamos hablando de interés anual.

Monto Simple
============

$$
M = C + I
$$
$$
M = C + Cit
$$
$$
M = C \times (1 + it)
$$

**Donde:**

* $M$ es el monto
* $C$ es el capital
* $I$ es el interés
* $i$ es la tasa de interés
* $t$ es el tiempo

Descuento Simple o Comercial
============================

$$
D = M \times d \times t
$$

**Donde:**

* $D$ es el descuento
* $d$ es la tasa de descuento
* $t$ es el tiempo
* $M$ es el monto

Ejemplo
-------

### 1

> Una persona debe un documento con valor nominal de Q15,000. El banco ofrece
> descuentos del 5% si cancela antes de tiempo. La deuda la cancela 6 meses
> antes. Cual sera el descuento aplicado?

$$
D = 15,000 * 0.05 * 6/12 = 375.0
$$

Entonces el pago es de $15,000 - 375 = 14625$.

### 2

> Un cliente recave la propuesta de cancelar su deuda 9 meses antes de
> finalizar el periodo pactado. Si el valor nominal de la deuda es de 38,000
> y se le ofrece cancelar 36,500, cual es la tasa ofrecida?

$$
d = \frac{D}{M \times t} = 0.053
$$

Tiene un descuento del $5.3$%.

Notas
-----

* El valor nominal del documento es la cantidad que que se debe, es el monto.

Descuentos inmediatos
=====================

$$
d = \frac{D}{M}
$$

Descuentos en linea
===================

Ejemplo
-------

Se nos dan los siguientes descuentos:

* 5% si se compra al contado
* 3% por tarjeta de socio
* 2% por comprar una linea en especifico

Cual es la tasa total a descontar?

La formula es:

$$
d_t = (1 - (1 - d_1)(1 - d_2)(1 - d_3)(1 - d_4) ... (1 - d_n)) \times 100
$$

En este caso:

$$
d_t = 1 - (1 - 0.05)*(1 - 0.03)*(1 - 0.02) = 0.0969
$$

Es un $9.69$% de descuento.
