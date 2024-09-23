package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import business.Aeroporto;

public class AeroportoTest {

    @Test
    public void testConstrutorAeroporto() {
        Aeroporto meuAeroporto = new Aeroporto("Aeroporto Internacional de Confins", "CNF", "Belo Horizonte", "Minas Gerais", "Brasil");
        assertEquals("Aeroporto Internacional de Confins", meuAeroporto.getNome());
        assertEquals("CNF", meuAeroporto.getSigla());
        assertEquals("Belo Horizonte", meuAeroporto.getCidade());
        assertEquals("Minas Gerais", meuAeroporto.getEstado());
        assertEquals("Brasil", meuAeroporto.getPais());
    }
}
