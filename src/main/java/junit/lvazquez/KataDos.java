package junit.lvazquez;

public class KataDos {

    public static String toAlternativeString(String str) {

        //1. Convertir string a array de chars
        char[] charArr = str.toCharArray();
        char[] newCharArr = new char[charArr.length];

        //2. Iterar el array de chars, convirtiendo los lower a upper y viceversa
        for (int i = 0; i < charArr.length; i++) {

            char swappedLetter = Character.isUpperCase(charArr[i]) ?
                    Character.toLowerCase(charArr[i]) :
                    Character.toUpperCase(charArr[i]);

            newCharArr[i] = swappedLetter;
        }

        //3. Devolver un nuevo string creado con el array de chars
        return new String(newCharArr);
    }

}
