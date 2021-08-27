package junit.ebalcaldi;

import java.util.Arrays;

public class Kata1 {
    public static String reverseWords(String text){
        String resultado = "";
        String[] arr = text.split(" ");

        for (int i = 0; i < arr.length; i++) {
            String palabra = arr[i];
            String palabraAlReves = "";
            int fin = palabra.length() -1;
            while(fin >= 0 ){
                palabraAlReves += palabra.charAt(fin);
                fin--;
            }
            resultado += palabraAlReves + " ";
        }
        return resultado.trim();
    }


}
