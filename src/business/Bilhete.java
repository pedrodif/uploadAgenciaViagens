package business;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import enums.TipoDocumento;

public class Bilhete {

    private String codigo;
    private ArrayList<Voo> voos;
    private Passageiro passageiro;
    private Funcionario funcionario;
    private TipoDocumento tipoDocumento;
    private double valorTotalSemBagagem, remuneracaoAgencia, valorTotal;
    private boolean cancelado;

    public Bilhete(Passageiro passageiro, Funcionario funcionario) {
        this.passageiro = passageiro;
        this.funcionario = funcionario;
        this.voos = new ArrayList<Voo>();
        this.codigo = Codigo.gerarCodigoBilhete();
        this.cancelado = false;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public Passageiro getPassageiro() {
        return this.passageiro;
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    public List<Voo> getVoos() {
        return Collections.unmodifiableList(this.voos);
    }

    public void adicionarVoo(Voo voo) {
        if (voo != null && !this.cancelado) {
            this.voos.add(voo);
            this.calcularValorTotal();   
            this.calcularValorTotalSemBagagem();
            voo.adicionarBilhete(this);
        } else {
            throw new IllegalStateException("Não é possível adicionar voos a um bilhete cancelado.");
        }
    }

    public double getValorTotal() {
        return this.valorTotal;
    }

    public void calcularValorTotal() {
        this.valorTotal = this.voos.stream()
            .mapToDouble(Voo::getValorPassagem)
            .sum();
    }

    public double getValorTotalSemBagagem() {
        return this.valorTotalSemBagagem;
    }

    public void calcularValorTotalSemBagagem() {
        this.valorTotalSemBagagem = this.voos.stream()
            .mapToDouble(voo -> voo.getValorPassagem() - voo.getValorBagagem())
            .sum();
    }

    public double getRemuneracaoAgencia() {
        return this.remuneracaoAgencia;
    }

    public void calcularRemuneracaoAgencia() {
        this.remuneracaoAgencia = this.valorTotalSemBagagem * 0.10;
    }

    public TipoDocumento getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) throws Exception {
        try {
            this.tipoDocumento = TipoDocumento.valueOf(tipoDocumento);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de documento inválido.");
        }
    }

    public void cancelarBilhete() {
        this.cancelado = true;

        // for (Voo voo : voos) {
        
        }
    // }

    public boolean isCancelado() {
        return this.cancelado;
    }

    public void remarcar(List<Voo> novosVoos) {
        if (this.cancelado) {
            this.voos.clear();
            this.voos.addAll(novosVoos);
            this.cancelado = false;
            this.calcularValorTotal();   
            this.calcularValorTotalSemBagagem();
            for (Voo voo : novosVoos) {
                voo.adicionarBilhete(this);
            }
        } else {
            throw new IllegalStateException("Somente bilhetes cancelados podem ser remarcados.");
        }
    }
}
