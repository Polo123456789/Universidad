# Tarea 3

Necesita tener Maven instalado, y tener la variable de entorno `JAVA_PATH`
señalando el path donde tenga el JDK.

Generado con:

```
mvn archetype:generate \
        -DarchetypeGroupId=org.openjfx \
        -DarchetypeArtifactId=javafx-archetype-fxml \
        -DarchetypeVersion=0.0.6 \
        -DgroupId=com.poo2 \
        -DartifactId=tarea3 \
        -Dversion=1.0.0
```

Para correr el proyecto use el comando:

```
mvn clean javafx:run
```
