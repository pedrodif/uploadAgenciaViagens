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

    public static List<Usuario> MOCK_USUARIOS = Arrays.asList(
        new Usuario("João Silva", "123.456.789-00", "joao.silva@email.com", "joaosilva", "senha123"),
        new Usuario("Maria Souza", "987.654.321-00", "maria.souza@email.com", "mariasouza", "senha456"),
        new Usuario("Pedro Lima", "456.123.789-00", "pedro.lima@email.com", "pedrolima", "senha789")
    );

    public Usuario(String nome, String cpf, String email, String login, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }


    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
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
