---
title: "Formulario"
toc: true
---

Logaritmos
----------

$$
\log_a(b) = \frac{\log_c(b)}{\log_c(b)}
$$

Progresiones
------------

### Aritméticas

**n'esimo termino**

$$
t_n = t_1 + (n-1)d
$$

**Sumatoria**

$$
S = \frac{n}{2}\left[2t_1 + (n-1)d\right]
$$

### Geométricas

**n'esimo termino**

$$
t_n = t_1 \times (r^{n-1})
$$

**Sumatoria**

Si $r > 1$ 

$$
S = t_1 \left[ \frac{r^n - 1}{r-1}\right]
$$

Si $r < 1$ 

$$
S = t_1 \left[ \frac{1 - r^n}{1-r}\right]
$$

Interés Simple
--------------

$$
I = C \times i \times t
$$

### Notas

* El año comercial es de 360 días (52 semanas), y el mes es de 30 días.
* Si se pide interés simple exacto se usa una año de 365 días.
* Cuando hablemos de interés simple estamos hablando de interés anual.

Monto simple
------------

$$
M = C \times (1 + it)
$$

Descuento simple comercial
--------------------------

$$
D = M \times d \times t
$$

Descuentos inmediatos
---------------------

$$
d = \frac{D}{M}
$$

Descuentos en linea
-------------------

$$
d_t = (1 - (1 - d_1)(1 - d_2)(1 - d_3)(1 - d_4) ... (1 - d_n)) \times 100
$$

Interés compuesto
-----------------

### Monto compuesto

$$
M = C(1 +i)^n
$$

### Interés equivalente

$$
C(1 + \frac{i}{n})^n = C(1 + \frac{j}{m})^m
$$

Anualidad Vencida
-----------------

### Monto

$$
M = R\left[\frac{(1+i)^n - 1}{i}\right]
$$

### Capital (Valor Presente)

$$
C = R\left[\frac{1 - (1+i)^{-n}}{i}\right]
$$

Tabla de amortización
---------------------


| No Pago | Pago             | Interés       | Amortización   | Saldo           |
|---------|------------------|---------------|----------------|-----------------|
| 0       |                  |               |                | Original        |
| 1       | Pago por periodo | Original*Taza | Pago - Interes | Original - Pago |

Anualidad Anticipada
--------------------

### Monto

$$
M = R\left[\frac{(1 + i)^n - 1}{i}\right](1+i)
$$

### Capital (Valor presente)

$$
C = R\left[1 + \frac{1 - (1+i)^{-n+1}}{i}\right]
$$
