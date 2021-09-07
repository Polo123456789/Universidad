package poo.proyecto_final;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

/**
 * Utilidades para gestionar la base de datos
 */
final public class DBUtils {

    private DBUtils() {}

    public static final String dbName = "data.sqlite";
    public static final String connectionString = "jdbc:sqlite:" + dbName;

    /**
     * Revisa si un archivo existe en el sistema
     *
     * Este se usara al principio para asegurarse de que tenemos una base de
     * datos disponible
     */
    public final static boolean archivoExiste(Path path) {
        File test = new File(path.toUri());
        return test.exists();
    }

    public final static boolean existeLaDB() {
        return archivoExiste(Paths.get(dbName));
    }

    public final static boolean seTieneElDriver() {
        try {
            Class.forName("org.sqlite.JDBC");
            return true;
        } catch (final ClassNotFoundException e) {
            return false;
        }
    }

    // Este codigo fue creado utilizando una herramienta a base del archivo
    // "create-db.sql" Si quiere cambiarlo, modifique el archivo original y
    // vuelva a correr la herramienta
    static public final String querysParaCrearTablas =
        "CREATE TABLE decano (\n" +
        "    id integer PRIMARY KEY,\n" +
        "    nombre text,\n" +
        "    apellidos text\n" +
        ");\n" +
        "\n" +
        "CREATE TABLE profesor (\n" +
        "    id integer PRIMARY KEY,\n" +
        "    nombre text,\n" +
        "    apellidos text\n" +
        ");\n" +
        "\n" +
        "CREATE TABLE horario (\n" +
        "    id integer PRIMARY KEY,\n" +
        "    aula integer NOT NULL,\n" +
        "    dia integer NOT NULL,\n" +
        "    inicio integer NOT NULL,\n" +
        "    final integer NOT NULL\n" +
        ");\n" +
        "\n" +
        "CREATE TABLE escuelaAcademica (\n" +
        "    id integer PRIMARY KEY,\n" +
        "    nombre text\n" +
        ");\n" +
        "\n" +
        "CREATE TABLE curso (\n" +
        "    id integer PRIMARY KEY,\n" +
        "    nombre text,\n" +
        "    idHorario integer NOT NULL,\n" +
        "    idProfesor integer NOT NULL,\n" +
        "    FOREIGN KEY(idHorario) REFERENCES horario(id),\n" +
        "    FOREIGN KEY(idProfesor) REFERENCES profesor(id)\n" +
        ");\n" +
        "\n" +
        "CREATE TABLE carrera (\n" +
        "    id integer PRIMARY KEY,\n" +
        "    nombre text,\n" +
        "    idDecano integer NOT NULL,\n" +
        "    idEscuela integer NOT NULL,\n" +
        "    FOREIGN KEY(idDecano) REFERENCES decano(id),\n" +
        "    FOREIGN KEY(idEscuela) REFERENCES escuelaAcademica(id)\n" +
        ");\n" +
        "\n" +
        "CREATE TABLE director (\n" +
        "    id integer PRIMARY KEY,\n" +
        "    nombre text,\n" +
        "    apellidos text,\n" +
        "    idCarrera integer NOT NULL,\n" +
        "    FOREIGN KEY(idCarrera) REFERENCES carrera(id)\n" +
        ");\n" +
        "\n" +
        "CREATE TABLE carreraTieneCurso (\n" +
        "    idCarrera integer NOT NULL,\n" +
        "    idCurso integer NOT NULL,\n" +
        "    FOREIGN KEY(idCarrera) REFERENCES carrera(id),\n" +
        "    FOREIGN KEY(idCurso) REFERENCES curso(id),\n" +
        "    PRIMARY KEY(idCarrera, idCurso)\n" +
        ");\n";
}
