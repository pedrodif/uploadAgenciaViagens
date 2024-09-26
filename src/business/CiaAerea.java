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
        if (nome != null && nome.matches("[A-Za-zÀ-ÖØ-öø-ÿ ]+")) {
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

    protected Voo localizarVoo(String codigo){
        return this.voos.stream().filter(voo -> voo.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

    public boolean removerVoo(String codigo) {
        Voo voo = localizarVoo(codigo);

        if(voo == null) return false;
        return this.voos.remove(voo);
    }

    public List<Voo> pesquisarVoos(String cidadeOrigem, String cidadeDestino, LocalDateTime dataPartida) {
        List<Voo> voosCidadePartida = pesquisarVoosCidadeOrigem(cidadeOrigem);
        List<Voo> voosCidadeDestino = pesquisarVoosCidadeDestino(cidadeDestino);
        List<Voo> voosEncontrados = new ArrayList<>();

        for (Voo voo : this.voos) {
            if (voosCidadePartida.contains(voo) && voosCidadeDestino.contains(voo) && voo.getDtHrPartida().toLocalDate().equals(dataPartida.toLocalDate())) {
                voosEncontrados.add(voo);
            }
        }
        return voosEncontrados;
    }

    private List<Voo> pesquisarVoosCidadeOrigem(String cidadeOrigem){
        List<Voo> voosEncontradosPartida = new ArrayList<>();

        for (Voo voo : this.voos) {
            if (voo.getLocalPartida() != null && voo.getLocalPartida().getCidade().equalsIgnoreCase(cidadeOrigem))
                voosEncontradosPartida.add(voo);
        }
        return voosEncontradosPartida;
    }

    private List<Voo> pesquisarVoosCidadeDestino(String cidadeDestino){
        List<Voo> voosEncontradosChegada = new ArrayList<>();

        for (Voo voo : this.voos) {
            if (voo.getLocalChegada() != null && voo.getLocalChegada().getCidade().equalsIgnoreCase(cidadeDestino))
                voosEncontradosChegada.add(voo);
        }
        return voosEncontradosChegada;
    }
}
