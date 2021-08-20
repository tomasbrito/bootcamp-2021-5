package junit.imiguez;

public class KataDos {

    public static void main(String[] args) {
        System.out.println(toAlternativeString("dOubLe  Spaces"));
    }

    public static String toAlternativeString(String str) {
        String newStr = "";
        String l = "";
        for (int i = 0; i < str.length(); i++) { // O(n)
            l = str.charAt(i)+"";
            if (l == l.toUpperCase())
                newStr += l.toLowerCase();
            else if (l == l.toLowerCase())
                newStr += l.toUpperCase();
        }
        return newStr;
    }


}
