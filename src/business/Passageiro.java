package business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Passageiro {
    private String rg;
    private String nome;
    private String numeroPassaporte;
    private List<Bilhete> bilhetes;

    public Passageiro(String nome, String rg, String numeroPassaporte) {
        this.nome = nome;
        this.rg = rg;
        this.numeroPassaporte = numeroPassaporte;
        this.bilhetes = new ArrayList<>();
    }

    public void adicionarBilhete(Bilhete bilhete) {
        if (bilhete != null) {
            this.bilhetes.add(bilhete);
        }
    }

    public void removerBilhete(Bilhete bilhete) {
        this.bilhetes.remove(bilhete);
    }

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

    public double calcularValorTotalBilhetes() {
        return bilhetes.stream().mapToDouble(Bilhete::getValorTotal).sum();
    }

    public double calcularValorTotalSemBagagem() {
        return bilhetes.stream().mapToDouble(Bilhete::getValorTotalSemBagagem).sum();
    }
}
