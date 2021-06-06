Validación de credenciales
==========================

El sistema debería recibir:

* El código del usuario
* El nombre del usuario
* La contraseña del usuario.

Luego verifica que en la base de datos exista un usuario que tenga ese nombre
y código. De no existir, envía un código error con el mensaje: "El usuario que
ingreso no existe, verifique que esta ingresando los datos correctos."

De existir, verifica que la contraseña que se ingreso sea igual a la que se
tiene almacenada. De ser diferentes, envía un código de error con el mensaje:
"La contraseña que ingreso es incorrecta. Inténtelo de nuevo"

De ser iguales, indica que las credenciales son validas.

Consulta a cuenta
=================

El sistema debería recibir un numero de cuenta.

Si la cuenta no existe, regresa un código de error y el siguiente mensaje: "No
se ha encontrado la cuenta".

De existir se envían los detalles de la cuenta.

Validación de cheques
=====================

El sistema debería leer del contenido del cheque lo siguiente:

* Numero del cheque
* El numero de cuenta
* El propietario de la cuenta
* El lugar y fecha
* El monto
* La firma

Se realiza una consulta (Ver: 'Consulta a cuenta'), usando el numero de cuenta.
Si la consulta no es exitosa se retorna el mismo error y mensaje que retorno la
consulta. Si es exitosa se proceden a hacer las siguientes validaciones:
   
1. Que el propietario de la cuenta en el cheque sea el mismo que se tiene
   guardado en el banco. De no existir regresa un código de error y el mensaje:
   "El propietario de la cuenta no coincide con el que tiene el cheque".

2. Que la firma del propietario coincida con la que esta en el cheque. De no
   existir regresa un código de error y el mensaje: "No coinciden las firmas".

3. Que no hayan pasado 6 meses desde la fecha que tiene escrita el cheque. De
   no existir regresa un código de error y el mensaje: "Han pasado 6 meses
   desde la emisión".

De haber pasado las validaciones, se indica que el cheque es valido.

Creación de recibo
==================

El sistema debería recibir los detalles de la transacción:

Se toma el siguiente template:

~~~
                                Banco
                              (sucursal)
--------------------------------------------------------------------------------
Cajero: (Id Cajero)
Fecha: (Fecha actual)
--------------------------------------------------------------------------------

Se ha cobrado el cheque (no cheque) por (monto) de la cuenta (no cuenta del
cheque), y se han transferido los fondos a la cuenta (no cuenta del usuario).
~~~

Y se remplazando lo que esta entre paréntesis con su correspondiente valor.
Luego se envía a imprimir.

Inicio de Sesión
================

El sistema debería solicitar:

* El código del usuario
* El nombre del usuario
* La contraseña del usuario.

Y realiza una solicitud para validar las credenciales (Ver: 'Validación de
credenciales'). Si se retorna un código que indica error, se le muestra al
usuario el mensaje y se solicita que vuelva a ingresar sus credenciales.

De validarse correctamente las credenciales se le permite continuar.

Deposito de cheques
===================

El sistema debería recibir un cheque.

Se procede a validar el cheque (Ver: 'Validación de cheques'). Si el código
retornado indica un error se imprime una boleta con el mensaje, se devuelve el
cheque, y se refiere al usuario a un empleado del banco para que le brinde ayuda.

Luego se realiza una consulta a la cuenta del cheque (Ver: 'Consulta a cuenta')
para ver que tenga fondos suficientes. Si la cuenta no tiene fondos suficientes
se imprime una boleta con el mensaje: "La cuenta no tiene suficientes fondos",
se devuelve el cheque, y se refiere al usuario a un empleado del banco para que
le brinde ayuda.

De tener fondos suficientes se le solicita nuevamente la contraseña al usuario
y se valida que sea correcta (Ver: 'Validación de credenciales'). De ser
correcta:

1. Se realiza la transferencia
2. Se muestra en pantalla el estado de cuenta de el usuario (Ver: 'Consulta
   a cuenta')
3. Se imprime un recibo (Ver: 'Creación de recibo')
