package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import business.Usuario;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


public class UsuarioTest {

  private Usuario usuario;

  @BeforeEach
  public void setUp() {
      usuario = new Usuario();
  }

  @Test
  public void testSetNome() {
      boolean result = usuario.setNome("Thyago Correa");
      assertTrue(result);
      assertEquals("Thyago Correa", usuario.getNome());
  
      result = usuario.setNome("");
      assertFalse(result);
      assertNotEquals("", usuario.getNome()); 
  
      result = usuario.setNome("Thyago#123");
      assertFalse(result);
      assertNotEquals("Thyago#123", usuario.getNome());
  }

  @Test
  public void testSetCpf() {
      String cpf = "123.456.789-00";
      usuario.setCpf(cpf);
      assertEquals(cpf, usuario.getCpfFormatado());
  }

  @Test
  public void testSetEmail() {
      boolean result = usuario.setEmail("thyago@gmail.com");
      assertTrue(result);
      assertEquals("thyago@gmail.com", usuario.getEmail());
  
      result = usuario.setEmail("");
      assertFalse(result);
      assertNotEquals("", usuario.getEmail()); 
  
      result = usuario.setEmail("thiago.com");
      assertFalse(result);
      assertNotEquals("thiago.com", usuario.getNome());
  }

  @Test
  public void testSetLogin() {
      String login = "usuario123";
      usuario.setLogin(login);
      assertEquals(login, usuario.getLogin());
  }

  @Test
  public void testSetSenha() {
      String senha = "Senha123";
      usuario.setSenha(senha);
      assertEquals(senha, usuario.getSenha());
  }

  @Test
  public void testLoginComSucesso() {
      Usuario usuario1 = new Usuario("Thyago", "123.456.789-00", "thiago@email.com", "thiago123", "senha123");
      Usuario.MOCK_USUARIOS.add(usuario1);

      Usuario resultado = usuario.login("thiago@email.com", "senha123");
      assertNotNull(resultado);
      assertEquals(usuario1, resultado);
  }

  @Test
  public void testLoginComEmailOuSenhaIncorretos() {
      Usuario usuario1 = new Usuario("Maria", "123.456.789-00", "maria@email.com", "maria123", "senha123");
      Usuario.MOCK_USUARIOS.add(usuario1);

      Usuario resultado = usuario.login("maria@email.com", "senha321");
      assertNull(resultado);
  }
}