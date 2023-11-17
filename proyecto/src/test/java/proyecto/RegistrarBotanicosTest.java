package proyecto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RegistrarBotanicosTest {

    @Test
    public void testRegistrarBotanicos() {

        RegistrarBotanicos registrarBotanicos = new RegistrarBotanicos();
        Botanicos resultado = registrarBotanicos.registrarBotanicos();
        Botanicos esperado = new Botanicos("Juan", "Gomez", "12345", "user@gmail.com", "98765");
        assertNotNull(resultado);
        assertEquals(esperado.getNombre(), resultado.getNombre());
    }
}

