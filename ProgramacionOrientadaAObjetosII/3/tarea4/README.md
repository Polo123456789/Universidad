# Tarea 4

Necesita tener Maven instalado, y tener la variable de entorno `JAVA_PATH`
señalando el path donde tenga el JDK.

Generado con:

```
mvn archetype:generate \
        -DarchetypeGroupId=org.openjfx \
        -DarchetypeArtifactId=javafx-archetype-fxml \
        -DarchetypeVersion=0.0.6 \
        -DgroupId=com.poo2 \
        -DartifactId=tarea4 \
        -Dversion=1.0.0
```

Para correr el proyecto use el comando:

```
mvn clean javafx:run
```

De no haber un archivo `db.sqlite3` puede crearlo con:

```
cat .\scripts\create-db.sql | sqlite3.exe .\db.sqlite3
```
