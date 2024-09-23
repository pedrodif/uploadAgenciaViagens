package test;

import business.Bilhete;
import business.Funcionario;
import business.Passageiro;
import business.Voo;
import enums.Bagagem;
import enums.ClasseVoo;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PassageiroTest {

    @Test
    public void testAdicionarBilhete() {
        Passageiro passageiro = new Passageiro("João", "123456789", "AB123456");
        Funcionario funcionario = new Funcionario("123", "Maria", "98765");
        Voo voo = criarVoo(100.0, 50.0, ClasseVoo.BASICA, Bagagem.PRIMEIRA);
        Bilhete bilhete = new Bilhete(150.0, Arrays.asList(voo), funcionario);

        assertTrue(passageiro.adicionarBilhete(bilhete));
        assertEquals(1, passageiro.getBilhetes().size());
    }

    @Test
    public void testRemoverBilhete() {
        Passageiro passageiro = new Passageiro("João", "123456789", "AB123456");
        Funcionario funcionario = new Funcionario("123", "Maria", "98765");
        Voo voo = criarVoo(100.0, 50.0, ClasseVoo.BASICA, Bagagem.PRIMEIRA);
        Bilhete bilhete = new Bilhete(150.0, Arrays.asList(voo), funcionario);

        passageiro.adicionarBilhete(bilhete);
        assertTrue(passageiro.removerBilhete(bilhete));
        assertEquals(0, passageiro.getBilhetes().size());
    }

    @Test
    public void testCalcularValorTotalBilhetes() {
        Passageiro passageiro = new Passageiro("João", "123456789", "AB123456");
        Funcionario funcionario = new Funcionario("123", "Maria", "98765");
        Voo voo1 = criarVoo(100.0, 50.0, ClasseVoo.BASICA, Bagagem.PRIMEIRA);
        Voo voo2 = criarVoo(200.0, 70.0, ClasseVoo.PREMIUM, Bagagem.ADICIONAL);
        Bilhete bilhete1 = new Bilhete(150.0, Arrays.asList(voo1), funcionario);
        Bilhete bilhete2 = new Bilhete(300.0, Arrays.asList(voo2), funcionario);

        passageiro.adicionarBilhete(bilhete1);
        passageiro.adicionarBilhete(bilhete2);

        assertEquals(450.0, passageiro.calcularValorTotalBilhetes());
    }

    @Test
    public void testCalcularValorTotalSemBagagem() {
        Passageiro passageiro = new Passageiro("João", "123456789", "AB123456");
        Funcionario funcionario = new Funcionario("123", "Maria", "98765");
        Voo voo1 = criarVoo(100.0, 50.0, ClasseVoo.BASICA, Bagagem.PRIMEIRA);
        Voo voo2 = criarVoo(200.0, 70.0, ClasseVoo.PREMIUM, Bagagem.ADICIONAL);
        Bilhete bilhete1 = new Bilhete(150.0, Arrays.asList(voo1), funcionario);
        Bilhete bilhete2 = new Bilhete(300.0, Arrays.asList(voo2), funcionario);

        passageiro.adicionarBilhete(bilhete1);
        passageiro.adicionarBilhete(bilhete2);

        assertEquals(450.0, passageiro.calcularValorTotalSemBagagem());
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
