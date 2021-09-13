Proyecto Final
==============

Para compilar necesita [Maven](https://maven.apache.org/).

Para compilar tiene que correr el comando:

```
mvn clean compile assembly:single
```

Y para correr usa el comando:

```
java -cp .\target\proyecto-final-1.0-SNAPSHOT-jar-with-dependencies.jar poo.proyecto_final.App
```

O si no tiene con que compilarlo, puede correr el jar que ya trae, que seria
con el comando:

```
java -cp .\poo-proyecto_final.jar poo.proyecto_final.App
```
