package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.Aeroporto;

public class AeroportoTest {

    private Aeroporto aeroporto;

    @BeforeEach
    public void setUp() {
        aeroporto = new Aeroporto();
    }

    @Test
    public void testSetNome() {
        boolean result = aeroporto.setNome("Aeroporto de Confins");
        assertTrue(result);
        assertEquals("Aeroporto de Confins", aeroporto.getNome());

        result = aeroporto.setNome("");
        assertFalse(result);
        assertNotEquals("", aeroporto.getNome());

        result = aeroporto.setNome("Aeroporto#123");
        assertFalse(result);
        assertNotEquals("Aeroporto#123", aeroporto.getNome());
    }

    @Test
    public void testSetSigla() {
        boolean result = aeroporto.setSigla("XYZ");
        assertTrue(result);
        assertEquals("XYZ", aeroporto.getSigla());
    }

    @Test
    public void testSetCidade() {
        boolean result = aeroporto.setCidade("Belo Horizonte");
        assertTrue(result);
        assertEquals("Belo Horizonte", aeroporto.getCidade());
    }

    @Test
    public void testSetEstado() {
        boolean result = aeroporto.setEstado("SP");
        assertTrue(result);
        assertEquals("SP", aeroporto.getEstado());
    }

    @Test
    public void testSetPais() {
        boolean result = aeroporto.setPais("Argentina");
        assertTrue(result);
        assertEquals("Argentina", aeroporto.getPais());
    }
}
