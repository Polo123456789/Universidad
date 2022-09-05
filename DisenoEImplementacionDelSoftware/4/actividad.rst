===========
Actividad 4
===========

¿Qué es sonarqube?
==================

Es una plataforma para evaluar código fuente. Es software libre y usa diversas
herramientas de análisis estático de código fuente como Checkstyle, PMD
o FindBugs para obtener métricas que pueden ayudar a mejorar la calidad del
código de un programa.

¿Para qué se utiliza en proyectos de software?
==============================================

Se utiliza para evaluar constantemente el código para verificar que se este
escribiendo "Código limpio".

Ellos definen "Código limpio" como un código que se apegue a ciertos estándares
de:

* Confianza
* Seguridad
* Mantenibilidad
* Legibilidad
* Modularidad

Ademas de otros atributos.

¿Qué métricas incluye?
======================

* Complejidad

    * Complejidad Ciclomática
    * Complejidad Cognitiva

* Duplicaciones

    * Bloques Duplicados
    * Archivos Duplicados
    * Lineas Duplicadas
    * Densidad de lineas duplicadas

* Violaciones

    * Nuevas
    * Falsos Positivos
    * Problemas sin resolver
    * Problemas confirmados
    * Problemas reabiertos

* Mantenibilidad

    * Hediondez del código
    * SQALE rating
    * Deuda técnica
    * Ratio de Deuda Técnica

* Confianza

    * Bugs
    * Bugs nuevos
    * Rating de confianza
    * Esfuerzo para corregir los bugs

* Seguridad

    * Vulnerabilidades
    * Vulnerabilidades en código nuevo
    * Rating de seguridad
    * Hotspots de seguridad

* Tamaño

    * Cantidad de clases
    * Lineas con comentarios
    * Porcentaje de comentarios
    * Cantidad de Directorios
    * Cantidad de Archivos
    * Cantidad de Lineas físicas
    * Cantidad de Lineas de código
    * Cantidad de Funciones
    * Cantidad de Provectos
    * Cantidad de Sentencias

* Tests

    * Cobertura

        * Cobertura de condicionales
        * Cobertura de lineas
        * Lineas por cubrir
        * Condiciones sin cubrir

    * Test unitarios

        * Cantidad
        * Duración
        * Errores
        * Fallos (Por una excepción inesperada)
        * Densidad de aciertos

¿Qué lenguajes de programación soporta?
=======================================

.. list-table::
    :header-rows: 0

    * - ``ABAP``
      - ``Apex``
      - ``C#``
      - ``C``
      - ``C++``
    * - ``COBOL``
      - ``CSS``
      - ``Flex``
      - ``Go``
      - ``Java``
    * - ``JavaScript``
      - ``Kotlin``
      - ``Objective-C``
      - ``PHP``
      - ``PLI``
    * - ``PLSQL``
      - ``Python``
      - ``RPG``
      - ``Ruby``
      - ``Scala``
    * - ``Swift``
      - ``TypeScript``
      - ``TSQL``
      - ``VB.NET``
      - ``VB6``
    * - ``HTML``
      - ``XML``

¿De qué se trata cada término?
==============================

* *Analyzer:* Aplicación del cliente que analiza el código y crea snapshots.
* *Database:* Guarda la configuración y los snapshots.
* *Server:* Interfaz web utilizada para navegar los snapshots y hacer cambios
  en la configuración.
* *Bug:* Un problema que representa algo malo en el código.
* *Code Smell:* Un problema de mantenibilidad en el código.
* *Issue:* Pieza de código que no cumple con una regla.
* *Measure:* El valor que se le da a una métrica.
* *Metric:* Un tipo de medida
* *Rule:* Un estándar o practica a ser seguido.

PNI
===

.. list-table::
    :header-rows: 1

    * - Positivo
      - Negativo
      - Interesante

    * - 
        * Detecta y notifica sobre problemas.
        * Aumenta la productividad.
        * Optimiza la calidad.
        * Aumenta las habilidades del desarrollador.
      - 
        * Puede generar falsos positivos
        * Requiere cierto esfuerzo integrarlo al flujo de trabajo de la
          organizacion
      - 
        * Es código abierto (LGPL)
        * Funciona con varios lenguajes

..  Nota: Luego de cada ``-`` hay un espacio, este hace falta para que pandoc
    tome el markup de abajo como rst.
