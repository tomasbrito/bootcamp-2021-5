package junit.earaya;


import java.util.Arrays;
import java.util.Collections;

public class KataUno {
    public static String reverseWords(String s) {

        String[] palabraCortada = s.split(" ");
        if(palabraCortada.length==0 && s.contains(" ")){

            palabraCortada = s.split("\\s");
        }
        String resultado="";
        String palabraAlreves="";
        for (String palabra :
             palabraCortada) {
            String[] caracteresCortados = palabra.split("");
            Collections.reverse(Arrays.asList(caracteresCortados));
            for (int i = 0; i < caracteresCortados.length ; i++) {
                palabraAlreves = palabraAlreves+caracteresCortados[i];
            }
            palabraAlreves = palabraAlreves+" ";
        }
     return palabraAlreves.trim();
    }
}
