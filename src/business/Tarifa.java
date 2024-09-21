package business;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Tarifa {
    private Moeda moeda;
    private TipoVoo tipoVoo;
    private BigDecimal basica, business, premium, bagagem, bagagemAdicional;
    private static final BigDecimal VALOR_DOLAR = new BigDecimal("5.52");

    public Tarifa(String tipoVoo, String moeda){
        try {
            this.tipoVoo = TipoVoo.valueOf(tipoVoo.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo do voo inválido");
        }

        try {
            this.moeda = Moeda.valueOf(moeda.toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException("Tipo de moeda inválida");
        }
    }

    private BigDecimal aplicarConversaoMonetaria(BigDecimal valor) throws Exception{
        if(valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("O valor informado deve ser maior que zero");
        }

        if(this.moeda == Moeda.REAL && tipoVoo.equals(TipoVoo.INTERNACIONAL)) {
            return valor.divide(VALOR_DOLAR, RoundingMode.HALF_UP);
        }
       
        return valor;
    }

    public TipoVoo getTipoVoo() {
        return tipoVoo;
    }

    public BigDecimal getBasica() {
        return basica;
    }

    public void setBasica(BigDecimal basica) throws Exception {
        this.basica = aplicarConversaoMonetaria(basica);
    }

    public BigDecimal getBusiness() {
        return business;
    }

    public void setBusiness(BigDecimal business) throws Exception {
        this.business = aplicarConversaoMonetaria(business);
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) throws Exception {
        this.premium = aplicarConversaoMonetaria(premium);
    }

    public BigDecimal getBagagem() {
        return bagagem;
    }

    public void setBagagem(BigDecimal bagagem) throws Exception {
        this.bagagem = aplicarConversaoMonetaria(bagagem);
    }

    public BigDecimal getBagagemAdicional() {
        return bagagemAdicional;
    }

    public void setBagagemAdicional(BigDecimal bagagemAdicional) throws Exception {
        this.bagagemAdicional = aplicarConversaoMonetaria(bagagemAdicional);
    }
}
