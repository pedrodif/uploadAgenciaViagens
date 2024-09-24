package business;

import enums.TipoDocumento;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bilhete {

    private double valorTotal;
    private double valorTotalSemBagagem;
    private TipoDocumento tipoDocumento;
    private double remuneracaoAgencia;
    private List<Voo> voos;
    private Funcionario funcionario;

    public Bilhete(Funcionario funcionario) {
        this.voos = new ArrayList<>();
        this.funcionario = funcionario;
    }

    public void adicionarVoo(Voo voo) {
        if (voo != null) {
            this.voos.add(voo);
            this.calcularValorTotal();   
            this.calcularValorTotalSemBagagem();
        }
    }

    public void calcularValorTotal() {
        this.valorTotal = this.voos.stream()
            .mapToDouble(Voo::getValorPassagem)
            .sum();
    }

    public void calcularValorTotalSemBagagem() {
        this.valorTotalSemBagagem = this.voos.stream()
            .mapToDouble(voo -> voo.getValorPassagem() - voo.getValorBagagem())
            .sum();
    }

    public double calcularRemuneracaoAgencia() {
        if (this.valorTotal != 0.0) {
            this.remuneracaoAgencia = this.valorTotal * 0.10;
        }
        return this.remuneracaoAgencia;
    }

    public List<Voo> getVoos() {
        return Collections.unmodifiableList(this.voos);
    }

    public double getValorTotal() {
        return this.valorTotal;
    }

    public double getValorTotalSemBagagem() {
        return this.valorTotalSemBagagem;
    }

    public TipoDocumento getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public double getRemuneracaoAgencia() {
        return this.remuneracaoAgencia;
    }
}
