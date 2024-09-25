package test;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import business.Aeroporto;

public class AeroportoTest {

     private Aeroporto aeroporto;

     @BeforeEach
     public void setUp() {
         aeroporto = new Aeroporto();
     }

     @Test
     public void testSetNome() {
         boolean result = aeroporto.setNome("Aeroporto de Confins");
         assertTrue(result);
         assertEquals("Aeroporto de Confins", aeroporto.getNome());  
         
         result = aeroporto.setNome("");
         assertFalse(result);
         assertNotEquals("", aeroporto.getNome());   
         
         result = aeroporto.setNome("Aeroporto#123");
         assertFalse(result);
         assertNotEquals("Aeroporto#123", aeroporto.getNome());
     }

     @Test
     public void testSetSigla() {
         aeroporto.setSigla("XYZ");
         assertEquals("XYZ", aeroporto.getSigla());
     }

     @Test
     public void testSetCidade() {
         aeroporto.setCidade("Belo Horizonte");
         assertEquals("Belo Horizonte", aeroporto.getCidade());
     }

     @Test
     public void testSetEstado() {
         aeroporto.setEstado("SP");
         assertEquals("SP", aeroporto.getEstado());
     }


     @Test
     public void testSetPais() {
         aeroporto.setPais("Argentina");
         assertEquals("Argentina", aeroporto.getPais());
     }
}
