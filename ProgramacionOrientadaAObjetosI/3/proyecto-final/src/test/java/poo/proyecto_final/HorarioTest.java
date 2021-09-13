package poo.proyecto_final;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HorarioTest {
    @Test
    public void identificaHorariosQueInterfieren() {
        Horario h1 = new Horario(0, 600, 730);
        Horario h2 = new Horario(0, 700, 830);

        assertTrue(h1.interfiereCon(h2));
    }

    @Test
    public void noIdentificaHorariosQueNoInterfieren() {
        Horario h1 = new Horario(0, 600, 730);
        Horario h2 = new Horario(0, 800, 900);

        assertFalse(h1.interfiereCon(h2));
    }
}
