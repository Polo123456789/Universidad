---
title: "Plan de Pruebas del Sistema SIS-WEB"
author: "Pablo Sanchez (21001135)"
numbersections: true
toc: true
toc-depth: 3
toc-title: "Contenidos"
---

Introducción
============

Objetivo
--------

El objetivo de este documento es proporcionar la información y el marco
requerido para planificar y desarrollar las actividades del proceso de pruebas
del Sistema `SIS-WEB`.

Referencias
-----------

* Especificación de requerimientos ([**Link**](./ers.pdf))
* ISO 29119

Definiciones, siglas y abreviaciones
------------------------------------

ERS
: Especificación de requerimientos de Sistema

MB
: El megabyte es una unidad de información. Equivale a $10^6$ b (un millón de
  bytes).

GB
: Un gigabyte es una unidad de información. Equivale a $10^9$ b (mil millones
  de bytes).

RAM
: La memoria de acceso aleatorio (Random Access Memory, RAM) es una memoria de
  almacenamiento a corto plazo. El sistema operativo de ordenadores u otros
  dispositivos utiliza la memoria RAM para almacenar de forma temporal todos
  los programas y sus procesos de ejecución.

Alcance de las pruebas
======================

Resumen de las pruebas
----------------------

### Funcionalidades a ser probadas

Se probaran las siguientes funcionalidades según se describen en la ERS,
sección 3.2:

* Administración de Usuarios
* Administración de Seminarios
* Administración de Roles
* Coordinación de Seminarios
* Publicación de Información
* Inscripción

### Objetivos de las pruebas

En las funcionalidades anteriormente mencionadas se realizaran pruebas para
validar:

* La visualización de los datos, ingresados o modificados.
* La respuesta y realización de las transacciones.
* La secuencia lógica de las funcionalidades.
* Los efectos secundarios que puedan surgir.

### Dependencias

* "Administración de roles" depende de "Administración de usuarios"
* "Inscripción" y "Coordinación de Seminarios" dependen de "Administración de
  seminarios".

### Orden de ejecución

1. "Administración de usuarios" y sus dependientes.
2. "Administración de seminarios" y sus dependientes.
3. Publicación de Información

### Responsabilidad de las pruebas

Las pruebas son responsabilidad del equipo de desarrollo, quien en conjunto con
el usuario debe crear las pruebas que aseguren la efectividad del sistema.

Casos de prueba incluidos
-------------------------

Según se encuentran en la sección 4.2 de la ERS:

| Funcionalidad                 | No. de casos | Tipo      | Total |
|-------------------------------|-------------:|-----------|------:|
| Administración de Usuarios    |            4 | Funcional |       |
| Administracion de Seminarios  |            2 | Funcional |       |
| Coordinación de seminarios    |            2 | Funcional |       |
| Administracion de Inscripción |            2 | Funcional |       |
| -                             |              |           |    10 |

<!-- tmf: $5,-1=float2nr(Sum(1,2:-1,2)) -->

Casos de prueba excluidos
-------------------------

| Funcionalidad | No. Casos | Tipo     | Total |
|---------------|----------:|----------|------:|
| Navegacion    |         3 | Interfaz |       |
| -             |           |          |     3 |

<!-- tmf: $5,-1=float2nr(Sum(1,2:-1,2)) -->

Entorno y configuración de las pruebas
======================================

Entorno
-------

Para el proceso de pruebas del proyecto se requiere de la disponibilidad de los
siguientes entornos:

### Servidor

Se necesita un servidor que tenga como mínimo[^1]:

[^1]: Para que los datos sean exactos, y como no hay mención de esto en la ERS,
tome como referencia los specs mínimos para hostear un software para
videoconferencias y seminarios de código abierto llamado `Jitsi`

* Una velocidad de Internet de 50 `MB`
* 8 `GB` de memoria RAM
* Un procesador con como mínimo 4 cores dedicados
* Mínimo 250 `GB` de espacio libre en un disco de estado solido

### Cliente

Para los ordenadores que representan a los clientes, se necesita como
mínimo:

* Una velocidad de Internet de 2.5 `MB`
* 4 `GB` de memoria `RAM`
* Mínimo 1 `GB` libres de espacio libre en el disco duro.

Criterios de inicio
-------------------

Aceptación del plan de pruebas. Revisión y aceptación del documento que
contiene los casos de pruebas para la certificación del proyecto.

Aceptación de ambiente. Revisión y aceptación del ambiente de certificación,
y que este cumpla con las condiciones de aceptación.

Base de datos de prueba
-----------------------

Se ha de crear una base de datos que contenga:

* 1 Administrador
* 1 Coordinador de Seminario
* 1 Coordinador de Recursos
* 3 Participantes

Las pruebas relacionadas con lo usuarios se validaran contra esta base de
datos, y esta se puede usar como base para las demás pruebas.

Criterios de Aprobación/Rechazo
-------------------------------

**Errores Graves:** información crítica presentada erróneamente, información mal
registrada en la base de datos, caídas de programas, incumplimiento de
objetivos en funciones principales, etc.

**Errores Medios (comunes):** errores en documentos impresos que se entregan
a personas ajenas a la organización, errores en presentación de datos,
incumplimiento de objetivos en funciones secundarias, caídas de programas
auxiliares, etc.

**Errores Leves:** errores en presentación de datos secundarios, no adecuación
a estándares, comportamientos correctos pero diferentes en situaciones
similares, dificultades de operación, etc.

Se aprobara el proyecto con un 100% de las pruebas ejecutadas, pero con un 95%
de aceptación. El 95% de las pruebas tienen que ser exitosas, y en el 5%
restante pueden existir errores leves, pero no medios ni graves.

Estrategia de pruebas
=====================

Escenario de las pruebas
------------------------

Para cumplir con los objetivos planteados deben existir tres escenarios, que
son, Pruebas de Instalación, Pruebas de GUI o Interfaz y Pruebas de Operación
o Funcionales.

Para las Pruebas de Instalación se debe comprobar que:

* La aplicación se instala correctamente.
* La aplicación no presenta anomalías.
* El servidor se configura correctamente.

Para las pruebas de GUI se debe comprobar que:

* Se presentan todos los datos requeridos en el formato correcto.

Para las pruebas de operación se debe comprobar que:

* El comportamiento de aplicación con casos inválidos y válidos.

Orden de ejecución de las pruebas
---------------------------------

Las pruebas se llevaran a cabo de la siguiente forma:

1. Configuración del servidor, y pruebas de instalación.
2. Pruebas para "Administración de usuarios" y sus dependientes.
3. Pruebas para "Administración de seminarios" y sus dependientes.
4. Pruebas para Publicación de Información

Apéndice
========

Casos de prueba
---------------

Formato de los identificadores:

```
CP_<ID_REQUISITO>_<NO. CASO>
```


Otras referencias
-----------------

Para este plan de pruebas me base mayormente en [**este ejemplo que encontre en
linea**](https://jmpovedar.files.wordpress.com/2014/03/ejemplo-plan-de-pruebas.pdf).
