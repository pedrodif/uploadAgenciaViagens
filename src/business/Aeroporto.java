package business;

import java.util.ArrayList;

public class Aeroporto {
    private String nome;
    private String sigla;
    private String cidade;
    private String estado;
    private String pais;
    private ArrayList<Voo> voos;

    public Aeroporto() { }

    public Aeroporto(String nome, String sigla, String cidade, String estado, String pais) {
        this.nome = nome;
        this.sigla = sigla;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Aeroporto(String nome, String sigla, String cidade, String estado, String pais, ArrayList<Voo> voos) {
        this.nome = nome;
        this.sigla = sigla;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.voos = voos;
    }

    public String getNome() {
        return nome;
    }

    public boolean setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty() && nome.matches("[A-Za-zÀ-ÖØ-öø-ÿ ]+")) {
            this.nome = nome;
            return true;
        }
        return false;   
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public ArrayList<Voo> getVoos() {
        return voos;
    }

    public void setVoos(ArrayList<Voo> voos) {
        this.voos = voos;
    }

    public boolean adicionarVoo(Voo voo) {
        return this.voos.add(voo);
    }

    public boolean removerVoo(Voo voo) {
        return this.voos.remove(voo);
    }
}
