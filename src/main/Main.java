package main;

import business.Passageiro;
import business.Bilhete;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // Criando um passageiro
        Passageiro passageiro = new Passageiro("João Silva", "12345678", "BR12345");

        // Criando um bilhete e associando ao passageiro
        Bilhete bilhete = new Bilhete(passageiro);

        // Setando valores de exemplo no bilhete
        bilhete.setValorTotalSemBagagem(new BigDecimal("1000.00")); // Valor sem bagagem

        // Testando o cálculo de valor total do bilhete (com bagagem extra)
        BigDecimal valorTotal = bilhete.calcularValorTotal();
        System.out.println("Valor total do bilhete: " + valorTotal);

        // Testando o cálculo de valor sem bagagem
        BigDecimal valorSemBagagem = bilhete.calcularValorSemBagagem();
        System.out.println("Valor sem bagagem: " + valorSemBagagem);

        // Testando o cálculo da remuneração da agência
        bilhete.calcularRemuneracaoAgencia();

        // Verificando se o passageiro tem um bilhete associado
        if (passageiro.getBilhete() != null) {
            System.out.println("Passageiro " + passageiro.getNome() + " tem um bilhete associado.");
        } else {
            System.out.println("Passageiro " + passageiro.getNome() + " não tem um bilhete associado.");
        }

        // Removendo o bilhete do passageiro (gerenciando tempo de vida do bilhete)
        passageiro.removerBilhete(bilhete); // Passando o bilhete como argumento

        // Verificando se o bilhete foi removido
        if (passageiro.getBilhete() == null) {
            System.out.println("O bilhete foi removido do passageiro.");
        } else {
            System.out.println("O bilhete ainda está associado ao passageiro.");
        }
    }
}
