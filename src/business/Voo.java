package business;

import enums.Bagagem;
import enums.ClasseVoo;
import java.time.LocalDateTime;

public class Voo {
    private String codigo;
    private Tarifa tarifa;
    private Bagagem bagagem;
    private CiaArea ciaArea;
    private ClasseVoo classe;
    private double valorPassagem, valorBagagem;
    private Aeroporto localPartida, localChegada;
    private LocalDateTime dtHrPartida, dtHrChegada;

    public Voo(CiaArea ciaArea, Aeroporto localPartida, Aeroporto localChegada) {
        this.ciaArea = ciaArea;
        this.localPartida = localPartida;
        this.localChegada = localChegada;
        this.codigo = CodigoVoo.gerarCodigo();
    }

    public CiaArea getCiaArea() {
        return this.ciaArea;
    }

    public String getCodigo() {
        return this.codigo;
    }
    
    public Tarifa getTarifa() {
        return this.tarifa;
    }

    public Aeroporto getLocalPartida() {
        return this.localPartida;
    }

    public Aeroporto getLocalChegada() {
        return this.localChegada;
    }

    public void cadastrarTarifa(String tipoVoo, String moeda) throws Exception{
        this.tarifa = new Tarifa(tipoVoo, moeda);
    }

    public LocalDateTime getDtHrPartida() {
        return this.dtHrPartida;
    }

    public void cadatrarDtHrPartida(int dia, int mes, int ano, int horas, int minutos){
        this.dtHrPartida = LocalDateTime.of(ano, mes, dia, horas, minutos);
    }

    public LocalDateTime getDtHrChegada() {
        return this.dtHrChegada;
    }

    public void cadatrarDtHrChegada(int dia, int mes, int ano, int horas, int minutos) {
        this.dtHrChegada = LocalDateTime.of(ano, mes, dia, horas, minutos);
    }

    public Bagagem getBagagem() {
        return this.bagagem;
    }

    public void escolherBagagem(String bagagem) throws Exception {
        try {
            this.bagagem = Bagagem.valueOf(bagagem.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de bagagem inválida.");
        }
    }

    public double getValorBagagem() throws Exception {
        this.recuperarValorBagagem();
        return this.valorBagagem;
    }

    private void recuperarValorBagagem() throws Exception {
        if (this.bagagem == null) {
            throw new Exception("O tipo de bagagem deve ser escolhido antes de calcular seu valor.");
        } else {
            switch (this.bagagem) {
                case Bagagem.ADICIONAL:
                    this.valorBagagem = this.tarifa.getBagagem() + this.tarifa.getBagagemAdicional();
                    break;
                default:
                    this.valorBagagem = this.tarifa.getBagagem();
                    break;
            }
        }
    }

    public ClasseVoo getClasse() {
        return this.classe;
    }

    public void escolherClasse(String classe) throws Exception {
        try {
            this.classe = ClasseVoo.valueOf(classe.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Classe de voo indisponível.");
        }
    }

    public double getValorPassagem() throws Exception {
        this.recuperarValorPassagem();
        return this.valorPassagem;
    }

    private void recuperarValorPassagem() throws Exception {
        if (this.classe == null) {
            throw new Exception("A classe deve ser escolhida antes de calcular o valor da passagem.");
        } else {
            this.recuperarValorBagagem();
            switch (this.classe) {
                case ClasseVoo.BUSINESS:
                    this.valorPassagem = this.tarifa.getBusiness() + this.valorBagagem;
                    break;
                case ClasseVoo.PREMIUM:
                    this.valorPassagem = this.tarifa.getPremium() + this.valorBagagem;
                    break;
                default:
                    this.valorPassagem = this.tarifa.getBasica() + this.valorBagagem;
                    break;
            }
        }
    }
}
