package business;

import java.util.List;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {

    public static final List<Usuario> MOCK_USUARIOS = Arrays.asList(
        new Usuario("User1", "12345678901", "user1@example.com", "user1", "password1"),
        new Usuario("User2", "10987654321", "user2@example.com", "user2", "password2")
    );

    private String nome, cpf, email, login, senha;

    public Usuario() {}

    public Usuario(String nome, String cpf, String email, String login, String senha) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setEmail(email);
        this.login = login;
        this.senha = senha;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
            return true;
        }    
        return false;
    }

    public String getCpfFormatado() {
        if (cpf == null || cpf.length() != 11) {
            return null; 
        }
        StringBuilder formattedCpf = new StringBuilder();
        formattedCpf.append(cpf.substring(0, 3));
        formattedCpf.append(".");
        formattedCpf.append(cpf.substring(3, 6));
        formattedCpf.append(".");
        formattedCpf.append(cpf.substring(6, 9));
        formattedCpf.append("-");
        formattedCpf.append(cpf.substring(9));
        return formattedCpf.toString();
    }

    public void setCpf(String cpf) {
        if (cpf != null) {
            String cpfSemSeparadores = cpf.replaceAll("[.-]", "");
            this.cpf = cpfSemSeparadores;
        }
    }

    public String getEmail() {
        return this.email;
    }

    public boolean setEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        if (email != null && !email.trim().isEmpty() && matcher.matches()) {
            this.email = email;
            return true;
        }
        return false;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Usuario login(String email, String senha) {
        return MOCK_USUARIOS.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email) && u.getSenha().equalsIgnoreCase(senha))
                .findFirst()
                .orElse(null);
    }
}