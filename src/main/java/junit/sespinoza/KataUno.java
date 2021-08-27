package junit.sespinoza;
public class KataUno{
    public static String reverseWords(String s) {
        String newWord = "";
        boolean contieneLetras = false;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' '){
                contieneLetras = true;
                s += " ";
                String palabras[] = s.split(" ");
                for(String palabra : palabras){
                    newWord += darVueltaPalabra(palabra) + " ";
                }
                break;
            }
        }
        if(contieneLetras){return newWord.trim();}else{return s;}

    }

    public static String darVueltaPalabra (String str){
        char ch[] = str.toCharArray();
        String palabraRet = "";
        for (int i = ch.length-1; i>=0; i--) {
            palabraRet += ch[i];
        }
        return palabraRet;
    }
}
