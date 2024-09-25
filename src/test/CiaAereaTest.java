package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.Aeroporto;
import business.CiaAerea;
import business.Voo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CiaAereaTest {

    // private CiaAerea ciaAerea;
    // private Aeroporto aeroportoMG;
    // private Aeroporto aeroportoSP;
    // private Voo voo1;
    // private Voo voo2;

    // @BeforeEach
    // public void setUp() {
    //     ciaAerea = new CiaAerea("Companhia Teste", "Razão Social Teste", "12.345.678/0001-99");
    //     aeroportoMG = new Aeroporto("Aeroporto de Minas Gerais ", "AMG", "Belo Horizonte", "MG", "Brasil");
    //     aeroportoSP = new Aeroporto("Aeroporto de São Paulo", "ASP", "São Paulo", "SP", "Brasil");

    //     voo1 = new Voo(ciaAerea, aeroportoSP, aeroportoMG);
    //     voo1.cadatrarDtHrPartida(23, 9, 2024, 15, 30);

    //     voo2 = new Voo(ciaAerea, aeroportoMG, aeroportoSP);
    //     voo2.cadatrarDtHrPartida(24, 9, 2024, 16, 0);
    // }

    // @Test
    // public void testCodigoGeradoAutomaticamente() {
    //     assertNotNull(ciaAerea.getCodigo());
    //     assertTrue(ciaAerea.getCodigo() instanceof UUID);
    // }

    // @Test
    // public void testGetNome() {
    //     assertEquals("Companhia Teste", ciaAerea.getNome());
    // }

    // @Test
    // public void testSetNome() {
    //     boolean result = ciaAerea.setNome("Companhia Teste");
    //     assertTrue(result);
    //     assertEquals("Companhia Teste", ciaAerea.getNome());
    
    //     result = ciaAerea.setNome("");
    //     assertFalse(result);
    //     assertNotEquals("", ciaAerea.getNome()); 
    
    //     result = ciaAerea.setNome("CiaAerea#123");
    //     assertFalse(result);
    //     assertNotEquals("CiaAerea#123", ciaAerea.getNome());
    // }

    // @Test
    // public void testGetRazaoSocial() {
    //     assertEquals("Razão Social Teste", ciaAerea.getRazaoSocial());
    // }

    // @Test
    // public void testSetRazaoSocial() {
    //     ciaAerea.setRazaoSocial("Nova Razão Social");
    //     assertEquals("Nova Razão Social", ciaAerea.getRazaoSocial());
    // }

    // @Test
    // public void testGetCnpj() {
    //     assertEquals("12.345.678/0001-99", ciaAerea.getCnpj());
    // }

    // @Test
    // public void testSetCnpj() {
    //     ciaAerea.setCnpj("98.765.432/0001-11");
    //     assertEquals("98.765.432/0001-11", ciaAerea.getCnpj());
    // }

    // @Test
    // public void testAdicionarVoo() {
    //     ciaAerea.adicionarVoo(voo);
    //     assertEquals(1, ciaAerea.getVoos().size());
    //     assertTrue(ciaAerea.getVoos().contains(voo));
    // }

    // @Test
    // public void testRemoverVoo() {
    //     ciaAerea.adicionarVoo(voo);
    //     ciaAerea.removerVoo(voo);
    //     assertEquals(0, ciaAerea.getVoos().size());
    //     assertFalse(ciaAerea.getVoos().contains(voo));
    // }

    // @Test
    // public void testSetVoos() {
    //     ArrayList<Voo> voos = new ArrayList<>();
    //     Voo outroVoo = new Voo();
    //     voos.add(outroVoo);
    //     ciaAerea.setVoos(voos);
    //     assertTrue(ciaAerea.getVoos().contains(outroVoo));
    // }

    // @Test
    // public void testPesquisarVoosPorData() {
    //     LocalDateTime dataPartida = LocalDateTime.of(2024, 9, 23, 0, 0);
    //     List<Voo> voosEncontrados = ciaAerea.pesquisarVoos(dataPartida);

    //     assertEquals(1, voosEncontrados.size());
    //     assertEquals(voo1.getCodigo(), voosEncontrados.get(0).getCodigo());
    // }

    // @Test
    // public void testPesquisarVoosPorCidadeDePartida() {
    //     List<Voo> voosEncontrados = ciaAerea.pesquisarVoos("São Paulo");

    //     assertEquals(1, voosEncontrados.size());
    //     assertEquals(voo1.getCodigo(), voosEncontrados.get(0).getCodigo());
    // }

    // @Test
    // public void testPesquisarVoosPorDataSemResultados() {
    //     LocalDateTime dataPartida = LocalDateTime.of(2024, 9, 25, 0, 0);
    //     List<Voo> voosEncontrados = ciaAerea.pesquisarVoos(dataPartida);

    //     assertTrue(voosEncontrados.isEmpty());
    // }

    // @Test
    // public void testPesquisarVoosPorCidadeSemResultados() {
    //     List<Voo> voosEncontrados = ciaAerea.pesquisarVoos("Curitiba");

    //     assertTrue(voosEncontrados.isEmpty());
    // }
}
