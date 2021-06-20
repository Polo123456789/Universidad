Acceso a la base de datos
-------------------------

El sistema debería recibir un query para realizar en la base de datos. Este se
ejecutara en la base de datos y se regresara el resultado.

Lectura de la tarjeta
---------------------

Al lector de la tarjeta se tiene que ingresar el carnet de la persona.

Este verificara que el carnet contenga un ID, y de contenerlo se retornara el
id. Si no tiene un ID se retornara un código de error.

Registro de asistencia
----------------------

El alumno o profesor debería ingresar en la terminal su carnet y el lector de
tarjetas leerá el id del carnet (Ver **'Lectura de tarjeta'**).

Si el lector retorna un código de error se mostrara en pantalla el mensaje:

.. code::

    Error al leer el carnet, vuelva a intentar (Codigo: %i).

Donde ``%i`` sera reemplazado por el código de error.

Si la lectura es exitosa, se validaran los datos y se marcara la asistencia.

(**Nota:** No es necesario que indique la clase ya que esa se sabrá por los
horarios).

Validaciones
~~~~~~~~~~~~

Para las validaciones se harán consultas a la base de datos (Ver **"Acceso a la
base de datos"**).

* Que el id sea de una persona registrada
* Que el horario coincida con una de las clases de la persona.

Ver reporte de listado
----------------------

El sistema debería recibir una clase de la que se quieran los reportes, y el
rango de fechas en el que los quiere.

Se buscara en la base de datos si la clase existe, y si no existe se le
indicara al usuario y se le permitirá ingresar otra.

De existir la clase, se buscara en la base de datos la lista de alumnos de la
clase y el profesor que la imparte.

Para cada uno de los días en el rango de fechas indicado, se verán las horas de
entrada de cada uno de los alumnos y el profesor. Si las horas de entrada
coinciden con la hora estipulada para la clase :math:`\pm 5` minutos, se les
marca como entrada a tiempo. Si esta 5 minutos o mas por delante de la hora
estipulada, se marcara como tarde. Y si esta 5 minutos antes de la hora
estipulada se le marcara como entrada temprana.

Esta información se presentara en una tabla de la siguiente manera:

+---------------+-----------------------------+-----+-------------+
|               | Fecha inicial               | ... | Fecha final |
+===============+=============================+=====+=============+
| Nombre alumno | (Temprano/En tiempo/Tardía) | ... | ...         |
+---------------+-----------------------------+-----+-------------+
| ...           | ...                         | ... | ...         |
+---------------+-----------------------------+-----+-------------+

Nota
~~~~

Ademas de tener el texto '(Temprano/En tiempo/Tardía)', las celdas
tienen que seguir el siguiente código de color:

* Temprano: Verde
* En tiempo: Amarillo
* Tardía: Rojo

De esa forma se podrán identificar las rápido las entradas tardías.
