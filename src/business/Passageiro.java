package business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Passageiro {
    private String rg;
    private String nome;
    private String numeroPassaporte;
    private ArrayList<Bilhete> bilhetes;

    public Passageiro(String nome, String rg, String numeroPassaporte) {
        this.nome = nome;
        this.rg = rg;
        this.numeroPassaporte = numeroPassaporte;
        this.bilhetes = new ArrayList<>();
    }

    public boolean adicionarBilhete(Funcionario funcionario) {
        if (funcionario != null) {
            Bilhete novoBilhete = new Bilhete(funcionario);
            return this.bilhetes.add(novoBilhete);
        }
        return false;
    }

    public boolean removerBilhete(Bilhete bilhete) {
        return this.bilhetes.remove(bilhete);
    }

    public List<Bilhete> getBilhetes() {
        return Collections.unmodifiableList(this.bilhetes);
    }

    public String getRg() {
        return this.rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroPassaporte() {
        return this.numeroPassaporte;
    }

    public void setNumeroPassaporte(String numeroPassaporte) {
        this.numeroPassaporte = numeroPassaporte;
    }
}
