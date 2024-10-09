package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import enums.TipoDocumento;

import business.Voo;
import business.Bilhete;
import business.Passageiro;
import business.Funcionario;

public class BilheteTest {

    private Bilhete bilhete;
    private Passageiro passageiro;
    private Funcionario funcionario;
    private Voo voo;

    private void configVoo() throws Exception {
        this.voo = new Voo(null, null, null);
        this.voo.cadastrarTarifa("Internacional", "real");
        this.voo.escolherClasse("basica");
        this.voo.escolherBagagem("primeira");
        this.voo.cadastrarDtHrPartida(1, 1, 2025, 12, 0);
        this.voo.cadastrarDtHrChegada(1, 1, 2025, 18, 0);
    }

    @BeforeEach
    public void configCenario() throws Exception {
        this.funcionario = new Funcionario("Maria Betânia", "259.657.910-38", "mari-beth@gmail.com", "mariaBeth", "testeSenha");
        this.passageiro = new Passageiro("João", "123456789", "AB123456");
        this.bilhete = new Bilhete(this.passageiro, this.funcionario);
        this.configVoo();
    }

    @Test
    public void testAdicionarVoo() throws Exception {
        bilhete.adicionarVoo(voo);
        assertEquals(1, bilhete.getVoos().size());
    }

    @Test
    public void testConferirVooAdicionado() throws Exception {
        bilhete.adicionarVoo(voo);
        assertEquals(voo, bilhete.getVoos().get(0));
    }

    @Test
    public void testCalcularValorTotal() throws Exception {
        bilhete.adicionarVoo(voo);
        assertEquals(voo.getValorPassagem(), bilhete.getValorTotal());
    }

    @Test
    public void testCalcularValorTotalSemBagagem() throws Exception {
        bilhete.adicionarVoo(voo);
        double valorSemBagagem = voo.getValorPassagem() - voo.getValorBagagem();
        assertEquals(valorSemBagagem, bilhete.getValorTotalSemBagagem());
    }

    @Test
    public void testCalcularRemuneracaoAgencia() throws Exception {
        bilhete.adicionarVoo(voo);
        bilhete.calcularRemuneracaoAgencia();
        double remuneracaoEsperada = bilhete.getValorTotalSemBagagem() * 0.10;
        assertEquals(remuneracaoEsperada, bilhete.getRemuneracaoAgencia());
    }

    @Test
    public void testSetTipoDocumento() throws Exception {
        bilhete.setTipoDocumento("RG");
        assertEquals(TipoDocumento.RG, bilhete.getTipoDocumento());
    }

    @Test
    public void testSetTipoDocumentoInvalido() {
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () ->
                bilhete.setTipoDocumento("CPF")
        );
        assertEquals("Tipo de documento inválido.", excecao.getMessage());
    }

    @Test
    public void testGetFuncionario() {
        assertEquals(this.funcionario, bilhete.getFuncionario());
    }

    @Test
    public void testGetPassageiro() {
        assertEquals(this.passageiro, bilhete.getPassageiro());
    }
}
