package business;

public class Tarifa {
    private Moeda moeda;
    private TipoVoo tipoVoo;
    private double basica, business, premium, bagagem, bagagemAdicional;
    private static final double VALOR_DOLAR = 5.52;

    public Tarifa(String tipoVoo, String moeda) throws Exception{
        try {
            this.tipoVoo = TipoVoo.valueOf(tipoVoo.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo do voo inválido.");
        }

        try {
            this.moeda = Moeda.valueOf(moeda.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de moeda inválida.");
        }

        if(this.tipoVoo.equals(TipoVoo.DOMESTICO) && this.moeda.equals(Moeda.DOLAR)){
            throw new Exception("É necessário utilizar o real como moeda para voos domésticos.");
        }
    }

    private double aplicarConversaoMonetaria(double valor) throws Exception{
        if(valor <= 0){
            throw new IllegalArgumentException("O valor informado deve ser maior que zero.");
        }

        if(this.moeda == Moeda.REAL && tipoVoo.equals(TipoVoo.INTERNACIONAL)) {
            return Math.round((valor / VALOR_DOLAR) * 100.0) / 100.0;
        }
       
        return valor;
    }

    public TipoVoo getTipoVoo() {
        return tipoVoo;
    }

    public double getBasica() {
        return basica;
    }

    public void setBasica(double basica) throws Exception {
        this.basica = aplicarConversaoMonetaria(basica);
    }

    public double getBusiness() {
        return business;
    }

    public void setBusiness(double business) throws Exception {
        this.business = aplicarConversaoMonetaria(business);
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) throws Exception {
        this.premium = aplicarConversaoMonetaria(premium);
    }

    public double getBagagem() {
        return bagagem;
    }

    public void setBagagem(double bagagem) throws Exception {
        this.bagagem = aplicarConversaoMonetaria(bagagem);
    }

    public double getBagagemAdicional() {
        return bagagemAdicional;
    }

    public void setBagagemAdicional(double bagagemAdicional) throws Exception {
        this.bagagemAdicional = aplicarConversaoMonetaria(bagagemAdicional);
    }
}
