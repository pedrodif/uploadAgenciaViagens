import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioTest {

    @Test
    public void testConstrutorFuncionario() {
        // Cria um funcionário de exemplo
        String nome = "João Silva";
        String cpf = "123.456.789-00";
        String email = "joao.silva@example.com";
        String login = "joaosilva";
        String senha = "minhasenha";

        Funcionario funcionario = new Funcionario(nome, cpf, email, login, senha);

        // Verifica se os atributos foram definidos corretamente
        assertEquals(nome, funcionario.getNome());
        assertEquals(cpf, funcionario.getCpf());
        assertEquals(email, funcionario.getEmail());
        assertEquals(login, funcionario.getLogin());
        assertEquals(senha, funcionario.getSenha());
    }
}
