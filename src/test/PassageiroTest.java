package test;

import business.Bilhete;
import business.Passageiro;
import business.Voo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassageiroTest {

    private Passageiro passageiro;
    private Bilhete bilhete1;
    private Bilhete bilhete2;

    @BeforeEach
    public void setUp() {
        passageiro = new Passageiro("João", "123456", "A123456789");
        bilhete1 = new Bilhete(100.00, Arrays.asList(new Voo(200.00))); // Valor sem bagagem
        bilhete2 = new Bilhete(150.00, Arrays.asList(new Voo(250.00)));
        passageiro.adicionarBilhete(bilhete1);
        passageiro.adicionarBilhete(bilhete2);
    }

    @Test
    public void testAdicionarBilhete() {
        assertEquals(2, passageiro.getBilhetes().size(), "O passageiro deve ter 2 bilhetes");
    }

    @Test
    public void testRemoverBilhete() {
        passageiro.removerBilhete(bilhete1);
        assertEquals(1, passageiro.getBilhetes().size(), "O passageiro deve ter 1 bilhete após remoção");
    }

    @Test
    public void testCalcularValorTotalBilhetes() {
        double valorTotal = passageiro.calcularValorTotalBilhetes();
        assertEquals(600.00, valorTotal, "O valor total dos bilhetes deve ser a soma dos valores dos bilhetes");
    }

    @Test
    public void testCalcularValorTotalSemBagagem() {
        double valorSemBagagem = passageiro.calcularValorTotalSemBagagem();
        assertEquals(250.00, valorSemBagagem, "O valor total sem bagagem deve ser a soma dos valores sem bagagem");
    }
}
