CREATE TABLE decano (
    id integer PRIMARY KEY,
    nombre text,
    apellidos text
);

CREATE TABLE profesor (
    id integer PRIMARY KEY,
    nombre text,
    apellidos text
);

CREATE TABLE horario (
    id integer PRIMARY KEY,
    aula integer NOT NULL,
    dia integer NOT NULL,
    inicio integer NOT NULL,
    final integer NOT NULL
);

CREATE TABLE escuelaAcademica (
    id integer PRIMARY KEY,
    nombre text
);

CREATE TABLE curso (
    id integer PRIMARY KEY,
    nombre text,
    idHorario integer NOT NULL,
    idProfesor integer NOT NULL,
    FOREIGN KEY(idHorario) REFERENCES horario(id),
    FOREIGN KEY(idProfesor) REFERENCES profesor(id)
);

CREATE TABLE carrera (
    id integer PRIMARY KEY,
    nombre text,
    idDecano integer NOT NULL,
    idEscuela integer NOT NULL,
    FOREIGN KEY(idDecano) REFERENCES decano(id),
    FOREIGN KEY(idEscuela) REFERENCES escuelaAcademica(id)
);

CREATE TABLE director (
    id integer PRIMARY KEY,
    nombre text,
    apellidos text,
    idCarrera integer NOT NULL,
    FOREIGN KEY(idCarrera) REFERENCES carrera(id)
);

CREATE TABLE carreraTieneCurso (
    idCarrera integer NOT NULL,
    idCurso integer NOT NULL,
    FOREIGN KEY(idCarrera) REFERENCES carrera(id),
    FOREIGN KEY(idCurso) REFERENCES curso(id),
    PRIMARY KEY(idCarrera, idCurso)
);
