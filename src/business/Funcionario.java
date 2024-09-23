package business;

// Define a classe Funcionario, que é uma subclasse de Usuario
public class Funcionario extends Usuario {
    // O construtor da classe Funcionario recebe alguns parâmetros
    public Funcionario(String nome, String cpf, String email, String login, String senha) {
        // Chamamos o construtor da classe pai (Usuario) usando 'super'
        super(nome, cpf, email, login, senha); 
    }
}
