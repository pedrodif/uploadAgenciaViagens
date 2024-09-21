package business;

import java.util.List;

public class Bilhete {

    private double valorTotal;
    private double valorTotalSemBagagem;
    private TipoDocumento tipoDocumento;
    private double remuneracaoAgencia;
    private List<Voo> voos;

    public Bilhete(double valorTotalSemBagagem, List<Voo> voos) {
        this.valorTotalSemBagagem = valorTotalSemBagagem;
        this.voos = voos;
        calcularValorTotal();
    }


    public double calcularValorTotal() {
        calcularValorComBaseNosVoos(); 
        return valorTotal;
    }

    public double calcularValorSemBagagem() {
        return valorTotalSemBagagem;
    }

    public double calcularRemuneracaoAgencia() {
        calcularValorTotal();
        if (valorTotal != 0.0) {
            this.remuneracaoAgencia = valorTotal * 0.10;
        }
        return remuneracaoAgencia;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double getValorTotalSemBagagem() {
        return valorTotalSemBagagem;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public double getRemuneracaoAgencia() {
        return remuneracaoAgencia;
    }

    private void calcularValorComBaseNosVoos() {
        double tarifaTotal = 0.0;
        for (Voo voo : voos) {
            tarifaTotal += voo.getTarifa();
        }
        this.valorTotal = tarifaTotal + valorTotalSemBagagem;
    }
}
