---
title: "Tarea 2 - Herramientas para realizar pruebas"
author: "Pablo Sanchez Galdamez (21001135)"
---

> ¿Cuáles son las herramientas utilizadas en el mercado para realizar pruebas
> tanto manuales como automatizadas?

Para las pruebas manuales no se utilizan herramientas, sino que una persona se
encarga de interactuar con el software para hacer las pruebas.

Para las automatizadas, separaremos las herramientas por los tipos de prueba:

### Unitarias

Consisten en probar métodos y funciones individuales de las clases, componentes
o módulos que usa tu software. Cada lenguaje suele tener sus frameworks para
realizarlas, como por ejemplo:

* `Catch2` para `C++`
* `go test` para `go`
* `JUnit` para `Java`
* `mochajs` para `Javascript`
* `PyUnit` para `Python`

### De Integración

Las pruebas de integración verifican que los distintos módulos o servicios
utilizados por tu aplicación funcionan bien en conjunto. Ejemplos:

* `DBUnit` para `Java`
* `Hound` para `Javascript`
* `TestSwarm` para `PHP`
* `BuildBot` para `Python`
* `Google Test` para `C++`

### De rendimiento

Las pruebas de rendimiento evalúan el rendimiento de un sistema con una carga
de trabajo determinada. Ayudan a medir la fiabilidad, la velocidad, la
escalabilidad y la capacidad de respuesta de una aplicación.

* `JMeter`
* `Taurus`
* `Locust`
* `Fiddler`
* `nGrinder`
* `The Grinder`
* `Gatling`

### Fuzzing

Implica proporcionar datos inválidos, inesperados o aleatorios a las entradas
de un programa de ordenador. Entonces se monitorizan las excepciones tales como
caídas, aserciones de código erróneas, o para encontrar potenciales
filtraciones de memoria. La técnica de fuzzing se utiliza normalmente para
descubrir problemas de seguridad en software o sistemas de ordenadores.

1. PeachTech Peach Fuzzer
2. Google OSS-Fuzz
3. FuzzDB
4. Ffuf (Fuzz Faster U Fool)
5. Google ClusterFuzz 
6. go-fuzz
