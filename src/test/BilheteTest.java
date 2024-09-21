package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import business.Bilhete;
import business.Voo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BilheteTest {

    private Bilhete bilhete;
    private List<Voo> voos;

    @BeforeEach
    public void setUp() {
        Voo voo1 = new Voo(100.00);
        Voo voo2 = new Voo(150.00);
        voos = Arrays.asList(voo1, voo2);
        bilhete = new Bilhete(50.00, voos);
    }

    @Test
    public void testCalcularValorTotal() {
        double valorTotal = bilhete.calcularValorTotal();
        assertEquals(300.00, valorTotal, "O valor total deve ser a soma das tarifas e o valor sem bagagem");
    }

    @Test
    public void testCalcularValorSemBagagem() {
        double valorSemBagagem = bilhete.calcularValorSemBagagem();
        assertEquals(50.00, valorSemBagagem, "O valor sem bagagem deve ser igual ao valor informado");
    }

    @Test
    public void testCalcularRemuneracaoAgencia() {
        double remuneracao = bilhete.calcularRemuneracaoAgencia();
        assertEquals(30.00, remuneracao, "A remuneração da agência deve ser 10% do valor total");
    }
}
