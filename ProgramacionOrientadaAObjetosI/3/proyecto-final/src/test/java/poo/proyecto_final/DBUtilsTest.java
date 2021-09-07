package poo.proyecto_final;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class DBUtilsTest {

    static private final String[] listaArchivos = {
        "no-se-porque-tendiras-un-archivo-llamado-asi-lkdsjfldj.sql",
        "definitivamente-este-tampoco-existe-lkjflsdjfldj.sql",
        "todos-tienen-texto-al-azar-al-final-kjfaslfjsadkfj.sql",
        "para-asegurar-de-que-no-choquen-los-nombres-jdl.sql"
    };

    @Test
    public void indicaArchivosQueNoExisten() {
        for (String s : listaArchivos) {
            Path p = Paths.get(s);
            assertFalse(DBUtils.archivoExiste(p));
        }
    }

    @Test
    public void indicaArchivosQueExisten() {
        // Al `mvn test` en el root del proyecto, estos son archivos que fijo
        // estan ahi.
        assertTrue(DBUtils.archivoExiste(Paths.get("pom.xml")));
        assertTrue(DBUtils.archivoExiste(Paths.get("README.md")));
        assertTrue(DBUtils.archivoExiste(Paths.get(".gitignore")));
    }
}
