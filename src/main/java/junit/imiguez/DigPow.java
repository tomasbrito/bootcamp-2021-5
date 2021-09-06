package junit.imiguez;

public class DigPow {

    public static long digPow(int n, int p) {
        // your code
        char[] digits = String.valueOf(n).toCharArray();
        int powsResult = 0;
        int pows = p;
        for (int i = 0; i < digits.length; i++) {
            powsResult += Math.pow(Integer.valueOf(String.valueOf(digits[i])), pows);
            pows++;
        }
        if (powsResult < n)
            return -1;
        return powsResult / n;
    }

}
