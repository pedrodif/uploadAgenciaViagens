package test;

import business.Bilhete;
import business.Funcionario;
import business.Passageiro;
import business.Voo;
import enums.Bagagem;
import enums.ClasseVoo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PassageiroTest {

    @Test
    public void testAdicionarBilhete() {
        Passageiro passageiro = new Passageiro("João", "123456789", "AB123456");
        Funcionario funcionario = new Funcionario("123", "Maria", "98765");
        Voo voo = criarVoo(100.0, 50.0, ClasseVoo.BASICA, Bagagem.PRIMEIRA);
        
        Bilhete bilhete = new Bilhete(funcionario);

        bilhete.adicionarVoo(voo);

        assertTrue(passageiro.adicionarBilhete(bilhete));
        assertEquals(1, passageiro.getBilhetes().size());
    }

    @Test
    public void testRemoverBilhete() {
        Passageiro passageiro = new Passageiro("João", "123456789", "AB123456");
        Funcionario funcionario = new Funcionario("123", "Maria", "98765");
        Voo voo = criarVoo(100.0, 50.0, ClasseVoo.BASICA, Bagagem.PRIMEIRA);
        
        Bilhete bilhete = new Bilhete(funcionario);
        bilhete.adicionarVoo(voo);

        passageiro.adicionarBilhete(bilhete);
        assertTrue(passageiro.removerBilhete(bilhete));
        assertEquals(0, passageiro.getBilhetes().size());
    }

    private Voo criarVoo(double valorPassagem, double valorBagagem, ClasseVoo classe, Bagagem bagagem) {
        Voo voo = new Voo(null, null, null);
        try {
            voo.cadastrarTarifa("Internacional", "BRL");
            voo.cadatrarDtHrPartida(1, 1, 2025, 12, 0);
            voo.cadatrarDtHrChegada(1, 1, 2025, 18, 0);
            voo.escolherClasse(classe.name());
            voo.escolherBagagem(bagagem.name());
        } catch (Exception e) {
            fail("Erro ao criar voo: " + e.getMessage());
        }
        return voo;
    }
}
