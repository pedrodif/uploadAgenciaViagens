package test;

import business.Passageiro;
import business.Bilhete;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BilheteTest {
    private Passageiro passageiro;
    private Bilhete bilhete;

    @BeforeEach
    public void setUp() {
        passageiro = new Passageiro("João", "12345678", "BR12345");
        bilhete = new Bilhete(passageiro);
        bilhete.setValorTotalSemBagagem(new BigDecimal("1000.00"));
        passageiro.cadastrarBilhete(bilhete);
    }

    @Test
    public void testCalcularValorTotal() {
        BigDecimal valorTotal = bilhete.calcularValorTotal();
        assertEquals(new BigDecimal("1050.00"), valorTotal);
    }

    @Test
    public void testCalcularValorSemBagagem() {
        BigDecimal valorSemBagagem = bilhete.calcularValorSemBagagem();
        assertEquals(new BigDecimal("1000.00"), valorSemBagagem);
    }

    @Test
    public void testCalcularRemuneracaoAgencia() {
        bilhete.calcularValorTotal();
        bilhete.calcularRemuneracaoAgencia();

        BigDecimal expectedComissao = bilhete.getValorTotal().multiply(new BigDecimal("0.10"));
        assertEquals(expectedComissao, bilhete.getRemuneracaoAgencia());
    }

    @Test
    public void testGetters() {
        assertEquals(passageiro, bilhete.getPassageiro());
    }

    // Testes Voos
}
