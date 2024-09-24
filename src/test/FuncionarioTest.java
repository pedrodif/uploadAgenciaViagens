import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioTest {

    @Test
    public void testConstrutorFuncionario() {

        String nome = "João Silva";
        String cpf = "123.456.789-00";
        String email = "joao.silva@example.com";
        String login = "joaosilva";
        String senha = "minhasenha";

        Funcionario funcionario = new Funcionario(nome, cpf, email, login, senha);


        assertEquals(nome, funcionario.getNome());
        assertEquals(cpf, funcionario.getCpf());
        assertEquals(email, funcionario.getEmail());
        assertEquals(login, funcionario.getLogin());
        assertEquals(senha, funcionario.getSenha());
    }
}
