---
title: "Actividad 4"
date: "26/08/21"
author: "Pablo Sanchez (Carnet: 21001135)"
---

0FN
===

Préstamo
--------

Propiedades:

* Id Préstamo (`PK`)
* Fecha de entrega
* Hora de entrega
* Fecha de devolución
* Hora de devolución
* Nombre (empleado)
* Apellidos
* Teléfono
* Departamento
* Nombre (departamento)
* Edificio
* Fecha de ingreso (cañonera)
* Marca
* Modelo
* Numero de serie
* Fecha de adquisición
* Años de garantía
* Numero de factura
* Persona de contacto
* Teléfono
* Fecha de vencimiento de garantía
* Nombre (proveedor)

1FN
===

No existen propiedades con varias ocurrencias, así que no hay ningún cambio.

2FN
===

Ya que no hay entidades que tengan una llave primaria compuesta, esta también
pasamos sin cambios.

3FN
===

Préstamo
--------

* Id Préstamo (`PK`)
* Fecha de entrega
* Hora de entrega
* Fecha de devolución
* Hora de devolución
* Id Empleado (`FK`)
* Id Cañonera (`FK`)

Empleado
--------

* Id empleado (`PK`)
* Nombre
* Apellidos
* Teléfono
* Id Departamento (`FK`)

Departamento
------------

* Id Departamento (`PK`)
* Nombre
* Edificio

Cañonera
--------

* Id Cañonera (`PK`)
* Fecha de ingreso
* Marca
* Modelo
* Numero de serie
* Fecha de adquisición
* Años de garantía
* Numero de factura
* Persona de contacto (`FK`)[^1]
* Fecha de vencimiento de garantía
* Id Proveedor (`FK`)

[^1]: Supongo que la persona de contacto es un empleado, así que podemos
eliminar el campo teléfono para eliminar la redundancia, y que persona de
contacto sea el id del empleado.

Proveedor
---------

* Id proveedor (`PK`)
* Nombre
* Teléfono
