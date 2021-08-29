---
title: "Actividad 4"
date: "26/08/21"
author: "Pablo Sanchez (Carnet: 21001135)"
---

0FN
===

Cañonera
--------

* Id Cañonera (`PK`)
* Fecha de ingreso
* Marca
* Modelo
* No. Serie
* Fecha de compra
* Años de garantía
* No. Factura
* Proveedor
* Persona de contacto
* Teléfono
* Fecha de vencimiento de la garantía
* Fecha de entrega $(1...n)$
* Hora entrega $(1...n)$
* Fecha devolución $(1...n)$
* Hora devolución $(1...n)$
* Empleado $(1...n)$
* Departamento $(1...n)$

1FN
===

Cañonera
--------

* Id Cañonera (`PK`)
* Fecha de ingreso
* Marca
* Modelo
* No. Serie
* Fecha de compra
* Años de garantía
* No. Factura
* Proveedor
* Persona de contacto
* Teléfono
* Fecha de vencimiento de la garantía

Préstamo
--------

* Id Préstamo (`PK`)
* Id Cañonera (`FK`)
* Fecha de entrega
* Hora entrega
* Fecha devolución
* Hora devolución
* Empleado
* Departamento

2FN
===

En la nueva entidad `Prestamo`, los datos del empleado no dependen de la llave
primaria, así que los pasamos a una nueva entidad.

Cañonera
--------

* Id Cañonera (`PK`)
* Fecha de ingreso
* Marca
* Modelo
* No. Serie
* Fecha de compra
* Años de garantía
* No. Factura
* Proveedor
* Persona de contacto
* Teléfono
* Fecha de vencimiento de la garantía

Préstamo
--------

* Id Préstamo (`PK`)
* Id Cañonera (`FK`)
* Id Empleado (`FK`)
* Fecha de entrega
* Hora entrega
* Fecha devolución
* Hora devolución

Empleado
--------

* Id Empleado (`PK`)
* Empleado
* Departamento

3FN
===

De la entidad `Cañonera`, las propiedades proveedor y marca no dependen de la
llave primaria. Y para la entidad `Empleado` la propiedad de departamento no depende de la llave primaria.

Cañonera
--------

* Id Cañonera (`PK`)
* Fecha de ingreso
* Id Marca (`FK`)
* Modelo
* No. Serie
* Fecha de compra
* Años de garantía
* No. Factura
* Id Proveedor (`FK`)
* Persona de contacto
* Teléfono
* Fecha de vencimiento de la garantía

Marcas
------

* Id Marca (`PK`)
* Marca

Proveedor
---------

* Id Proveedor (`PK`)
* Proveedor

Préstamo
--------

* Id Préstamo (`PK`)
* Id Cañonera (`FK`)
* Id Empleado (`FK`)
* Fecha de entrega
* Hora entrega
* Fecha devolución
* Hora devolución

Empleado
--------

* Id Empleado (`PK`)
* Empleado
* Id Departamento (`FK`)

Departamento
------------

* Id Departamento (`PK`)
* Departamento

Extra
=====

Esto no estoy seguro de si lo podía colocar entre los pasos de normalización,
así que lo coloco aquí. Supongo que la persona de contacto es un empleado,
y que el teléfono que se registra es para contactar a esa persona. Así que
podríamos eliminar redundancias si persona de contacto pasa a ser una llave
foránea que se refiere a un empleado, y se guardan los números de teléfono de
los empleados.

Cañonera
--------

* Id Cañonera (`PK`)
* Fecha de ingreso
* Id Marca (`FK`)
* Modelo
* No. Serie
* Fecha de compra
* Años de garantía
* No. Factura
* Id Proveedor (`FK`)
* Persona de contacto (`FK`)
* Fecha de vencimiento de la garantía

Marcas
------

* Id Marca (`PK`)
* Marca

Proveedor
---------

* Id Proveedor (`PK`)
* Proveedor

Préstamo
--------

* Id Préstamo (`PK`)
* Id Cañonera (`FK`)
* Id Empleado (`FK`)
* Fecha de entrega
* Hora entrega
* Fecha devolución
* Hora devolución

Empleado
--------

* Id Empleado (`PK`)
* Empleado
* Numero Telefónico
* Id Departamento (`FK`)

Departamento
------------

* Id Departamento (`PK`)
* Departamento
