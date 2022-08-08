======================================================================
Actividad 4: Técnicas de estimación y control de proyectos de software
======================================================================

.. Del problema que se le plantea a continuación deberá de realizar lo
   siguiente:

   * Especificar el análisis de costos de cada problema. Basados en el ejemplo
     explicado en clase.
   * Tomando en cuenta los siguientes puntos del triángulo debe de realizar un
     análisis final para la conclusión de cada problema.


.. Formulas para las tablas:

   Totales y impuestos:
   <!-- tmf: $-1 = $2 * $3; $-2 = "X" -->

   Subtotales y total final:
   <!-- tmf: $-4,-1 = Sum(1:-4); $-3,-1 = $-4,-1; $-1,-1 = $-3,-1 * (1 + $-2,-1) -->

Problema 1 - Despertador
========================

.. Realizar una aplicación que cumpla la tarea de despertador, esto debe de
   cumplir las siguientes funciones.

   * El usuario deberá de programar la alarma en la hora especificada por el.
   * El usuario podrá elegir que sonido de la librería del telefono puede
     seleccionar para la alarma.
   * El usuario podrá elegir que días puede activarse la alarma del telefono.
   * La aplicación deberá de llamarse Despertador KS.
   * Se deberá de guardar un registro de las alarmas programadas por el usuario
     en una base de datos.

Análisis de Costos
------------------

+--------------------------------+-------------+--------+------------+-------+
| Descripción                    | Precio/Hora | Tiempo | Impuestos  | Total |
+================================+=============+========+============+=======+
| Planificación y Diseño         | 40          | 2      | X          | 80    |
+--------------------------------+-------------+--------+------------+-------+
| Configuración de el entorno de | 40          | 3      | X          | 120   |
| desarrollo                     |             |        |            |       |
+--------------------------------+-------------+--------+------------+-------+
| Diseño de la base de datos     | 60          | 1      | X          | 60    |
+--------------------------------+-------------+--------+------------+-------+
| Diseño de la interfaz gráfica  | 60          | 1      | X          | 60    |
+--------------------------------+-------------+--------+------------+-------+
| Codificación de la aplicación  | 60          | 3      | X          | 180   |
+--------------------------------+-------------+--------+------------+-------+
|                                |             |        | Sub total  | 500.0 |
+--------------------------------+-------------+--------+------------+-------+
|                                |             |        | Imponible  | 500.0 |
+--------------------------------+-------------+--------+------------+-------+
|                                |             |        | Impuesto % | 0.05  |
+--------------------------------+-------------+--------+------------+-------+
|                                |             |        | Total      | 525.0 |
+--------------------------------+-------------+--------+------------+-------+

Análisis final
--------------

Alcance
~~~~~~~

Debido a que el programa es relativamente sencillo, todas las funcionalidades
se harán disponibles en la primera versión del software.

Tiempo
~~~~~~

El proyecto se terminara en 10 horas

Costo
~~~~~

Por el trabajo, serán Q 525. Y otros Q 1,500 adicionales para obtener un
teléfono en el que se realizaran pruebas.

Total: Q 2,025

Problema 2 – Reservación
========================

.. Realizar una aplicación que le permita al usuario realizar reservaciones en
   un restaurante.

   * Se le mostrara el listado de lugares disponibles al usuario para reserva.
        - EJEMPLO: MESA6 – LUGAR VENTANA o MESA9- Lugar Entrada.
   * Al momento de seleccionar el lugar de reserva el usuario deberá de indicar
     el tiempo y fecha que estará ocupado este lugar.
   * Después de cumplirse el procedimiento anterior la mesa seleccionada deberá
     de quitarse de la lista de lugares disponibles.
   * Después de cumplirse el tiempo el lugar deberá de mostrarse nuevamente
     dentro del listado de lugares disponibles.
   * Se deberá de notificar por correo al usuario, la fecha de vencimiento y la
     fecha en que solicito dicha mesa.

Análisis de Costos
------------------

+-------------------------------+-------------+--------+------------+--------+
| Descripción                   | Precio/Hora | Tiempo | Impuestos  | Total  |
+===============================+=============+========+============+========+
| Planificación y Diseño        | 40          | 4      | X          | 160    |
+-------------------------------+-------------+--------+------------+--------+
| Configuración del entorno de  | 40          | 2      | X          | 80     |
| desarrollo                    |             |        |            |        |
+-------------------------------+-------------+--------+------------+--------+
| Configuración del servidor    | 60          | 3      | X          | 180    |
+-------------------------------+-------------+--------+------------+--------+
| Diseño de la base de datos    | 60          | 2      | X          | 120    |
+-------------------------------+-------------+--------+------------+--------+
| Diseño de las interfaces      | 55          | 2      | X          | 110    |
| gráficas                      |             |        |            |        |
+-------------------------------+-------------+--------+------------+--------+
| Codificación de la aplicación | 60          | 6      | X          | 360    |
+-------------------------------+-------------+--------+------------+--------+
| Testing                       | 50          | 6      | X          | 300    |
+-------------------------------+-------------+--------+------------+--------+
|                               |             |        | Sub total  | 1310.0 |
+-------------------------------+-------------+--------+------------+--------+
|                               |             |        | Imponible  | 1310.0 |
+-------------------------------+-------------+--------+------------+--------+
|                               |             |        | Impuesto % | 0.05   |
+-------------------------------+-------------+--------+------------+--------+
|                               |             |        | Total      | 1375.5 |
+-------------------------------+-------------+--------+------------+--------+

Análisis final
--------------

Alcance
~~~~~~~

Todas las funcionalidades serán entregadas en la primera versión del programa.

Tiempo
~~~~~~

El proyecto se terminara en 25 horas.

Costo
~~~~~

Por el trabajo, serán Q 1,310. Adicional a eso por el servidor donde correrá el
programa serán Q 3,000.

Total: Q 4,310
