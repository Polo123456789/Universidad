package poo.proyecto_final;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class InputTest {
    @Test
    public void identificaNombresValidos() {
        String[] nombresValidos = {
            "Pedro",
            "Carlos",
            "Andres",
            "Alvaro Martinez",
            "Alvaro Martinez Perez",
            "Escuela Politecnica",
            "Tecnico en Desarrollo de Software",
            "Programacion Orientada a objetos I"
        };

        for (String s : nombresValidos) {
            assertTrue(Input.nombreValido(s));
        }
    }

    @Test
    public void identificaNombresInvalidos() {
        String[] nombresInvalidos = {
            "Pedro111",
            "Carlos33",
            "Andr.,es",
            "Alvarllo_Martinez1",
            "",
            "Algo77!"
        };

        for (String s : nombresInvalidos) {
            assertFalse(Input.nombreValido(s));
        }
    }
}
