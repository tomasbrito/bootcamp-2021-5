package junit.tbrito;



public class KataDos {
    public static String toAlternativeString(String hello_world) {
        char[]tempCharArray = hello_world.toCharArray();
        // for recorrer todos los caracteres
        for(int i = 0;i <= hello_world.length()-1;i++){
            if(Character.isUpperCase(hello_world.charAt(i))){
                tempCharArray[i] = Character.toLowerCase(hello_world.charAt(i));

            } else if (Character.isLowerCase(hello_world.charAt(i))){
                tempCharArray[i] = Character.toUpperCase(hello_world.charAt(i));
            }
        }
        hello_world = String.valueOf(tempCharArray);
        return hello_world;

    }
}
