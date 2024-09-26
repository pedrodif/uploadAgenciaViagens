package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import business.Voo;
import business.Bilhete;
import business.Passageiro;
import business.Funcionario;

public class PassageiroTest {
    private Passageiro passageiro;
    private Funcionario funcionario;
    private Voo voo;

    @BeforeEach
    public void configCenario() throws Exception {
        this.voo = new Voo(null, null, null);
        this.passageiro = new Passageiro("João", "123456789", "AB123456");
        this.funcionario = new Funcionario("Maria Betânia", "259.657.910-38", "mari-beth@gmail.com", "mariaBeth", "testeSenha");
        configVoo();  // Ajustando para chamar o método de configuração
    }

    private void configVoo() throws Exception {
        this.voo.cadastrarTarifa("Internacional", "real");
        this.voo.escolherClasse("basica");
        this.voo.escolherBagagem("primeira");
        this.voo.cadatrarDtHrPartida(1, 1, 2025, 12, 0);
        this.voo.cadatrarDtHrChegada(1, 1, 2025, 18, 0);
    }

    @Test
    public void testCadastrarBilhete() {
        assertTrue(passageiro.cadastrarBilhete(funcionario));
    }

    @Test
    public void testRemoverBilhete() throws Exception {
        this.passageiro.cadastrarBilhete(funcionario);

        Bilhete bilheteAdicionado = this.passageiro.getBilhetes().get(0);
        assertTrue(passageiro.removerBilhete(bilheteAdicionado.getCodigo()));
    }
}
