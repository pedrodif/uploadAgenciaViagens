package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import business.CiaAerea;

import java.util.UUID;

public class CiaAereaTest {

    private CiaAerea ciaAerea;
    private ArrayList<Voo> voos;
    private Voo voo1;
    private Voo voo2;

    @BeforeEach
    public void setUp() {
        // Inicializa objetos antes de cada teste
        voos = new ArrayList<>();
        voo1 = new Voo("1234", "São Paulo", "Rio de Janeiro");
        voo2 = new Voo("5678", "Belo Horizonte", "Salvador");

        voos.add(voo1);
        voos.add(voo2);

        ciaAerea = new CiaAerea("Gol Linhas Aéreas", "Gol Linhas Aéreas S.A.", "12.345.678/0001-90", voos);
    }

    @Test
    public void testConstrutor() {
        assertNotNull(ciaAerea.getCodigo(), "O UUID não deveria ser nulo.");
        assertEquals("Gol Linhas Aéreas", ciaAerea.getNome(), "O nome deveria ser 'Gol Linhas Aéreas'.");
        assertEquals("Gol Linhas Aéreas S.A.", ciaAerea.getRazaoSocial(), "A razão social deveria ser 'Gol Linhas Aéreas S.A.'.");
        assertEquals("12.345.678/0001-90", ciaAerea.getCnpj(), "O CNPJ deveria ser '12.345.678/0001-90'.");
        assertEquals(2, ciaAerea.getVoos().size(), "Deveria haver 2 voos na lista.");
    }

    @Test
    public void testAdicionarVoo() {
        Voo voo3 = new Voo("91011", "Porto Alegre", "Curitiba");
        ciaAerea.adicionarVoo(voo3);

        assertEquals(3, ciaAerea.getVoos().size(), "Deveria haver 3 voos na lista.");
        assertTrue(ciaAerea.getVoos().contains(voo3), "A lista deveria conter o voo recém-adicionado.");
    }

    @Test
    public void testRemoverVoo() {
        ciaAerea.removerVoo(voo1);

        assertEquals(1, ciaAerea.getVoos().size(), "Deveria haver 1 voo restante na lista.");
        assertFalse(ciaAerea.getVoos().contains(voo1), "O voo removido não deveria estar na lista.");
    }

    @Test
    public void testSetNome() {
        ciaAerea.setNome("Latam Airlines");
        assertEquals("Latam Airlines", ciaAerea.getNome(), "O nome deveria ser 'Latam Airlines'.");
    }

    @Test
    public void testSetRazaoSocial() {
        ciaAerea.setRazaoSocial("Latam Airlines Group S.A.");
        assertEquals("Latam Airlines Group S.A.", ciaAerea.getRazaoSocial(), "A razão social deveria ser 'Latam Airlines Group S.A.'.");
    }

    @Test
    public void testSetCnpj() {
        ciaAerea.setCnpj("98.765.432/0001-99");
        assertEquals("98.765.432/0001-99", ciaAerea.getCnpj(), "O CNPJ deveria ser '98.765.432/0001-99'.");
    }
}