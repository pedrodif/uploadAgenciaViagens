package test;

import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

import enums.Bagagem;
import enums.ClasseVoo;

import business.Voo;
import business.Codigo;
import business.CiaAerea;
import business.Aeroporto;

public class VooTest {
    private Voo voo;
    private CiaAerea latam;
    private Aeroporto galeao, guarulhos;

    @BeforeEach
    public void configVoo() {
        this.latam = new CiaAerea();
        this.galeao = new Aeroporto();
        this.guarulhos = new Aeroporto();
        this.voo = new Voo(latam, galeao, guarulhos);
    }

    @Test
    void testCriarVoo() {
        assertNotNull(this.voo);
    }

    @Test
    void testGerarCodigo() {
        String codigo = Codigo.gerarCodigoVoo();
        Pattern padrao = Pattern.compile("^[A-Z]{2}\\d{4}$");
        assertTrue(padrao.matcher(codigo).matches());
    }

    @BeforeEach
    public void configTarifa() throws Exception {
        this.voo.cadastrarTarifa("domestico", "real");
        this.voo.getTarifa().setBasica(120);
        this.voo.getTarifa().setBusiness(200);
        this.voo.getTarifa().setPremium(450);
        this.voo.getTarifa().setBagagem(120);
        this.voo.getTarifa().setBagagemAdicional(170);
    }

    @Test
    void testCadastrarDtHrPartida() { 
        this.voo.cadastrarDtHrPartida(22, 9, 2024, 13, 20);
        assertEquals(LocalDateTime.of(2024, 9, 22, 13, 20), this.voo.getDtHrPartida());
    }

    @Test
    void testCadastrarDtHrChegada() { 
        this.voo.cadastrarDtHrChegada(22, 9, 2024, 14, 40);
        assertEquals(LocalDateTime.of(2024, 9, 22, 14, 40), this.voo.getDtHrChegada());
    }

    @Test
    void testEscolherBagagemSucesso() throws Exception {
        this.voo.escolherBagagem("adicional");
        assertEquals(Bagagem.ADICIONAL, this.voo.getBagagem());
    }

    @Test
    void testEscolherBagagemErro() throws Exception {
        Exception excecao = assertThrows(Exception.class, () -> this.voo.escolherBagagem("unica"));
        assertEquals("Tipo de bagagem inválida.", excecao.getMessage());
    }

    @Test
    void testRecuperarValorBagagemSucesso() throws Exception {
        this.voo.escolherBagagem("adicional");
        assertEquals(290.0, this.voo.getValorBagagem(), 0);
    }

    @Test
    void testRecuperarValorBagagemErro() {
        RuntimeException excecao = assertThrows(RuntimeException.class, () -> this.voo.getValorBagagem());
        assertEquals("O tipo de bagagem deve ser escolhido antes de calcular seu valor.", excecao.getMessage());
    }

    @Test
    void testEscolherClasseSucesso() throws Exception {
        this.voo.escolherClasse("basica");
        assertEquals(ClasseVoo.BASICA, this.voo.getClasse());
    }

    @Test
    void testEscolherClasseErro() throws Exception {
        Exception excecao = assertThrows(Exception.class, () -> this.voo.escolherClasse("primeira classe"));
        assertEquals("Classe de voo indisponível.", excecao.getMessage());
    }

    @Test
    void testRecuperarValorPassagemSucesso() throws Exception {
        this.voo.escolherClasse("premium");
        this.voo.escolherBagagem("adicional");
        assertEquals(740, this.voo.getValorPassagem(), 0);
    }

    @Test
    void testRecuperarValorPassagemErro() {
        RuntimeException excecao = assertThrows(RuntimeException.class, () -> this.voo.getValorPassagem());
        assertEquals("A classe deve ser escolhida antes de calcular o valor da passagem.", excecao.getMessage());
    }
}
