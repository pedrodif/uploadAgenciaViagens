package test;

import org.junit.Test;
import static org.junit.Assert.*;
import business.Aeronave;

public class AeronaveTest {

    // Teste de sucesso para valores válidos
    @Test
    public void testAeronaveCriadaComSucesso() throws Exception {
        Aeronave aeronave = new Aeronave(12, 2000); // Capacidade de passageiros múltipla de 6
        assertEquals(12, aeronave.getCapacidadePassageiros());
    }

    // Teste de exceção para valores inválidos de capacidade de passageiros
    @Test(expected = IllegalArgumentException.class)
    public void testAeronaveCapacidadePassageirosInvalida() throws Exception {
        new Aeronave(10, 1500); // Capacidade de passageiros NÃO múltipla de 6
    }

    // Teste para setCapacidadePassageiros
    @Test
    public void testSetCapacidadePassageiros() throws Exception {
        Aeronave aeronave = new Aeronave(12, 2000);
        aeronave.setCapacidadePassageiros(18);
        assertEquals(18, aeronave.getCapacidadePassageiros());
    }

    // Teste para setCapacidadeCargaKg
    @Test
    public void testSetCapacidadeCargaKg() throws Exception {
        Aeronave aeronave = new Aeronave(12, 2000);
        aeronave.setCapacidadeCargaKg(3000);
        assertEquals(3000, aeronave.getCapacidadeCargaKg());
    }
}

