package junit.sespinoza;

import java.util.Locale;

public class KataDos {
    public static String toAlternativeString(String s) {
        String newString = "";
        //recorremos el string
        for (int i = 0; i < s.length(); i++) {
            //si el caracter está entre 97 y 122 de ascii es minúscula
            if((int)s.charAt(i) >=97 && (int)s.charAt(i) <= 122){
                //en el nuevo string colocamos el mismo caracter pero en mayúsculas
                newString += (String.valueOf(s.charAt(i))).toUpperCase();
                //si el caracter está entre 65 y 90 es mayúscula
            }else if((int)s.charAt(i) >=65 && (int)s.charAt(i) <= 90){
                //en el nuevo string colocamos el mismo caracter pero en minúsculas
                newString += (String.valueOf(s.charAt(i))).toLowerCase();
            }else{
                //Si no es mayusculas ni minúsculas lo dejamos como estaba
                newString += s.charAt(i);
            }
        }
        return newString;
    }
}
