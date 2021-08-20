package junit.gozimisa;

/*
StringUtils.toAlternativeString("hello world") == "HELLO WORLD"
StringUtils.toAlternativeString("HELLO WORLD") == "hello world"
StringUtils.toAlternativeString("hello WORLD") == "HELLO world"
StringUtils.toAlternativeString("HeLLo WoRLD") == "hEllO wOrld"
 */

public class KataDos {
    public static String toAlternativeString(String string) {
        String output="";
        for(int i=0;i<string.length();i++){
            if(Character.isUpperCase(string.charAt(i))){
                output+=Character.toLowerCase(string.charAt(i));
            }
            else if(Character.isLowerCase((string.charAt(i)))){
                output+=Character.toUpperCase(string.charAt(i));
            }
            else
                output+=string.charAt(i);
        }
        return output;
    }
}
