package test;

import business.Bilhete;
import business.Tarifa;
import business.Funcionario;
import business.Voo;
import business.CiaArea;
import business.Aeroporto;
import enums.TipoDocumento;
import enums.Bagagem;
import enums.ClasseVoo;
import enums.Moeda;
import enums.TipoVoo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BilheteTest {
    private Bilhete bilhete;
    private Funcionario funcionario;
    private Voo voo;

    // @BeforeEach
    // void setUp() throws Exception {
    //     funcionario = new Funcionario("1", "Nome do Funcionário", "Documento do Funcionário");
    //     bilhete = new Bilhete(funcionario);

    //     CiaArea ciaArea = new CiaArea();
    //     Aeroporto localPartida = new Aeroporto();
    //     Aeroporto localChegada = new Aeroporto();
    //     voo = new Voo(ciaArea, localPartida, localChegada);

    //     Tarifa tarifa = new Tarifa(TipoVoo.DOMESTICO.name(), Moeda.REAL.name());
    //     tarifa.setBusiness(300);
    //     tarifa.setPremium(200);
    //     tarifa.setBasica(100);
    //     tarifa.setBagagem(50);
    //     tarifa.setBagagemAdicional(30);
    //     voo.cadastrarTarifa(TipoVoo.DOMESTICO.name(), Moeda.REAL.name());
    //     voo.setTarifa(tarifa);
    //     voo.escolherBagagem(Bagagem.ADICIONAL.name());
    //     voo.escolherClasse(ClasseVoo.BASICA.name());
        
    //     voo.getValorPassagem();
    //     voo.getValorBagagem();
    // }

    // @Test
    // void testAdicionarVoo() {
    //     bilhete.adicionarVoo(voo);
    //     assertEquals(1, bilhete.getVoos().size(), "Deve haver 1 voo adicionado.");
    
    //     double valorTotal = bilhete.getValorTotal();
    //     System.out.println("Valor total após adicionar voo: " + valorTotal);
    //     assertTrue(valorTotal > 0, "O valor total deve ser maior que zero após adicionar um voo.");
    // }
    
    // @Test
    // void testCalcularValorTotal() {
    //     bilhete.adicionarVoo(voo);
    //     bilhete.calcularValorTotal();
    //     assertTrue(bilhete.getValorTotal() > 0, "O valor total deve ser maior que zero.");
    // }

    // @Test
    // void testCalcularValorTotalSemBagagem() {
    //     bilhete.adicionarVoo(voo);
    //     bilhete.calcularValorTotalSemBagagem();
    //     assertTrue(bilhete.getValorTotalSemBagagem() >= 0, "O valor total sem bagagem não deve ser negativo.");
    // }

    // @Test
    // void testCalcularRemuneracaoAgencia() {
    //     bilhete.adicionarVoo(voo);
    //     bilhete.calcularRemuneracaoAgencia();
    //     assertTrue(bilhete.getRemuneracaoAgencia() >= 0, "A remuneração da agência não deve ser negativa.");
    // }

    // @Test
    // void testSetGetTipoDocumento() {
    //     bilhete.setTipoDocumento(TipoDocumento.RG);
    //     assertEquals(TipoDocumento.RG, bilhete.getTipoDocumento(), "O tipo de documento deve ser RG.");
    // }
}
