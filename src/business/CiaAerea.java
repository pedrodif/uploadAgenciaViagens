package business;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CiaAerea {
    private UUID codigo;
    private String nome;
    private String razaoSocial;
    private String cnpj;
    private ArrayList<Voo> voos;

    public CiaAerea() { }

    public CiaAerea(String nome, String razaoSocial, String cnpj) {
        this.codigo = UUID.randomUUID();
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    public UUID getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public ArrayList<Voo> getVoos() {
        return voos;
    }

    public void setVoos(ArrayList<Voo> voos) {
        this.voos = voos;
    }

    public void adicionarVoo(Voo voo) {
        this.voos.add(voo);
    }

    public void removerVoo(Voo voo) {
        this.voos.remove(voo);
    }

    public List<Voo> pesquisarVoos(LocalDateTime dataPartida) {
        List<Voo> voosEncontrados = new ArrayList<>();
        for (Voo voo : this.voos) {
            if (voo.getDtHrPartida() != null && voo.getDtHrPartida().toLocalDate().equals(dataPartida.toLocalDate())) {
                voosEncontrados.add(voo);
            }
        }
    return voosEncontrados;
    }

    public List<Voo> pesquisarVoos(String cidadePartida) {
        List<Voo> voosEncontrados = new ArrayList<>();
        for (Voo voo : this.voos) {
            if (voo.getLocalPartida() != null && voo.getLocalPartida().getCidade().equalsIgnoreCase(cidadePartida)) {
                voosEncontrados.add(voo);
            }
        }
        return voosEncontrados;
    }
}
