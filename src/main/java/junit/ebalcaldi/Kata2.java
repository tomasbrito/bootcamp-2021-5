package junit.ebalcaldi;

public class Kata2 {
    public static String toAlternativeString(String text){
        String resultado = "";
        char[] arr = text.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(Character.isLowerCase(arr[i])){
                resultado += Character.toUpperCase(arr[i]);
            }else{
                resultado += Character.toLowerCase(arr[i]);
            }
        }
        return resultado;

    }
}
