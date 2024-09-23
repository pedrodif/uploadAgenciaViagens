public class Aeroporto {
    private String nome;
    private String sigla;
    private String cidade;
    private String estado;
    private String pais;

    // Construtor da classe
    public Aeroporto(String nome, String sigla, String cidade, String estado, String pais) {
        this.nome = nome;
        this.sigla = sigla;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    // Método para exibir informações do aeroporto
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Sigla: " + sigla);
        System.out.println("Cidade: " + cidade);
        System.out.println("Estado: " + estado);
        System.out.println("País: " + pais);
    }

    public static void main(String[] args) {
        Aeroporto meuAeroporto = new Aeroporto("Aeroporto Internacional de Confins", "CNF", "Belo Horizonte", "Minas Gerais", "Brasil");
        meuAeroporto.exibirInformacoes();
    }
}
