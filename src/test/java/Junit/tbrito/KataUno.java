package junit.tbrito;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class KataUno {
    public static String reverseWords(String s) {
        String resultado = "";
        String[] arr = s.split(" ");

        for(int i = 0; i <arr.length; i++){
            String palabra = arr[i];
            String palabraAlReves = "";
            int fin = palabra.length() - 1;
            while (fin >=0){
                palabraAlReves += palabra.charAt(fin);
                fin--;
            }
            resultado += palabraAlReves + " ";
        }

        return resultado.trim();
    }
}
