package business;

import java.util.ArrayList;
import java.util.List;

public class Passageiro {
    private String rg;
    private String nome;
    private String numeroPassaporte;
    private List<Bilhete> bilhetes; // Vários bilhetes

    public Passageiro(String nome, String rg, String numeroPassaporte) {
        this.nome = nome;
        this.rg = rg;
        this.numeroPassaporte = numeroPassaporte;
        this.bilhetes = new ArrayList<>();
    }

    public void cadastrarBilhete(Bilhete bilhete) {
        this.bilhetes.add(bilhete); // Adiciona o bilhete à lista
    }

    public void removerBilhete(Bilhete bilhete) {
        this.bilhetes.remove(bilhete); // Remove o bilhete da lista
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroPassaporte() {
        return numeroPassaporte;
    }

    public void setNumeroPassaporte(String numeroPassaporte) {
        this.numeroPassaporte = numeroPassaporte;
    }

    public List<Bilhete> getBilhetes() {
        return bilhetes;
    }

    public Bilhete getBilhete() {
        return bilhetes.isEmpty() ? null : bilhetes.get(0); // Retorna o primeiro bilhete ou null se a lista estiver
                                                            // vazia
    }
}
