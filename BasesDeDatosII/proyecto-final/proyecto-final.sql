-- Proyecto final

-- ----------------------------------------------------------------------------
--                                  Tablas
-- ----------------------------------------------------------------------------
CREATE DATABASE ControlPersonal;
USE ControlPersonal;

CREATE TABLE Departamento (
    CodDepto int PRIMARY KEY NOT NULL,
    NombreDepto varchar(45),
    Descripcion varchar(90),
    CantEmpleados int
);

CREATE TABLE Puesto (
    CodPuesto int PRIMARY KEY NOT NULL,
    NombrePuesto varchar(45),
    Descrip varchar(90),
    SueldoBase double,
    Bono double,
    Bonificacion double
);

CREATE TABLE Personal (
    CodPersona int PRIMARY KEY NOT NULL,
    Nombres varchar(45),
    Apellidos varchar(45),
    CorreoE varchar(45),
    FechaNacimiento date
);

CREATE TABLE Asigna (
    CodAsigna int PRIMARY KEY NOT NULL,
    CodPersona int NOT NULL,
    CodDepto int NOT NULL,
    CodPuesto int NOT NULL,
    FechaAsigna date,
    FechaInicioLab date,
    
    FOREIGN KEY (CodPersona) REFERENCES Personal(CodPersona),
    FOREIGN KEY (CodDepto) REFERENCES Departamento(CodDepto),
    FOREIGN KEY (CodPuesto) REFERENCES Puesto(CodPuesto)
);

-- ----------------------------------------------------------------------------
--                                 Registros
-- ----------------------------------------------------------------------------

INSERT INTO Puesto VALUES
    (
        1,
        "Supervisor",
        "Encargado de la supervision",
        10000.00,
        150.00,
        35.50
    ),
    (
        2,
        "Administrador de Redes",
        "Encargado de las redes",
        5000.00,
        150.00,
        00.00
    ),
    (
        3,
        "Administrador de Proyectos",
        "Encargado de supervisar el progreso de los proyectos",
        6000.00,
        150.00,
        00.00
    ),
    (
        4,
        "Gerente",
        "Encargado de supervisar una franquicia",
        5000.00,
        150.00,
        00.00
    ),
    (
        5,
        "Cajero",
        "Encargado de cobrarle a los clientes",
        3500.00,
        150.00,
        00.0
    );
    
INSERT INTO Departamento VALUES
    (
        1,
        "Contabilidad",
        "Gestion de las cuentas de la empresa",
        10
    ),
    (
        2,
        "Ventas",
        "Gestiona la entrada y salida de productos",
        15
    ),
    (
        3,
        "Publicidad",
        "Se encarga de la publicidad de la empresa",
        5
    ),
    (
        4,
        "Limpieza",
        "Se encarga de la sanitizacion de las franquicias",
        30
    ),
    (
        5,
        "Recursos Humanos",
        "Supervisa los demas departamentos",
        10
    );
    
INSERT INTO Personal VALUES
    (
        1,
        "Pablo",
        "Sanchez Galdamez",
        "some_mail@example.com",
        "2002-09-11"
    ),
    (
        2,
        "Pedro",
        "Martinez Morales",
        "other.mail@example.com",
        "2003-11-12"
    ),
    (
        3,
        "Juan",
        "Martinez Morales",
        "example@[164.135.0.100]",
        "2001-01-09"
    ),
    (
        4,
        "Andrez",
        "Sanchez Galdamez",
        '" "@exmample.org',
        "1999-01-01"
    ),
    (
        5,
        "Carlos",
        "Martinez Morales",
        "carlos@mail.com",
        "1998-08-08"
    );

INSERT INTO Asigna VALUES
    (
        1,
        1,
        1,
        1,
        CURDATE(),
        CURDATE()
    ),
    (
        2,
        2,
        2,
        2,
        CURDATE(),
        CURDATE()
    ),
    (
        3,
        3,
        3,
        3,
        CURDATE(),
        CURDATE()
    ),
    (
        4,
        4,
        4,
        4,
        CURDATE(),
        CURDATE()
    ),
    (
        5,
        5,
        5,
        5,
        CURDATE(),
        "2021-08-08" -- Para tener que enseñar en la seccion de subconsultas
    );

-- ----------------------------------------------------------------------------
--                                  Indices
-- ----------------------------------------------------------------------------

CREATE UNIQUE INDEX IndexCodPersona ON Personal(CodPersona);
CREATE UNIQUE INDEX IndexCodAsigna ON Asigna(CodAsigna);
CREATE UNIQUE INDEX IndexCodPuesto ON Puesto(CodPuesto);
CREATE UNIQUE INDEX IndexCodDepto ON Departamento(CodDepto);
CREATE INDEX IndexPersonalNombresApellidos ON Personal(Nombres, Apellidos);
CREATE INDEX IndexPuestoNombrePuesto ON Puesto(NombrePuesto);
CREATE INDEX IndexDepartamentoNombreDepartamento ON Departamento(NombreDepto);

-- ----------------------------------------------------------------------------
--                                  Usuarios
-- ----------------------------------------------------------------------------

CREATE USER 'personal'@'%' IDENTIFIED BY "galileo";
GRANT SELECT, DELETE, UPDATE, INSERT ON ControlPersonal.* TO 'personal'@'%';

CREATE USER 'admin'@'%' IDENTIFIED BY "galileo";
GRANT ALL PRIVILEGES ON *.* TO 'admin'@'%';

CREATE USER 'auditor'@'%' IDENTIFIED BY "galileo";
GRANT SELECT ON ControlPersonal.* TO 'auditor'@'%';

CREATE USER 'backup'@'%' IDENTIFIED BY "galileo";
-- El proyecto no especifica si es en todas las bases de datos, pero como
-- se le da el permiso `SHOW DATABASES` supogo que asi sera.
GRANT EVENT, LOCK TABLES, SELECT, SHOW DATABASES ON *.* TO 'backup'@'%';

-- ----------------------------------------------------------------------------
--                              Subconsultas
-- ----------------------------------------------------------------------------

SELECT * FROM Puesto WHERE SueldoBase < (SELECT AVG(SueldoBase) FROM Puesto);

SELECT * FROM Puesto WHERE 
    SueldoBase < (SELECT MAX(SueldoBase) FROM Puesto 
        WHERE NombrePuesto LIKE "Administrador%");


SELECT Nombres, Apellidos FROM Personal P WHERE
    MONTH(
        (SELECT FechaInicioLab FROM Asigna 
            WHERE CodPersona = P.CodPersona)
    ) = 8; 

-- ----------------------------------------------------------------------------
--                                 Vistas
-- ----------------------------------------------------------------------------

CREATE VIEW PersonalPuesto AS
    SELECT Pe.Nombres AS "Nombres",
           Pe.Apellidos AS "Apellidos",
           Pu.NombrePuesto AS "Puesto",
           Pu.SueldoBase AS "Sueldo"
    FROM Personal Pe INNER JOIN Puesto Pu
    ON Pu.CodPuesto = (SELECT CodPuesto FROM Asigna 
                       WHERE CodPersona = Pe.CodPersona);

-- ----------------------------------------------------------------------------
--                       Funciones y procedimientos
-- ----------------------------------------------------------------------------

DELIMITER //
CREATE FUNCTION fnbono(sueldoBase int) RETURNS double
DETERMINISTIC
NO SQL
BEGIN
    RETURN sueldoBase*0.1;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE InsertarPuesto(CodPuesto int,
                                NombrePuesto varchar(45),
                                Descrip varchar(90),
                                SueldoBase double,
                                Bonificacion double)
BEGIN
    INSERT INTO Puesto VALUES (CodPuesto,
                               NombrePuesto,
                               Descrip, 
                               SueldoBase,
                               fnbono(SueldoBase),
                               Bonificacion);
END//
DELIMITER ;

-- ----------------------------------------------------------------------------
--                                Triggers
-- ----------------------------------------------------------------------------

CREATE TABLE Bitacora (
    Id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    CodPersona int,
    Fecha datetime,
    Usuario varchar(45)
);

DELIMITER //
CREATE TRIGGER TgRegistrarEliminacionDePersona
BEFORE DELETE ON Personal
FOR EACH ROW
BEGIN
    INSERT INTO Bitacora (CodPersona, Fecha, Usuario)
    VALUES (old.CodPersona, NOW(), SESSION_USER());
END//
DELIMITER ;

-- ----------------------------------------------------------------------------
--                                 Cleanup
-- ----------------------------------------------------------------------------

DROP USER 'backup'@'%';
DROP USER 'auditor'@'%';
DROP USER 'admin'@'%';
DROP USER 'personal'@'%';
DROP DATABASE ControlPersonal;
