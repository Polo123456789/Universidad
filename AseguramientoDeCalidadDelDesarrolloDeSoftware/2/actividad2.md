---
title: "Actividad 2 Unidad 2"
author: "Pablo Sanchez Galdamez (21001135)"
---

> Investigue si hay alguna otra técnica para la verificación y validación de
> software

Tanto por como se presentan en el contenido, como por como se presentan en lo
que he investigado, creo que no hay otra técnica.

Parecen presentarse como una dicotomía, o se requiere la ejecución del
software, o no se requiere.

---

> Explique las ventajas y desventajas sobre las vistas en clase 

**Técnica Estática:**

*Ventajas:*

* Es la que detecta los errores mas rápido
* Permite corregir los errores sobre la marcha

*Desventajas:*

* Necesita que el software que este haciendo las verificaciones este corriendo
  constantemente.
* Puede dar falsos positivos.
* Dependiendo del software, puede ser necesario filtrar las verificaciones
  realizadas, ya que algunas pueden ser conflictivas entre si (Ejemplo:
  `modernize-use-trailing-return-type` y `fuchsia-trailing-return` en `clang-tidy`).

**Técnica Dinámica:**

*Ventajas:*

* Esta garantiza capturar todos los errores

*Desventajas:*

* Esta necesita que se diseñen las pruebas especificas para cada parte del
  software
* Esta necesita un framework aparte del software que se esta desarrollando.

---

> Emita su opinión de cual es la mejor a su parecer.

No creo que una sea mejor que otra, ya que cada una tiene una funcionalidad
diferente. La estática identifica errores comunes y malas practicas, y la
dinámica identifica errores en la implementación.

De tener que quedarme con una, tendría que ser la dinámica, ya que es la única
que me aseguraría de que el software cumple con los requerimientos.
