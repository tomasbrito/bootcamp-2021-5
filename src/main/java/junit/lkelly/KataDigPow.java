package junit.lkelly;

import java.util.ArrayList;

public class KataDigPow {
    public static long digPow(int i, int i1) {
       int result = -1;
       int suma =0;
       int number = i;
       int pow = i1;
        ArrayList<Integer> digits = separarDigitos(number);
       if(!digits.isEmpty()){
           for (int j=digits.size() -1; j>=0 ;j--){
               suma += Math.pow(digits.get(j),pow);
               pow++;
           }
       }
       if((suma % number) == 0 ){
           result = suma / number;
       }else{
           result = -1;
       }

       return result;
    }

    private static ArrayList<Integer> separarDigitos(int i){
        ArrayList<Integer> result = new ArrayList<>();
        int number =i;
        while (number > 0) {
            result.add(number % 10);
            number = number / 10;
        }
        return  result;
    }
}
