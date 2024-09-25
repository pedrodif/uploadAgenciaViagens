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
     public void testRemoverVoo() throws Exception {
        ciaAerea.cadastrarVoo(aeroportoCNF, aeroportoGRU);
        String codigoVoo = vooConfinsGuarulhos.getCodigo();

        boolean vooRemovido = ciaAerea.removerVoo(codigoVoo);

        assertTrue(vooRemovido);
        assertEquals(0, ciaAerea.getVoos().size());
     }

     @Test
     public void testPesquisarVoosPorDataSucerro() {
         LocalDateTime dataPartida = LocalDateTime.of(2024, 9, 23, 0, 0);
         List<Voo> voosEncontrados = ciaAerea.pesquisarVoos(dataPartida);
         assertEquals(1, voosEncontrados.size());
         assertEquals(vooConfinsGuarulhos.getCodigo(), voosEncontrados.get(0).getCodigo());
     }

     @Test
     public void testPesquisarVoosPorDataErro() {
         LocalDateTime dataPartida = LocalDateTime.of(2024, 9, 25, 0, 0);
         List<Voo> voosEncontrados = ciaAerea.pesquisarVoos(dataPartida);
         assertTrue(voosEncontrados.isEmpty());
     }

     @Test
     public void testPesquisarVoosPorCidadeSucesso() {
         List<Voo> voosEncontrados = ciaAerea.pesquisarVoos("São Paulo");

         assertEquals(1, voosEncontrados.size());
         assertEquals(vooConfinsGuarulhos.getCodigo(), voosEncontrados.get(0).getCodigo());
     }

     @Test
     public void testPesquisarVoosPorCidadeErro() {
         List<Voo> voosEncontrados = ciaAerea.pesquisarVoos("Curitiba");
         assertTrue(voosEncontrados.isEmpty());
     }
}
