package business;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Passageiro {
    
    private String rg;
    private String nome;
    private String numeroPassaporte;
    private ArrayList<Bilhete> bilhetes;

    public Passageiro(String nome, String rg, String numeroPassaporte) {
        this.rg = rg;
        this.nome = nome;
        this.numeroPassaporte = numeroPassaporte;
        this.bilhetes = new ArrayList<Bilhete>();
    }

    public List<Bilhete> getBilhetes() {
        return Collections.unmodifiableList(this.bilhetes);
    }

    public boolean cadastrarBilhete(Funcionario funcionario) {
        if (funcionario != null) {
            return this.bilhetes.add(new Bilhete(this, funcionario));
        }
        return false;
    }

    private Bilhete localizarBilhete(String codigo){
        return this.bilhetes.stream().filter(bilhete -> bilhete.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

    public boolean removerBilhete(String codigo) throws Exception {
        Bilhete bilhete = localizarBilhete(codigo);

        if(bilhete == null) {
            throw new IllegalArgumentException("Não foi encontrado nenhum bilhete com o código informado.");
        } 

        return this.bilhetes.remove(bilhete);
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