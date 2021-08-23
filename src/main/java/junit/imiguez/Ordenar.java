package junit.imiguez;

import java.util.HashMap;

public class Ordenar {

    /**
     * Code Kata: junit.miguez.Ordenar Cadena.
     * Cada palabra de la cadena contendrá un solo número.
     * Este número es la posición que debería tener la palabra en el resultado.
     *
     * Nota: Los números pueden ser del 1 al 9.
     * Por lo tanto, 1 será la primera palabra (no 0).
     *
     * Si la cadena de entrada está vacía,
     * devuelve una cadena vacía.
     * Las palabras en la cadena de entrada solo contendrán números consecutivos válidos.
     *
     * Ejemplos:
     *    "oraci4on un3a e2s Es1ta" -> "Es1ta e2s un3a oraci4on"
     *
     */

    public static void main(String[] args) {
        System.out.println(orderString("oraci4on un3a e2s Esta desordena6da mu5y"));
        //System.out.println(orderString("oracion una"));
        //System.out.println(orderString(""));
    }

    public static String orderString(String str) {
        HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();//{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (int i = 0; i < 9; i++)
            numbers.put(49+i, 1+i);
        String[] arr1 = str.split(" ");
        int pos = 0;
        for (int j = 0; j < arr1.length; j++) {
            for (int i = 0; i < arr1[j].length(); i++) {
                try {
                    pos = (int) arr1[j].charAt(i);
                    if (pos >= 49 && pos <=57) {
                        pos = numbers.get((int) arr1[j].charAt(i)) - 1;
                        if (j != pos) {
                            String aux = arr1[pos];
                            arr1[pos] = arr1[j];
                            arr1[j] = aux;
                            i = arr1[j].length();
                        }
                    }
                } finally {
                }
            }
        }
        str = "";
        for (String s : arr1)
            str += s+" ";
        return str;
    }


}
