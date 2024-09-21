    package business;

    import java.math.BigDecimal;

    public class Bilhete {

        public enum TipoDocumento { // Suposto Enum para o código funcionar
            RG,
            PASSAPORTE
        }

        private BigDecimal valorTotal;
        private BigDecimal valorTotalSemBagagem;
        private TipoDocumento tipoDocumento;
        private Passageiro passageiro;
        private BigDecimal remuneracaoAgencia;

        public Bilhete(Passageiro passageiro) {
            this.passageiro = passageiro;
        }

        public BigDecimal calcularValorTotal() {
            if (valorTotalSemBagagem != null) {
                this.valorTotal = valorTotalSemBagagem.add(new BigDecimal("50.00"));  // Valor Fictício
            }
            return valorTotal;
        }

        public BigDecimal calcularValorSemBagagem() {
            return valorTotalSemBagagem;
        }

        public void calcularRemuneracaoAgencia() {
            calcularValorTotal();
            if (valorTotal != null) {
                this.remuneracaoAgencia = valorTotal.multiply(new BigDecimal("0.10"));  // 10%
                System.out.println("Remuneração da agência: " + remuneracaoAgencia);
            }
        }

        public BigDecimal getValorTotal() {
            return valorTotal;
        }

        public void setValorTotal(BigDecimal valorTotal) {
            this.valorTotal = valorTotal;
        }

        public BigDecimal getValorTotalSemBagagem() {
            return valorTotalSemBagagem;
        }

        public void setValorTotalSemBagagem(BigDecimal valorTotalSemBagagem) {
            this.valorTotalSemBagagem = valorTotalSemBagagem;
        }

        public TipoDocumento getTipoDocumento() {
            return tipoDocumento;
        }

        public void setTipoDocumento(TipoDocumento tipoDocumento) {
            this.tipoDocumento = tipoDocumento;
        }

        public Passageiro getPassageiro() {
            return passageiro;
        }

        public void setPassageiro(Passageiro passageiro) {
            this.passageiro = passageiro;
        }

        public BigDecimal getRemuneracaoAgencia() {
            return remuneracaoAgencia;
        }
    }
