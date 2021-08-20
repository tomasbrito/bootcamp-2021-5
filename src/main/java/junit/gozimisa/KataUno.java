package junit.gozimisa;

/*
ej
"This is an example!" ==> "sihT si na !elpmaxe"
"double  spaces"      ==> "elbuod  secaps"

 */

public class KataUno {
    public static String reverseWords(final String original)
    {
        String output="";
        String reverse="";
        for(int j=original.length()-1; j>=0;j--){
            if(original.charAt(j)==' '){
                output=' '+reverse+output;
                reverse="";
            }
            else
                reverse+=original.charAt(j);
        }
        output=reverse+output;
        return output;
    }
}

