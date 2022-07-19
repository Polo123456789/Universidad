---
title: "Problema Agenda Medica (Programacion Extrema)"
author: "Pablo Sanchez Galdamez (21001135)"
toc: true
toc-depth: 3
toc-title: "Contenidos"
numbersections: true
---

Fase de Exploración
===================

Proceso
-------

El cliente registrara las citas que tiene con sus pacientes. El programa creara
un calendario con las citas agendadas, y le notificara tanto a el medico como
el paciente 30 minutos antes de la cita.

Requerimientos
--------------

La aplicación tendrá que almacenar:

* Ubicación (Centro medico)
* Fecha y Hora de la cita
* Costo de la cita

Tendrá que implementar las siguientes funcionalidades:

* Login
* Creación y eliminación de cuentas de usuario
* Creación, eliminación, filtrado y edición de médicos y pacientes
* Panel administrativo
* Envió de notificaciones

Separación en módulos
---------------------

### M1: Usuarios

El administrador debe poder crear y eliminar usuarios. Los usuarios tienen que
poder iniciar sesión.

### M2: Administración

Desde el panel administrativo se tienen que poder gestionar los médicos,
pacientes y usuarios.

### M3: Citas

Los médicos tienen que poder crear las citas, y ver su calendario de citas.

### M4: Notificaciones

30 minutos antes de cada cita se tienen que enviar notificaciones tanto al
medico como al paciente.

Planificación
=============

| Prioridad | Requerimiento | Valor | Esfuerzo | Iteración | Semanas |
|:---------:|:-------------:|:-----:|:--------:|:---------:|:-------:|
|     1     |       M1      |   2   |     M    |     1     |    1    |
|     2     |       M3      |   6   |     L    |     1     |    1    |
|     3     |       M2      |   10  |    XL    |     2     |    2    |
|     4     |       M4      |   1   |     S    |     3     |    1    |

Producción
==========

Fecha de Producción final: 1 Mes

Mantenimiento
=============

* **Actualizaciones:** Cada 1 año, o cada vez que el cliente tenga
  requerimientos nuevos.
* **Mantenimiento Correctivo:** Cada vez que se encuentre una falla grave.
* **Mantenimiento Preventivo:** Cada vez que se acumulen varias fallas menores,
  cada 6 Meses, y cada vez que se actualice el OS del servidor.
