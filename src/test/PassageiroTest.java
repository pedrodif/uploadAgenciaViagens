package test;

import business.Passageiro;
import business.Bilhete;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassageiroTest {
    private Passageiro passageiro;
    private Bilhete bilhete;

    @BeforeEach
    public void setUp() {
        passageiro = new Passageiro("João", "12345678", "BR12345");
        bilhete = new Bilhete(passageiro);
        bilhete.setValorTotalSemBagagem(new BigDecimal("1000.00"));
    }

    @Test
    public void testCadastrarBilhete() {
        passageiro.cadastrarBilhete(bilhete);
        assertEquals(1, passageiro.getBilhetes().size(), "Deve haver um bilhete cadastrado");
        assertEquals(bilhete, passageiro.getBilhetes().get(0), "O bilhete adicionado deve ser o mesmo que foi cadastrado");
    }

    @Test
    public void testRemoverBilhete() {
        passageiro.cadastrarBilhete(bilhete);
        passageiro.removerBilhete(bilhete);
        assertEquals(0, passageiro.getBilhetes().size(), "A lista de bilhetes deve estar vazia após a remoção");
    }

    @Test
    public void testGetters() {
        assertEquals("João", passageiro.getNome(), "O nome deve ser João");
        assertEquals("12345678", passageiro.getRg(), "O RG deve ser 12345678");
        assertEquals("BR12345", passageiro.getNumeroPassaporte(), "O número do passaporte deve ser BR12345");
    }
}
