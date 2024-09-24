package business;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Usuario {

    private String nome;
    private String cpf;
    private String email;
    private String login;
    private String senha;

    public static final List<Usuario> MOCK_USUARIOS = Arrays.asList(
            new Usuario("João Silva", "123.456.789-00", "joao.silva@email.com", "joaosilva", "senha123"),
            new Usuario("Maria Souza", "987.654.321-00", "maria.souza@email.com", "mariasouza", "senha456"),
            new Usuario("Pedro Lima", "456.123.789-00", "pedro.lima@email.com", "pedrolima", "senha789")
    );

    public Usuario(String nome, String cpf, String email, String login, String senha) {
        this.setNome(nome);
        this.cpf = cpf;
        this.setEmail(email);
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            if (nome.matches("[A-Za-zÀ-ÖØ-öø-ÿ ]+")) {
                this.nome = nome;
            } else {
                System.out.println("Nome inválido. Deve conter apenas letras.");
            }
        } else {
            System.out.println("Nome não pode ser vazio.");
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            if (email.contains("@")) {
                this.email = email;
            } else {
                System.out.println("Email inválido. Deve conter o caractere '@'.");
            }
        } else {
            System.out.println("Email não pode ser vazio.");
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario login(String email, String senha) {
        Optional<Usuario> usuarioOptional = MOCK_USUARIOS.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email) && u.getSenha().equals(senha))
                .findFirst();

        return usuarioOptional.orElse(null);
    }
}