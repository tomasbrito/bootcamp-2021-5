package junit.tbrito;

import java.util.ArrayList;

public class KataSiete {
    // 695 --> 6² +  9³  +  5⁴   = 1390 = 695 * 2
    //  n     n^p + n^p+1 + n^p+2 =  s  =  n * k
    public static long digPow(int n, int p) {
        int s = calcularS(n,p);
        int k=-1;

        if ((s % n) == 0){
            k = s/n;
        }
        return k;
    }

    private static int calcularS(int n,int p) {
        int s=0;
        ArrayList<Integer> numeros = new ArrayList<>();
        // desarmar el int
        while (n > 0) {
            numeros.add(n % 10);
            n = n / 10;
        }
        // calcular la suma de las numeros potenciados
        for(int i = numeros.size()-1;i>= 0; i--){
            s += Math.pow(numeros.get(i),p);
            p++;
        }
        return s;
    }

}
