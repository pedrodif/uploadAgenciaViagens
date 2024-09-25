package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.Bilhete;
import business.Funcionario;
import business.Passageiro;
import business.Voo;
import enums.TipoDocumento;

public class BilheteTest {

    private Bilhete bilhete;
    private Passageiro passageiro;
    private Funcionario funcionario;
    private Voo voo;

    public void configVoo() throws Exception {
        this.voo = new Voo(null, null, null);
        this.voo.cadastrarTarifa("Internacional", "real");
        this.voo.escolherClasse("basica");
        this.voo.escolherBagagem("primeira");
        this.voo.cadatrarDtHrPartida(1, 1, 2025, 12, 0);
        this.voo.cadatrarDtHrChegada(1, 1, 2025, 18, 0);
    }

    @BeforeEach
    public void configCenario() throws Exception {
        this.funcionario = new Funcionario("123", "Maria", "98765");
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
    public void testAdicionarVooCorreto() throws Exception {
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
        assertThrows(IllegalArgumentException.class, () -> {
            bilhete.setTipoDocumento("CPF");
        }, "Tipo de documento inválido.");
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
