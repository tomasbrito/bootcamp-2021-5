package junit.pcorzo;

import java.util.Locale;
import java.util.Scanner;

public class KataConvertir {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese texto: ");
        String texto = entrada.nextLine();
        System.out.println("El Texto es: " + texto);
        String texto2 = texto;
        if (texto.equals(texto2)) {
            String texto3 = texto.toUpperCase(Locale.forLanguageTag(texto2));
            System.out.println(texto3);
        }else {
            String texto3 = texto.toLowerCase(Locale.forLanguageTag(texto2));
            System.out.println(texto3);
        }

    }
}
