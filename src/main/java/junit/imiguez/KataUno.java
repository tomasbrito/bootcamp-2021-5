package junit.imiguez;

public class KataUno {

    //Complete the function that accepts a string parameter, and reverses each word in the string.
    //All spaces in the string should be retained.

    /*
    " " -> " "
    "a" -> "a"
    " 1  2   3 " -> " 1  2   3 "
     */

    public static void main(String[] args) {
        System.out.println(reverseWords(" double  spaces 1  2   3    4f "));
        //System.out.println(reverseWords("a"));
    }

    public static String reverseWords(String str) {
        String newStr = "";
        for (int i = 0; i < str.length(); i++) { // O(n)
            if (str.charAt(i) != ' ') {
                for (int f = i; f < str.length(); f++) {
                    if (f+1 == str.length() || str.charAt(f+1) == ' ') {
                        if (f != i) //Caso de que la palabra sea de mas de un caracter
                            newStr += reverseWord(str, i, f);
                        else //Caso de que la palabra sea de un caracter
                            newStr += str.charAt(f);
                        i = f; //Setteo i en el valor de la posicion final de la ultima palabra encontrada
                        f = str.length();
                    }
                }
            } else
                newStr += " ";
        }
        return newStr;
    }

    private static String reverseWord(String str, int iPos, int fPos) {
        String newWord = "";
        for (int i = fPos; i >= iPos; i--)
            newWord += str.charAt(i);
        return newWord;
    }

}
