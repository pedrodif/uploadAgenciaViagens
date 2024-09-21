package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import business.Tarifa;

public class TarifaTest {
    private Tarifa tarifa;

    @BeforeEach
    public void configTarifa() throws Exception {
        this.tarifa = new Tarifa("internacional", "real");
    }
 
    @Test
    void testSetBasica() throws Exception {
        this.tarifa.setBasica(500.00);
        assertEquals(90.58, this.tarifa.getBasica());
    }

    @Test
    void testSetBusiness() throws Exception {
        this.tarifa.setBusiness(750);
        assertEquals(135.87, this.tarifa.getBusiness());
    }

    @Test
    void testSetPremium() throws Exception {
        this.tarifa.setPremium(950);
        assertEquals(172.1, this.tarifa.getPremium());
    }
    
    @Test
    void testSetBagagem() throws Exception {
        this.tarifa.setBagagem(200);
        assertEquals(36.23, this.tarifa.getBagagem());
    }

    @Test
    void testSetBagagemAdicional() throws Exception {
        this.tarifa.setBagagemAdicional(350);
        assertEquals(63,40, this.tarifa.getBagagemAdicional());
    }

    @Test
    void testCriarTarifaSucesso() throws Exception {
        assertNotNull(new Tarifa("internacional", "dolar"));
    }

    @Test
    void testCriarTarifaPrimeiroErro() {
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> new Tarifa("nacional", "real"));
        assertEquals(excecao.getMessage(), "Tipo do voo inválido.");
    }

    @Test
    void testCriarTarifaSegundoErro() {
        Exception excecao = assertThrows(Exception.class, () -> new Tarifa("domestico", "dolar"));
        assertEquals(excecao.getMessage(), "É necessário utilizar o real como moeda para voos domésticos.");
    }
}
