CREATE DATABASE actividad5;
USE actividad5;

/*
 * Las entidades fuertes son:
 * - Marca
 * - Proveedor
 * - Departamento
 */
 
CREATE TABLE marcas (
    id_marca int PRIMARY KEY NOT NULL,
    nombre varchar(30) NOT NULL
);

CREATE TABLE proveedores (
    id_proveedor int PRIMARY KEY NOT NULL,
    nombre varchar(30) NOT NULL
);

CREATE TABLE departamentos (
    id_departamento int PRIMARY KEY NOT NULL,
    nombre varchar(30) NOT NULL
);

-- Y ahora las entidades debiles

CREATE TABLE empleados (
    id_empleado int PRIMARY KEY NOT NULL,
    nombre varchar(30) NOT NULL,
    id_departamento int NOT NULL,
    
    INDEX(id_departamento),
    FOREIGN KEY(id_departamento) REFERENCES departamentos(id_departamento)
);

CREATE TABLE cañoneras (
    id_cañonera int PRIMARY KEY NOT NULL,
    fecha_ingreso date NOT NULL,
    
    id_marca int NOT NULL,
    INDEX(id_marca),
    FOREIGN KEY(id_marca) REFERENCES marcas(id_marca),
    
    modelo varchar(30) NOT NULL,
    no_serie int NOT NULL,
    fecha_compra date NOT NULL,
    años_garantia int NOT NULL,
    no_factura int NOT NULL,
    
    id_proveedor int NOT NULL,
    INDEX(id_proveedor),
    FOREIGN KEY(id_proveedor) REFERENCES proveedores(id_proveedor),
    
    persona_contacto varchar(30) NOT NULL,
    telefono char(9) NOT NULL,
    fecha_vencimiento_garantia date NOT NULL
);

CREATE TABLE prestamos (
    id_prestamo int PRIMARY KEY NOT NULL,
    
    id_cañonera int NOT NULL,
    INDEX(id_cañonera),
    FOREIGN KEY (id_cañonera) REFERENCES cañoneras(id_cañonera),
    
    id_empleado int NOT NULL,
    INDEX(id_empleado),
    FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado),
    
    fecha_entrega date NOT NULL,
    hora_entrega time NOT NULL,
    
    fecha_devolucion date NOT NULL,
    hora_devolucion time NOT NULL
);
