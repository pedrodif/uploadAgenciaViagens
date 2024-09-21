package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.Usuario;

public class UsuarioTest {

    private Usuario usuario;

    @BeforeEach
    public void setUp() {
        usuario = new Usuario("Teste Nome", "111.222.333-44", "teste@email.com", "testelogin", "testesenha");
    }

    @Test
    public void testSetNome() {
        usuario.setNome("Novo Nome");
        assertEquals("Novo Nome", usuario.getNome());
    }

    @Test
    public void testSetCpf() {
        usuario.setCpf("999.888.777-66");
        assertEquals("999.888.777-66", usuario.getCpf());
    }

    @Test
    public void testSetEmail() {
        usuario.setEmail("novo@email.com");
        assertEquals("novo@email.com", usuario.getEmail());
    }

    @Test
    public void testSetLogin() {
        usuario.setLogin("novologin");
        assertEquals("novologin", usuario.getLogin());
    }

    @Test
    public void testSetSenha() {
        usuario.setSenha("novasenha");
        assertEquals("novasenha", usuario.getSenha());
    }

    @Test
    public void testLoginValido() {
        Usuario usuarioLogado = usuario.login("joao.silva@email.com", "senha123");
        assertNotNull(usuarioLogado);
        assertEquals("João Silva", usuarioLogado.getNome());
    }

    @Test
    public void testLoginInvalido() {
        Usuario usuarioLogado = usuario.login("email@invalido.com", "senhaerrada");
        assertNull(usuarioLogado);
    }
}
