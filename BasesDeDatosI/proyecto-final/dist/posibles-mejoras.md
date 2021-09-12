---
title: "Proyecto final BD I"
date: "12/09/21"
author: "Pablo Sanchez Galdamez (Carnet: 21001135)"
---

<!--
Escriba una descripción breve de cómo se podría mejorar la base de datos para
una administración más eficiente del negocio. ¿Qué tablas o campos se deberían
agregar? ¿Qué consultas adicionales serían útiles?
-->

Posibles mejoras
================

1. **Qué tablas o campos se deberían agregar?** Pensando en que es posible que
   se compren varios productos del mismo proveedor, creo que seria apropiado
   crear una tabla `compra_tiene_producto`, para permitir que las compras
   lleven varios productos a la vez. De la misma forma seria bueno crear una
   tabla `factura_tiene_producto`.

2. **Qué consultas adicionales serían útiles?** Creo que seria bueno crear
   alguna que de los clientes que mas hayan comprado, de ese modo se puede dar
   beneficios a los clientes fieles, y se les mantiene.
