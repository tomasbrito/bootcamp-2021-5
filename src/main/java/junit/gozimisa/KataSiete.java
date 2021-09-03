package junit.gozimisa;

import static java.lang.Math.pow;

public class KataSiete {
    public static long digPow(int n, int p) {
        long number=n;
        int largo= Integer.toString(n).length();
        int potmax=largo+p-1;
        double resultado=0;
        while(number > 0){
            resultado= pow(number % 10,potmax)+resultado;
            number = number / 10;
            potmax--;
        }
        if((long)resultado%n==0)
            return (long)resultado/n;
        return -1;
    }
    //46288 --> 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51
}
