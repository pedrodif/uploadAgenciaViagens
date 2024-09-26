package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import business.Aeroporto;
import business.CiaAerea;
import business.Voo;

import java.util.List;
import java.util.UUID;
import java.time.LocalDateTime;

public class CiaAereaTest {

    private CiaAerea ciaAerea;
    private Aeroporto aeroportoCNF;
    private Aeroporto aeroportoGRU;
    private Voo vooConfinsGuarulhos;
    private Voo vooGuarulhosConfins;

    @BeforeEach
    public void setUp() {
        ciaAerea = new CiaAerea("Azul Linhas Aereas", "Azul Linhas Aereas Brasileiras S.A", "12.345.678/0001-99");
         
        aeroportoCNF = new Aeroporto("Aeroporto de Confins", "CNF", "Belo Horizonte", "MG", "Brasil");
        aeroportoGRU = new Aeroporto("Aeroporto de Guarulhos", "GRU", "São Paulo", "SP", "Brasil");
         
        vooConfinsGuarulhos = new Voo(ciaAerea, aeroportoGRU, aeroportoCNF);
        vooConfinsGuarulhos.cadatrarDtHrPartida(23, 9, 2024, 15, 30);
         
        vooGuarulhosConfins = new Voo(ciaAerea, aeroportoCNF, aeroportoGRU);
        vooGuarulhosConfins.cadatrarDtHrPartida(24, 9, 2024, 16, 0);
    
        ciaAerea.cadastrarVoo(aeroportoCNF, aeroportoGRU);
        ciaAerea.cadastrarVoo(aeroportoGRU, aeroportoCNF);
    }

    @Test
    public void testCodigoGeradoAutomaticamente() {
         assertNotNull(ciaAerea.getCodigo());
         assertTrue(ciaAerea.getCodigo() instanceof UUID);
    }

     @Test
    public void testSetNome() {
         boolean result = ciaAerea.setNome("Azul Linhas Aéreas");
         assertTrue(result);
         assertEquals("Azul Linhas Aéreas", ciaAerea.getNome());  
         
         result = ciaAerea.setNome("");
         assertFalse(result);
         assertNotEquals("", ciaAerea.getNome());   
         
         result = ciaAerea.setNome("Vermelho#123");
         assertFalse(result);
         assertNotEquals("Vermelho#123", ciaAerea.getNome());
    }

    @Test
    public void testSetRazaoSocial() {
         ciaAerea.setRazaoSocial("Azul Linhas Aéreas Brasileiras S.A.");
         assertEquals("Azul Linhas Aéreas Brasileiras S.A.", ciaAerea.getRazaoSocial());
    }

    @Test
    public void testSetCnpj() {
         ciaAerea.setCnpj("98.765.432/0001-11");
         assertEquals("98.765.432/0001-11", ciaAerea.getCnpj());
    }

    @Test
    public void testCadastrarVoo() {
        assertTrue(ciaAerea.cadastrarVoo(aeroportoCNF, aeroportoGRU));
        assertEquals(1, ciaAerea.getVoos().size());
    }

    @Test
    public void testRemoverVoo() {
        boolean resultado = ciaAerea.removerVoo(vooConfinsGuarulhos.getCodigo());
        assertTrue(resultado, "Voo removido com sucesso.");
        assertEquals(1, ciaAerea.getVoos().size(), "Restara apenas um voo.");
    }

    @Test
    public void testPesquisarVoosSucesso() {
        LocalDateTime dataPartida = LocalDateTime.of(2024, 9, 23, 15, 30);

        var voosEncontrados = ciaAerea.pesquisarVoos("Belo Horizonte", "São Paulo", dataPartida);
        assertEquals(1, voosEncontrados.size(), "Encontrara apenas um voo.");
    }

    @Test
    public void testPesquisarVoosErro() {
        LocalDateTime dataPartida = LocalDateTime.of(2024, 9, 23, 15, 30);

        var voosNaoEncontrados = ciaAerea.pesquisarVoos("Belo Horizonte", "Rio de Janeiro", dataPartida);
        assertEquals(0, voosNaoEncontrados.size(), "Não irá encontrar voos pois os destinos são diferentes.");
    }
}
