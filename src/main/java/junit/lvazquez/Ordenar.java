package junit.lvazquez;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Ordenar {

    public static void main(String[] args) {

        String oracion = "oraci6on un3a e2s Es1ta";
        String oracionOrdenada = ordenarOracion(oracion);
        System.out.println("Entrada: " + oracion);
        System.out.println("Salida: " + oracionOrdenada);

        String oracionVacia = "";
        String oracionVaciaOrdenada = ordenarOracion(oracionVacia);
        System.out.println("Entrada: " + oracionVacia);
        System.out.println("Salida: " + oracionVaciaOrdenada);

    }

    static List<Integer> getOrdenDePalabras(String[] wordsArray) {
        List<Integer> orden = new ArrayList<>();

        for (String word : wordsArray) {
            for (int i = 0; i < word.length(); i++) {
                char letra = word.charAt(i);

                if (Character.isDigit(letra)) {

                    int parsedNum = Character.getNumericValue(letra);
                    orden.add(parsedNum);

                }
            }
        }

        return orden;

    }

    static String[] ordenarArray(String[] strArr, List<Integer> orden) {
        String[] nuevoArr = new String[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            int currentOrder = orden.get(i) - 1;
            nuevoArr[i] = strArr[currentOrder];
        }

        return nuevoArr;
    }

    static String arrayAString(String[] strArr) {
        StringJoiner stringJoiner = new StringJoiner(" ");

        for (String palabra : strArr) {
            stringJoiner.add(palabra);
        }

        return stringJoiner.toString();

    }

    static String ordenarOracion(String oracion) {
        if (oracion.isEmpty()){
            return "";
        }

        String[] arrayDePalabras = oracion.split(" ");
        String[] arrayOrdenado = ordenarArray(arrayDePalabras, getOrdenDePalabras(arrayDePalabras));

        return arrayAString(arrayOrdenado);

    }
}
