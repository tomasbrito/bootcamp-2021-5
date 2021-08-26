package junit.lvazquez;

import java.util.StringJoiner;

public class KataUno {

    public static String reverseWords(String str) {
        //1. Dividir el String en un array de palabras
        String[] wordsArray = str.trim().isEmpty() ? str.split("\b") : str.split(" ");

        //2. Iterar entre las palabras del array y darlas vuelta
        String[] reversedWordsArray = new String[wordsArray.length];

        for (int i = 0; i < wordsArray.length; i++) {
            String reversedWord = reverseLetterOrder(wordsArray[i]);
            reversedWordsArray[i] = reversedWord;
        }

        //3. Devolver el array convertido nuevamente en un String
        return wordsArrayToString(reversedWordsArray);

    }

    private static String reverseLetterOrder(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    private static String wordsArrayToString(String[] wordsArr) {
        StringJoiner stringJoiner = new StringJoiner(" ");

        for (String word : wordsArr) {
            stringJoiner.add(word);
        }

        return stringJoiner.toString();
    }
}
