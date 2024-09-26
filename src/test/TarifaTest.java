package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertEquals(500.00, this.tarifa.getBasica());
    }

    @Test
    void testSetBusiness() throws Exception {
        this.tarifa.setBusiness(750);
        assertEquals(750.00, this.tarifa.getBusiness());
    }

    @Test
    void testSetPremium() throws Exception {
        this.tarifa.setPremium(950);
        assertEquals(950.00, this.tarifa.getPremium());
    }

    @Test
    void testSetBagagem() throws Exception {
        this.tarifa.setBagagem(200);
        assertEquals(200.00, this.tarifa.getBagagem());
    }

    @Test
    void testSetBagagemAdicional() throws Exception {
        this.tarifa.setBagagemAdicional(350);
        assertEquals(350.00, this.tarifa.getBagagemAdicional());
    }

    @Test
    void testCriarTarifaSucesso() throws Exception {
        assertNotNull(new Tarifa("internacional", "dolar"));
    }

    @Test
    void testCriarTarifaCasoErro1() {
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> new Tarifa("nacional", "real"));
        assertEquals("Tipo do voo inválido.", excecao.getMessage());
    }

    @Test
    void testCriarTarifaCasoErro2() {
        Exception excecao = assertThrows(Exception.class, () -> new Tarifa("domestico", "dolar"));
        assertEquals("É necessário utilizar o real como moeda para voos domésticos.", excecao.getMessage());
    }
}
