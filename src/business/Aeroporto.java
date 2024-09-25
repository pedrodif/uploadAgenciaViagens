package business;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Aeroporto {

    private ArrayList<Voo> voos;
    private String nome, sigla, cidade, estado, pais;

    public Aeroporto() {}

    public Aeroporto(String nome, String sigla, String cidade, String estado, String pais) {
        this.nome = nome;
        this.sigla = sigla;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.voos = new ArrayList<Voo>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return this.sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public boolean adicionarVoo(Voo voo) {
        return this.voos.add(voo);
    }

    public boolean removerVoo(Voo voo) {
        return this.voos.remove(voo);
    }

    public List<Voo> getVoos() {
        return Collections.unmodifiableList(this.voos);
    }

    public void setVoos(ArrayList<Voo> voos) {
        this.voos = voos;
    }
}
