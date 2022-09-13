===========
Actividad 5
===========

Que es Semantic Versioning?
===========================

Sin el cumplimiento de alguna especie de especificación formal, los números de
versión son esencialmente inútiles para el manejo de dependencias. Si se les da
un nombre y una definición a cada uno, es mucho mas fácil comunicar a los
usuarios las intenciones del programador, y lo mas importante, le permite al
usuario entender fácilmente que versiones de la API publica con compatibles
entre ellas.

Los 2 frameworks de testing mas utilizados
==========================================

1. Serenity (Java)
2. Cypress (Javascript)

Ventajas y desventajas
----------------------

.. list-table::
    :header-rows: 1
    :widths: 1 2 2 

    -  *  
       *  Ventajas
       *  Desventajas
    
    -  
       *  Serenity
    
       *  *  Escribir test flexibles y fáciles de mantener
          *  Genera informes ilustrativos sobre las pruebas
          *  Ajusta las pruebas a las necesidades del proyecto
          *  Tiene pruebas de cobertura
    
       *  *  Los archivos de característica toman mucho tiempo para ser creados
          *  La documentación de los test también necesita mantenimiento
          *  El código de las automatizaciones toma mas tiempo
    
    -  
    
       *  Cypress
    
       *  * Captura snapshots durante los tests para ayudar al debug de los
            mismos
          * Provee soporte para todos los navegadores
          * Ejecuta en tiempo real el código mientras el programador escribe
            comandos.
          * Tiene una excelente documentación.
    
       *  * No puede correr en 2 navegadores a la vez
          * No permite usar varias tabs
          * Únicamente puedes escribir los tests en javascript.

Método de procedimiento
=======================

+-----------------+-------------------+---------------+---------------+
| Fecha Propuesta | Nombre del cambio | Responsable   | Ejecutor      |
+=================+===================+===============+===============+
| 11/09/2022      | Instalación nginx | Pablo Sanchez | Pablo Sanchez |
+-----------------+-------------------+---------------+---------------+

Descripción/Justificación del cambio
------------------------------------

La instalación del servidor nginx es necesario para implementar la pagina web
de la empresa.

Pasos requeridos para implementar el cambio
-------------------------------------------

1. Actualizar el sistema operativo

   .. code:: sh

    sudo yum update

2. Crear o editar el archivo encontrado en ``/etc/yum.repos.d/nginx.repo``
   y escribir lo siguiente al final del archivo:

  .. code:: ini

    [nginx]
    name=nginx repo
    baseurl=http://nginx.org/packages/mainline/rhel/7/$basearch/
    gpgcheck=0
    enabled=1

3. Instalar ``nginx``

  .. code:: sh
    
    sudo yum install nginx

4. Iniciar ``nginx``

  .. code:: sh
    
    sudo systemctl start nginx

5. Activar los puertos 80 y 443:

  .. code:: sh

    sudo firewall-cmd --permanent --zone=public --add-service=http
    sudo firewall-cmd --permanent --zone=public --add-service=https
    sudo firewall-cmd --reload

Pasos requeridos para validar el cambio
---------------------------------------

1. Validar que el status tenga el valor de activo en la salida del comando:

  .. code:: sh
    
    sudo systemctl status nginx

Pasos para Rollback en caso de falla
------------------------------------

Si se instalo y esta corriendo, correr el siguiente comando:

.. code:: sh

    sudo systemctl stop nginx
    sudo yum remove nginx

Si no esta corriendo, únicamente se instalo, omita el primer comando.

De no instalarse, remueva lo que agrego en el archivo
``/etc/yum.repos.d/nginx.repo``.
