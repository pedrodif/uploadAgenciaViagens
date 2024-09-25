package business;

import java.util.List;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDateTime;

public class CiaAerea {

    private UUID codigo;
    private ArrayList<Voo> voos;
    private String razaoSocial, cnpj, nome;

    public CiaAerea() { this.codigo = UUID.randomUUID(); }

    public CiaAerea(String nome, String razaoSocial, String cnpj) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.codigo = UUID.randomUUID();
        this.voos = new ArrayList<Voo>();
    }

    public UUID getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty() && nome.matches("[A-Za-zÀ-ÖØ-öø-ÿ ]+")) {
            this.nome = nome;
            return true;
        }
        return false;   
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Voo> getVoos() {
        return Collections.unmodifiableList(this.voos);
    }

    public boolean cadastrarVoo(Aeroporto localPartida, Aeroporto localChegada) {
        return this.voos.add(new Voo(this, localPartida, localChegada));
    }

    private Voo localizarVoo(String codigo){
        return this.voos.stream().filter(voo -> voo.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

    public boolean removerVoo(String codigo) throws Exception  {
        Voo voo = localizarVoo(codigo);

        if(voo == null) {
            throw new IllegalArgumentException("Não foi encontrado nenhum voo com o código informado.");
        } 

        return this.voos.remove(voo);
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
