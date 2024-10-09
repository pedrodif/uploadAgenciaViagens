package business;

import enums.Bagagem;
import enums.ClasseVoo;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Voo {
    
    private String codigo;
    private Tarifa tarifa;
    private Bagagem bagagem;
    private CiaAerea ciaAerea;
    private ClasseVoo classe;
    private double valorPassagem, valorBagagem;
    private Aeroporto localPartida, localChegada;
    private LocalDateTime dtHrPartida, dtHrChegada;
    private boolean cancelado;
    private List<Bilhete> bilhetes;

    public Voo() {
        this.bilhetes = new ArrayList<>();
    }

    public Voo(CiaAerea ciaAerea, Aeroporto localPartida, Aeroporto localChegada) {
        this();
        this.ciaAerea = ciaAerea;
        this.localPartida = localPartida;
        this.localChegada = localChegada;
        this.codigo = Codigo.gerarCodigoVoo();
    }

    public CiaAerea getCiaArea() {
        return this.ciaAerea;
    }

    public String getCodigo() {
        return this.codigo;
    }
    
    public Aeroporto getLocalPartida() {
        return this.localPartida;
    }

    public Aeroporto getLocalChegada() {
        return this.localChegada;
    }

    public Tarifa getTarifa() {
        return this.tarifa;
    }

    public void cadastrarTarifa(String tipoVoo, String moeda) throws Exception {
        this.tarifa = new Tarifa(tipoVoo, moeda);
    }

    public LocalDateTime getDtHrPartida() {
        return this.dtHrPartida;
    }

    public void cadastrarDtHrPartida(int dia, int mes, int ano, int horas, int minutos) throws Exception {
        LocalDateTime dataAtual = LocalDateTime.now();
        LocalDateTime dataEntrada = LocalDateTime.of(ano, mes, dia, horas, minutos);
        
        if(ChronoUnit.DAYS.between(dataAtual, dataEntrada) < 0) {
            throw new IllegalArgumentException("A data fornecida é anterior à data atual e não é válida para registro.");
        } else if (ChronoUnit.DAYS.between(dataAtual, dataEntrada) > 30) {
            throw new IllegalArgumentException("A data deve estar dentro de um período de até 30 dias a partir da data atual.");
        } else {
            this.dtHrPartida = dataEntrada;
        }
    }

    public LocalDateTime getDtHrChegada() {
        return this.dtHrChegada;
    }

    public void cadastrarDtHrChegada(int dia, int mes, int ano, int horas, int minutos) {
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

    public double getValorBagagem() {
        this.recuperarValorBagagem();
        return this.valorBagagem;
    }

    private void recuperarValorBagagem() {
        if (this.bagagem == null) {
            throw new RuntimeException("O tipo de bagagem deve ser escolhido antes de calcular seu valor.");
        } else {
            switch (this.bagagem) {
                case ADICIONAL:
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

    public double getValorPassagem() {
        this.recuperarValorPassagem();
        return this.valorPassagem;
    }

    private void recuperarValorPassagem() {
        if (this.classe == null) {
            throw new RuntimeException("A classe deve ser escolhida antes de calcular o valor da passagem.");
        } else {
            this.recuperarValorBagagem();
            switch (this.classe) {
                case BUSINESS:
                    this.valorPassagem = this.tarifa.getBusiness() + this.valorBagagem;
                    break;
                case PREMIUM:
                    this.valorPassagem = this.tarifa.getPremium() + this.valorBagagem;
                    break;
                default:
                    this.valorPassagem = this.tarifa.getBasica() + this.valorBagagem;
                    break;
            }
        }
    }

    public void cancelarVoo() {
        this.cancelado = true;
        for (Bilhete bilhete : new ArrayList<>(bilhetes)) {
            bilhete.cancelarBilhete();
        }
    }

    public boolean isCancelado() {
        return this.cancelado;
    }

    public void adicionarBilhete(Bilhete bilhete) {
        if (bilhete != null && !this.cancelado) {
            this.bilhetes.add(bilhete);
        } else {
            throw new IllegalStateException("Não é possível adicionar bilhetes a um voo cancelado.");
        }
    }
}
