package business;

import java.util.Random;

public class CodigoVoo {
    private static Random random = new Random();
    private static final String LETRAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String gerarCodigo(){
        StringBuilder codigo = new StringBuilder();
        
        for (int i = 0; i < 2; i++) {
            codigo.append(LETRAS.charAt(random.nextInt(LETRAS.length())));
        }

        codigo.append(random.nextInt(9000) + 1000);
        return codigo.toString();
    }
}