USE mysql;

-- Crea un usuario en MYSQL con su primer nombre y primer apellido en localhost, no asigne password
CREATE USER pabloSanchez@localhost;
SELECT * FROM user; -- En cada uno de los pasos muestre los usuarios

-- Asigne un password a este usuario
SET PASSWORD FOR pabloSanchez@localhost = 'galileo';
SELECT * FROM user;

-- Asigne todos los permisos en todas las bases de datos a este usuario
GRANT ALL PRIVILEGES ON *.* TO pabloSanchez@localhost;
SELECT * FROM user;

-- Cambie el nombre del usuario agregándole el número 1 al final
UPDATE user
SET user = "pabloSanchez1"
WHERE user = "pabloSanchez" and host = "localhost";
SELECT * FROM user;

-- Cambie el password del usuario por el password TEC2015
FLUSH PRIVILEGES; -- mysql me tira un error al actualizar el password solo asi
                  -- La solucion la tome de:
                  -- https://stackoverflow.com/questions/12877458/mysql-error-1133-cant-find-any-matching-row-in-the-user-table
SET PASSWORD FOR pabloSanchez1@localhost = 'TEC2015';
SELECT * FROM user;

-- Revoque los permisos al usuario
REVOKE ALL PRIVILEGES ON *.* FROM pabloSanchez1@localhost;
SELECT * FROM user;

-- Elimine el usuario
DROP USER pabloSanchez1@localhost;
SELECT * FROM user;