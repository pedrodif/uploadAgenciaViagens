package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.Aeroporto;
import business.CiaAerea;
import business.Voo;


public class AeroportoTest {

    private Aeroporto aeroporto;

    @BeforeEach
    public void setUp() {
        aeroporto = new Aeroporto("Aeroporto Internacional", "ABC", "Betim", "MG", "Brasil");
    }

    @Test
    public void testGetNome() {
        assertEquals("Aeroporto Internacional", aeroporto.getNome());
    }

    @Test
    public void testSetNome() {
        aeroporto.setNome("Novo Aeroporto");
        assertEquals("Novo Aeroporto", aeroporto.getNome());
    }

    @Test
    public void testGetSigla() {
        assertEquals("ABC", aeroporto.getSigla());
    }

    @Test
    public void testSetSigla() {
        aeroporto.setSigla("XYZ");
        assertEquals("XYZ", aeroporto.getSigla());
    }

    @Test
    public void testGetCidade() {
        assertEquals("Betim", aeroporto.getCidade());
    }

    @Test
    public void testSetCidade() {
        aeroporto.setCidade("Belo Horizonte");
        assertEquals("Belo Horizonte", aeroporto.getCidade());
    }

    @Test
    public void testGetEstado() {
        assertEquals("MG", aeroporto.getEstado());
    }

    @Test
    public void testSetEstado() {
        aeroporto.setEstado("SP");
        assertEquals("SP", aeroporto.getEstado());
    }

    @Test
    public void testGetPais() {
        assertEquals("Brasil", aeroporto.getPais());
    }

    @Test
    public void testSetPais() {
        aeroporto.setPais("Argentina");
        assertEquals("Argentina", aeroporto.getPais());
    }
}
