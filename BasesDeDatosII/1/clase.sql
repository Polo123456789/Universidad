-- Administar usuarios, back ups y logs
-- La base de datos para el ejemplo esta a base de `dump-ejemplo-clase.sql`


USE colegio;

/*
Usuarios
========

Los usuarios se pueden crear de 2 formas. Con instrucciones SQL, y desde la GUI.

MySql guarda los usuarios en una base de datos llamada mysql

*/

USE mysql;
SELECT * FROM user;

-- Creacion de usuario:
-- CREATE USER 'name'@'%' IDENTIFIED BY 'password'; (el % indica que se puede conectar desde 
--                                                  cualquier maquina, puede cambiar por 
--                                                  localhost para que solo pueda concectarse
--                                                  en esta maquina)
CREATE USER	'carlos'@'%' IDENTIFIED BY 'galileo';

-- Para ver los permisos
SHOW GRANTS FOR 'carlos'@'%';

-- Puedes darle permisos
GRANT SELECT, INSERT, DELETE, UPDATE ON colegio.cursos TO 'carlos'@'%';

-- Y se pueden eliminar los usuarios (TODO: Borrar el usuario extra, al final de clase)
DROP USER 'carlos'@'%';

-- Este usuario lo usaremos para los ejemplos de backup luego
CREATE USER 'backup'@'localhost' IDENTIFIED BY 'galileo';
GRANT INSERT, 
      ALTER, 
      REFERENCES, 
      DROP, 
      PROCESS,
      EVENT,
      LOCK TABLES,
      SELECT,
      SHOW DATABASES
ON *.* TO 'backup'@'localhost';
SHOW GRANTS FOR 'backup'@'localhost';

-- Se puede usar mysqldump para hacer los backups.
-- Ejemplo: mysqldump -u backup -p galileo -r archivo.sql database table
-- Y con esos backups se puede restaurar la base de datos simplemente corriendo el script.

DROP USER 'backup'@'localhost';

-- Los logs se pueden ver desde workbench
