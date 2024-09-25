package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import business.Funcionario;

public class FuncionarioTest {

    private Funcionario funcionario;
    private String nome = "Matheus Fernandes de Oliveira";
    private String cpf = "123.456.789-11";
    private String email = "matheus.fer@gmail.com";
    private String login = "matheus.fer";
    private String senha = "112233mF";

    @BeforeEach
    public void setUp() {
        this.funcionario = new Funcionario(this.nome, this.cpf, this.email, this.login, this.senha);
    }

    @Test
    public void testSetNome() {
        assertEquals(this.nome, this.funcionario.getNome());
    }


    @Test
    public void testSetCpfFormatado() {
        assertEquals(this.cpf, this.funcionario.getCpfFormatado());
    }

    @Test
    public void testSetEmail() {
        assertEquals(this.email, this.funcionario.getEmail());
    }

    @Test
    public void testSetLogin() {
        assertEquals(this.login, this.funcionario.getLogin());
    }

    @Test
    public void testSetSenha() {
        assertEquals(this.senha, this.funcionario.getSenha());
    }
}

