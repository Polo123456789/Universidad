CREATE TABLE preguntas (
    id integer PRIMARY KEY NOT NULL,
    texto text
);

INSERT INTO preguntas (texto) VALUES
    ("Nos recomendarias a tus amigos?"),
    ("Como valorarias la atencion de nuestro personal?"),
    ("Que opinas del tiempo de espera para ser atendido?"),
    ("Como valorarias nuestra relacion calidad-precio?"),
    ("En general, como valoras la limpieza de la tienda?");

CREATE TABLE respuestas (
    id integer PRIMARY KEY NOT NULL,
    id_pregunta integer NOT NULL,
    respuesta integer NOT NULL,
    fecha text NOT NULL,

    FOREIGN KEY(id_pregunta) REFERENCES preguntas(id)
);
