package business;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.mindrot.jbcrypt.BCrypt;

public class Usuario {

    private String nome;
    private String cpf;
    private String email;
    private String login;
    private String senhaHash;

    public static final List<Usuario> MOCK_USUARIOS = Arrays.asList(
        new Usuario("User1", "12345678901", "user1@example.com", "user1", "password1"),
        new Usuario("User2", "10987654321", "user2@example.com", "user2", "password2")
    );

    public Usuario(String nome, String cpf, String email, String login, String senha) {
        this.setNome(nome);
        this.cpf = cpf;
        this.setEmail(email);
        this.login = login;
        this.senhaHash = hashPassword(senha);
    }

    public String getNome() {
        return nome;
    }

    public boolean setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
            return true;
        } else {
            return false;
        }
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

    private String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        if (email != null && !email.trim().isEmpty()) {
            if (matcher.matches()) {
                this.email = email;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return null;
    }

    public void setSenha(String senha) {
        this.senhaHash = hashPassword(senha);
    }

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public Usuario login(String email, String senha) {
        return MOCK_USUARIOS.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email) && verificarSenha(senha, u.senhaHash))
                .findFirst()
                .orElse(null);
    }

    private boolean verificarSenha(String plainTextPassword, String hashedPassword) {
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }
}
