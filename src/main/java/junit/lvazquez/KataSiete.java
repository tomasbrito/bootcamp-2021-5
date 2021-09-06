package junit.lvazquez;

public class KataSiete {

    public static long digPow(int n, int p) {

        String[] numArray = Integer.toString(n).split("");
        int pow = p;
        int sum = 0;

        for (String num : numArray) {
            sum += Math.pow(Integer.parseInt(num), pow);
            pow++;
        }

        boolean numExists = sum % n == 0;
        return numExists ? sum / n : -1;
    }
}
