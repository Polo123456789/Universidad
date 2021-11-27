# Proyecto final

Necesita tener Maven instalado, y tener la variable de entorno `JAVA_PATH`
señalando el path donde tenga el JDK.

Los proyectos se generaron con:

```
mvn archetype:generate \
        -DarchetypeGroupId=org.openjfx \
        -DarchetypeArtifactId=javafx-archetype-fxml \
        -DarchetypeVersion=0.0.6 \
        -DgroupId=com.poo2 \
        -DartifactId=encuesta \
        -Dversion=1.0.0

mvn archetype:generate \
        -DarchetypeGroupId=org.openjfx \
        -DarchetypeArtifactId=javafx-archetype-fxml \
        -DarchetypeVersion=0.0.6 \
        -DgroupId=com.poo2 \
        -DartifactId=ver_resultados \
        -Dversion=1.0.0
```

Para correr cada uno de los proyectos dentro de sus respectivas carpetas corra
el comando:

```
mvn clean javafx:run
```

Base de datos
-------------

De no haber un archivo `db.sqlite3`, puede crearlo con:

```
cat .\scripts\create-db.sql | sqlite3.exe db.sqlite3
```

Para que el uso con los programas sea mas facil recomendaria que haga un link
simbolico de el archivo en las carpetas `encuesta` y `ver_resultados`.
