package business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Passageiro {
    private String rg;
    private String nome;
    private String numeroPassaporte;
    private List<Bilhete> bilhetes; // Lista de bilhetes gerenciada pelo passageiro

    public Passageiro(String nome, String rg, String numeroPassaporte) {
        this.nome = nome;
        this.rg = rg;
        this.numeroPassaporte = numeroPassaporte;
        this.bilhetes = new ArrayList<>();
    }

    // Método para adicionar um novo bilhete
    public void adicionarBilhete(Bilhete bilhete) {
        if (bilhete != null) {
            this.bilhetes.add(bilhete); // O passageiro gerencia a adição dos bilhetes
        }
    }

    // Método para remover um bilhete
    public void removerBilhete(Bilhete bilhete) {
        this.bilhetes.remove(bilhete); // O passageiro gerencia a remoção dos bilhetes
    }

    // Retornar a lista de bilhetes imutável para manter a integridade
    public List<Bilhete> getBilhetes() {
        return Collections.unmodifiableList(bilhetes);
    }

    public String getRg() {
        return rg;
    }

    public String getNome() {
        return nome;
    }

    public String getNumeroPassaporte() {
        return numeroPassaporte;
    }

    // Método para calcular o valor total dos bilhetes
    public double calcularValorTotalBilhetes() {
        return bilhetes.stream().mapToDouble(Bilhete::getValorTotal).sum();
    }

    // Método para calcular o valor total dos bilhetes sem bagagem
    public double calcularValorTotalSemBagagem() {
        return bilhetes.stream().mapToDouble(Bilhete::getValorTotalSemBagagem).sum();
    }
}
