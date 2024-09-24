package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import business.Usuario;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


public class UsuarioTest {

  private List<Usuario> usuariosMock;

  @BeforeEach
  public void setUp() {
    usuariosMock = Usuario.MOCK_USUARIOS;
  }

  @Test
  public void testLoginComCredenciaisValidas() {
    String emailValido = "joao.silva@email.com";
    String senhaValida = "senha123";

    Optional<Usuario> usuarioLogado = usuariosMock.stream()
        .filter(u -> u.getEmail().equalsIgnoreCase(emailValido) && u.getSenha().equals(senhaValida))
        .findFirst();

    assertTrue(usuarioLogado.isPresent());
    assertEquals("João Silva", usuarioLogado.get().getNome());
  }

  @Test
  public void testLoginComEmailInvalido() {
    String emailInvalido = "email.inexistente@email.com";
    String senhaValida = "senha123";

    Optional<Usuario> usuarioLogado = usuariosMock.stream()
        .filter(u -> u.getEmail().equalsIgnoreCase(emailInvalido) && u.getSenha().equals(senhaValida))
        .findFirst();

    assertFalse(usuarioLogado.isPresent());
  }

  @Test
  public void testLoginComSenhaInvalida() {
    String emailValido = "joao.silva@email.com";
    String senhaInvalida = "senhaErrada";

    Optional<Usuario> usuarioLogado = usuariosMock.stream()
        .filter(u -> u.getEmail().equalsIgnoreCase(emailValido) && u.getSenha().equals(senhaInvalida))
        .findFirst();

    assertFalse(usuarioLogado.isPresent());
  }
}