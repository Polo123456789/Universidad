Que es PWA?
===========

Progressive web apps (PWA) o aplicación web progresiva es una solución basada
en la web tradicional que todos conocemos, aunque incorpora algunas
particularidades que la hacen parecerse a una app nativa para teléfonos móviles
y tabletas.

Que necesito para elaborar una Progressive Web App?
===================================================

Nuestra aplicación tiene que:

* Utilizar el protocolo HTTPS
* Tener uno o mas service workers
* Tener un archivo de manifiesto

Uso de HTTPS
------------

Es necesario que se utilice el protocolo HTTPS para asegurar que el sitio sea
de confianza, y para asegurar las transacciones realizadas.

Service Workers
---------------

Los service workers son scripts que controlan el manejo de las solicitudes.
Estos manejan cosas como la cache del navegador, para que las paginas siempre
carguen rápidamente o incluso se puedan usar sin conexión.

Manifiesto
----------

Este archivo es necesario porque indica como se tiene que mostrar la aplicación
a los usuarios. En formato ``JSON`` se colocan datos como:

* Nombre de la aplicación
* Descripción
* Iconos (De diferentes tamaños)
* Orientación del dispositivo

Que otras herramientas sustituyen el uso de progressive web apps?
=================================================================

Desarrollo Nativo
-----------------

Las aplicaciones nativas se les llama así porque se desarrollan para un sistema
operativo en especifico. Lo más habitual es crear dos aplicaciones, una para
Android y otra para iOS pero que a nivel de diseño, funcionalidades
y experiencia de usuario sean iguales.

Desarrollo Híbrido
------------------

A las aplicaciones híbridas se les llama así porque se desarrollan para correr
en distintos entornos. Estas se suelen desarrollar con tecnologías web,
utilizando componentes de frameworks que permiten que el mismo código se adapte
a varias plataformas.

PNI
===

.. list-table::
    :header-rows: 1

    -   * Positivo
        * Negativo
        * Interesante
    -   *   * Únicamente hay que escribir el código una vez
            * Utiliza tecnologías con la que la mayoría de los desarrolladores
              están familiarizados
        *   * Son mas lentas que las aplicaciones nativas
            * No tienen el mismo acceso al hardware ni al OS que puede tener una
              aplicación nativa
        *   * Se puede utilizar sin Internet
            * Es una alternativa mas simple a las aplicaciones híbridas

