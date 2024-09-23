package test;

import business.Bilhete;
import business.Funcionario;
import business.Voo;
import enums.Bagagem;
import enums.ClasseVoo;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BilheteTest {

    @Test
    public void testCalcularValorTotal() {
        Funcionario funcionario = new Funcionario("123", "João", "12345");
        Voo voo1 = null;
        Voo voo2 = null;

        try {
            voo1 = criarVoo(100.0, 50.0, ClasseVoo.BASICA, Bagagem.PRIMEIRA);
            voo2 = criarVoo(200.0, 70.0, ClasseVoo.PREMIUM, Bagagem.ADICIONAL);
        } catch (Exception e) {
            fail("Erro ao criar voo: " + e.getMessage());
        }

        Bilhete bilhete = new Bilhete(150.0, Arrays.asList(voo1, voo2), funcionario);
        
        assertEquals(520.0, bilhete.calcularValorTotal());
    }

    @Test
    public void testCalcularRemuneracaoAgencia() {
        Funcionario funcionario = new Funcionario("123", "João", "12345");
        Voo voo1 = null;

        try {
            voo1 = criarVoo(100.0, 50.0, ClasseVoo.BASICA, Bagagem.PRIMEIRA);
        } catch (Exception e) {
            fail("Erro ao criar voo: " + e.getMessage());
        }

        Bilhete bilhete = new Bilhete(150.0, Arrays.asList(voo1), funcionario);
        
        assertEquals(15.0, bilhete.calcularRemuneracaoAgencia());
    }

    @Test
    public void testGetFuncionario() {
        Funcionario funcionario = new Funcionario("123", "João", "12345");
        Voo voo = null;

        try {
            voo = criarVoo(100.0, 50.0, ClasseVoo.BASICA, Bagagem.PRIMEIRA);
        } catch (Exception e) {
            fail("Erro ao criar voo: " + e.getMessage());
        }

        Bilhete bilhete = new Bilhete(150.0, Arrays.asList(voo), funcionario);

        assertEquals(funcionario, bilhete.getFuncionario());
    }

    private Voo criarVoo(double valorPassagem, double valorBagagem, ClasseVoo classe, Bagagem bagagem) throws Exception {
        Voo voo = new Voo(null, null, null);
        voo.cadastrarTarifa("Internacional", "BRL");
        voo.cadatrarDtHrPartida(1, 1, 2025, 12, 0);
        voo.cadatrarDtHrChegada(1, 1, 2025, 18, 0);
        voo.escolherClasse(classe.name());
        voo.escolherBagagem(bagagem.name());
        return voo;
    }
}
