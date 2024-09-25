package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import business.Funcionario;


public class FuncionarioTest {

    private Funcionario funcionario;
    private String nome = "Matheus Fernandes de Oliveira";
    private String cpf = "123.456.789-11";
    private String email = "matheus.fer@gmail.com";
    private String login = "matheus.fer";
    private String senha = "112233mF";

    @Before
    public void setUp() {
        funcionario = new Funcionario(nome, cpf, email, login, senha);
    }

    @Test
    public void testSetNome() {
        assertEquals(nome, funcionario.getNome());
    }


    @Test
    public void testSetCpfFormatado() {
        assertEquals(cpf, funcionario.getCpfFormatado());
    }

    @Test
    public void testSetEmail() {
        assertEquals(email, funcionario.getEmail());
    }

    @Test
    public void testSetLogin() {
        assertEquals(login, funcionario.getLogin());
    }

    @Test
    public void testSetSenha() {
        assertEquals(senha, funcionario.getSenha());
    }
}

