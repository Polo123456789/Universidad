---
title: "Notas: Fundamentos de la contruccion de software"
date: "18/02/2021"
toc: true
---

Software
========

**Definición formal:**

> El Software es un conjunto de instrucciones que se ejecuta en una computadora
> para poder manipular y procesar datos que cumplen los requerimientos de una
> tarea específica.

Por ello se dice que es el componente lógico, al contrario del hardware.

Este es desarrollado usando distintos lenguajes de programación. Estos son un
conjunto de símbolos y reglas que representan instrucciones para las
computadoras. El lenguaje de nivel mas bajo son 1s y 0s. Pero nosotros
programamos en lenguajes de nivel mas alto, que luego son compilados
o interpretados.

**Definición de la IEEE:**

> El conjunto de los programas de cómputo, procedimientos, reglas,
> documentación y datos asociados, que forman parte de las operaciones de un
> sistema de computación

Características
---------------

* Este se desarrolla, no se fabrica.
* Este no se desgasta: El este al deteriorarse queda obsoleto, ya sea gracias
  a los cambios, correcciones y problemas de compatibilidad de su entorno
  operativo.
* La mayoría de el software se construye a la medida.

## Evolución

Este se puede dividir en 5 eras:

### 1955-1965

* Se realizaba sin planteamiento previo.
* No existían fuentes de información
* Desarrollo a base de prueba y error

### 1965-1972

* Software como producto.
* Simplificación del código.
* Aparición de el multiprocesamiento y las bases de datos.
* Inicia "Crisis del software", donde muchos proyectos sobrepasaron su tiempo
  estimado y presupuesto.
* Se definen procedimientos para el desarrollo.

### 1972-1985

* Concepto de "Sistemas Distribuidos" (Uso de múltiples ordenadores).
* Implementaron de redes a nivel local y global.
* Se definen metodologías para el diseño y análisis.

### 1985-2000

* Se implementan redes de información y tecnologías orientadas a objetos.
* Auge del Internet
* Fortalecimiento de la seguridad informática.

### 2000-Presente

* Aplicaciones móviles
* Inteligencia artificial
* Realidad virtual

Ingeniería de software
----------------------

Gracias a la combinación de métodos para realizar el desarrollo, herramientas
automatizadas, técnicas para garantizar la calidad del software y una filosofía
predominante para la coordinación, control y gestión, nace la ingeniería de
software.

Esta contiene 3 elementos clave:

### Métodos

Indican como construir el software. Describen las tareas de:

* Planificación y estimación.
* Análisis de requerimientos.
* Diseño de la estructura de datos.
* Arquitectura de programas y algoritmos.
* Codificación.
* Prueba.
* Mantenimiento

### Herramientas

Dan un soporte automatizado para la implementación de los métodos.

### Procedimientos

Indican la secuencia en la que aplican los métodos.

Procesos para la construcción de software
-----------------------------------------

La creación de software se simplifica si se definen y utilizan procesos que
luego se estandarizan.

Se necesitan estas definiciones:

* **Proceso:** Es un conjunto de actividades que tienen que realizarse.
* **Actividad:** Cualquier acción definida a un objetivo a grandes rasgos del
  proyecto.
* **Acción:** Realización de tareas que producen un avanza del proyecto.
* **Tarea:** Objetivo pequeño y bien definido.

En resumen, *un proceso define las acciones de cada individuo, cuando devén ser
realizadas y de que manera tienen que realizarse*.

### Estructura de un proceso

Este consta de 5 actividades, que suelen realizarse en orden y se repiten con
cada proyecto.

* **Comunicación:** Se realiza con el cliente, y se tiene el objetivo de
  obtener los requerimientos y objetivos del proyecto.

* **Planeación:** Da la guía para conocer los pasos, tareas y acciones que
  devén realizarse. 

* **Modelado:** Es una representación del producto terminado, que ejemplifica
  algunas funcionalidades y características del producto al cliente. Esta
  representación se usa como guía para los desarrolladores y evita malos
  entendidos.

* **Construcción:** Se genera el código y las pruebas de control de calidad. 

* **Despliegue:** Se entrega al cliente para recibir retoalimentación, se hacen
  los mínimos ajustes y se pasa al ambiente de producción.

### Flujos del proceso

Define el orden en el que se hacen los 5 componentes.

#### Lineal

Se realizan las actividades en el orden planteado arriba.

#### Iterativo

Aquí se repiten las actividades para realizar correcciones bajo la marcha de
ser necesario. Usualmente se hace regresando la actividad `Comunicacion`.

#### Evolutivo

Las actividades se realizan en orden, repitiéndose varias veces, para cada vez
entregar versiones con mayor funcionalidad.

#### Paralelo

Como lo dice el nombre, aquí las tareas se hacen de forma simultanea. Por
ejemplo se puede hacer la planeación junto al modelado.

### Modelos o ciclo de vida

Es una vista de las actividades que ocurren durante el desarrollo.

#### Cascada

Es conocido como el ciclo de vida clásico del software, ya que su enfoque es
llevar las tareas en secuencia. Este se usa cuando los requerimientos no
cambian.

#### Incremental

Este es el que se usa cuando hay factores que impiden que el proceso sea
lineal. Es una mezcla del proceso lineal y paralelo. Se trabaja linealmente
hasta tener un software básico. Luego se van programando los siguientes módulos
o incrementos.

#### Prototipos

Este se suele usar cuando el tiempo de lanzamiento es critico. Se aíslan
diferentes componentes y se trabajan en el orden que sean necesarios. Al
momento del despliegue son nuevas versiones del producto.

#### En espiral

Es una mezcla del modelo en cascada y el de prototipos. Cada vez que se realiza
un ciclo de el modelo de cascada, el prototipo tiene mayor funcionalidad.

#### Concurrente

Usualmente se usa cuando varios equipos están involucrados. Por ejemplo, un
equipo hace la interfaz, y otro hace la API.

#### Basado en componentes

Es muy similar al modelo en espiral. En cada iteraron se realiza un componente
nuevo.

Desarrollo rápido de aplicaciones (RAD)
---------------------------------------

Esta cambia el enfoque a la creación de prototipos usando herramientas
asistidas por computadora.

Por ejemplo, para una pagina web simple, se pueden utilizar herramientas en las
que un desarrollador construye el sitio arrastrando componentes.

RAD funciona muy bien para pequeñas empresas, donde los usuarios comerciales
son dueños del presupuesto.

### Pasos

1. **Planificación de requerimientos**
2. **Diseño con el usuario:** Se trabaja en estrecha colaboración con los
   clientes para crear y mejorar los prototipos.
3. **Construcción:** Una vez se define el alcance del proyecto, se puede
   comenzar el desarrollo.
4. **Transición:** Conversión de datos y capacitación del usuario.

### Herramientas

### Diseño y prototipo

Figma, InVision y Adobe XD permiten a los expertos en UI y UX construir
rápidamente prototipos.

### Construcción

#### Plataformas de bajo código

Esta permite a los usuarios sin habilidades de desarrollo entregar aplicaciones
de trabajo muy rápidamente. Estas plataformas se limitan a la creación de
sistemas muy básicos. **Ejemplos:** Wix, Mendix, Kissflow.

#### Plataformas enfocadas en el desarrollador

Estas son herramientas de generación de código, con lo que los desarrolladores
se mantienen alejados de escribir código repetitivo.

Proceso Racional Unificado
--------------------------

Este proporciona un enfoque disciplinado para asignar tareas
y responsabilidades dentro de una organización de desarrollo.

Dudas para clase
================

1. ¿Relación entre flujos de proceso, y modelos?
   **Motivo:** Flujo lineal = Modelo en cascada, Evolutivo = Espiral.
   **Respuesta:** El flujo es la parte teorica, y el modelo la implementacion
