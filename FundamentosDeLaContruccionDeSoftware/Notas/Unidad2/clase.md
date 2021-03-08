---
title: "FCS Unidad 2: Etapas de la construccion de software"
date: "04/03/2021"
toc: true
---

Recolección de requerimientos
=============================

Tenemos que recabar la mayor cantidad de información para poder construir la
solución adecuada.

En la recolección de requerimientos participan tanto el desarrollador como el
cliente. Puede que el cliente no de una idea clara, así que el desarrollador
tiene que actuar como interrogador, consultor, como persona que resuelve
problemas y como negociador.

Principios
----------

* **Escuchar** y hacer preguntas si algo no esta claro.
* **Prepararse** investigando el negocio. Y de ser encargados de las reuniones,
  tenemos que tener una agenda.
* **Tomar notas** de los puntos claves y los temas tratados. Importante tomar
  nota de las decisiones.
* **Perseguir la colaboración**
* **Permanecer centrado en el tema**
* **Si algo no esta claro, diagramar.** Ya que esto puede ayudar a transmitir
  ideas.
* **Avanzar** en casos de que no se este haciendo mucho progreso.
* **La negociación no es un concurso**, esta demanda compromiso de todas las
  partes.

Herramientas
------------

1. **Entrevistas** (Tanto reuniones uno a uno como reuniones grupales). En
   estas tenemos que hacer varias clases de preguntas. **Ejemplos:** ¿Quién
   utilizará el sistema? ¿Cuáles son los objetivos del sistema? ¿Cuáles son los
   beneficios de esta solución?. También presenta la oportunidad de aclarar
   dudas de el cliente.
2. **Talleres** en los que trabajaremos juntos para llegar a los requisitos. La
   diferencia con las entrevistas es que estos tienen un tiempo definido, pero
   pueden ser iterativos.
3. **Lluvias de ideas** en las que las personas involucradas nos ayudan
   a identificar los requerimientos.
4. **Cuestionarios**. Estos son buenos porque son versátiles, y le permiten al
   cliente responder a su ritmo y en su tiempo.
5. **Observación/Seguimiento.** Aquí iremos a las instalaciones del cliente
   a observar como se trabaja, que información necesitan, las limitantes que
   tienen, etc.
6. **Historias de usuario.** Es una definición de alto nivel de un requisitos
   para que nosotros o otro desarrollador pueda dar una estimación razonable de
   el esfuerzo necesario para implementarlo.

Análisis de requisitos
======================

Los diferentes métodos de análisis de los requisitos que se han establecidos se
basan en una serie de principios fundamentales que permiten dar un enfoque
sistémico al problema a resolver. Roger S. Pressman identifica los siguientes
principios:

* Se debe comprender el ámbito de información del problema.
* Se deben desarrollar los modelos que representan la información, función y el
  comportamiento del sistema.
* Se deben subdividir los modelos (y el problema) de forma que se descubran los
  detalles de una manera progresiva (o jerárquica).
* El proceso de análisis debe ir de la información esencial hacia el detalle de
  la implementación

Clasificación
-------------

### Requisitos funcionales

Son las funcionalidades que tiene que tener el software. Como tiene que
reaccionar a entradas y situaciones particulares.

### Requisitos no funcionales

Restricciones de tiempo, en el proceso de desarrollo, de seguridad, etc.

### Requisitos de dominio

Son los que vienen de el dominio de la aplicación. Así como las reglas del
negocio.

Casos de uso
------------

Caracteriza una forma de usar el sistema. Es un dialogo entre el usuario y el
sistema. Este ayuda a entender los requisitos del cliente.

### En diagramas UML

En estos listamos en diagramas de alto nivel los casos de uso del sistema.

![](Imagenes/casos-uso-uml.png)

### Formales

En estos se debe detallar a profundidad cada caso. **Ejemplo:**

| Objetivo           | Un pasajero podra reservar boletos         |
| Actor              | Pasajero                                   |
| Ambito             | Sistema de reservaciones en linea          |
| Nivel              | Usuario                                    |
| Pre-condicion      | Pasajero deve iniciar sesion en el sistema |
| Condicion de exito | Se reserva el vuelo                        |
| Condicion de fallo | No se puede reservar el vuelo              |
| Desencadenante     | Click en boton: "Reservar vuelo"           |
| Etc                | Etc                                        |

#### Pasos para crearlos

1. Identificar actores y objetivos
2. Escribir el escenario exitoso
3. Enumerar las posibles fallas
4. Listar las variaciones

### Informales

Estos son un párrafo que describe el escenario.

Dividir historias de usuario
----------------------------

Aprender a dividir historias de usuario largas en historias más pequeñas es una
de las mejores cosas que un equipo puede realizar para mejorar su flujo de
trabajo de Scrum.

Las historias horizontales son aquellas que pertenecen a una capa estructural
del sistema, como la base de datos, la interfaz de usuario, etc. Las historias
verticales son todas aquellas historias que cruzan todos los límites de la
arquitectura del sistema, pero solo implementan una funcionalidad a la vez

Diseño
======

Codificación
============

Aseguramiento de la calidad
===========================

Despliegue
==========

Mantenimiento
=============
