package junit.lkelly;

import java.util.ArrayList;
import java.util.Arrays;

/* REVERSE WORDS
* Description:
Complete the function that accepts a string parameter, and reverses each word in the string. All spaces in the string should be retained.

Examples
"This is an example!" ==> "sihT si na !elpmaxe"
"double  spaces"      ==> "elbuod  secaps"
*
*
* */
public class KataUno {

    public static String reverseWords(String s) {
        if (s.isEmpty()){
            return "";
        }else{
            ArrayList<String> reverseWords = new ArrayList<String>();
            ArrayList<String> words = separar(s);
            if (words.isEmpty()){
                return s;
            }else {
                for (int i=0; i<= words.size()-1;i++) {
                    String rW;
                    if(i== words.size()-1)  rW = arrayToString(reverse(words.get(i)));
                    else rW = arrayToString(reverse(words.get(i))) +" ";
                    reverseWords.add(rW);
                }
            }
            return arrayToString(reverseWords);
        }

    }

    // Método para convertir un ArrayList<String> a un String
    private static String arrayToString(ArrayList<String> a){
        String salida = "";
        for (int i=0; i<= a.size()-1; i++){
            salida = salida +a.get(i);
        }
        return salida;
    }

    //Método para seprarar subcadenas de la cadena original
    private static ArrayList<String> separar(String s){
        return new ArrayList<String>(Arrays.asList(s.split(" ")));
    }

    //Método para obtener la reversa de la cadena ingresada
    private static ArrayList<String> reverse(String word) {
        ArrayList<String> rWord = new ArrayList<>();
        if(word.length() > 1){
            int pos = word.length()-1;
            for (int i = 0 ; i < word.length() ; i++) {
                rWord.add(String.valueOf(word.charAt(pos)));
                pos--;
            }
        } else{
            rWord.add(word);
        }
        return rWord;
    }
}