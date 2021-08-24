package junit.imiguez;


public class KataTres {

    public static int[] nbMonths(int oldCar, int newCar, int saving, double devaluation) {
        int count = 0;
        double dev = 0;
        double oc = oldCar;
        double nc = newCar;
        double saved = oc;
        if (saved >= nc)
            System.out.println("end month "+count+": percentLoss "+(devaluation+dev)+" available "+ (saved - nc));
        while (saved < nc) {
            count++;
            if (count % 2 == 0)
                dev += 0.5;
            oc -= (devaluation + dev) * (oc/100);
            nc -= (devaluation + dev) * (nc/100);
            saved = oc + (count * saving);
            System.out.println("end month "+count+": percentLoss "+(devaluation+dev)+" available "+ (saved - nc));//end month 1: percentLoss 1.5 available -4910.0
        }
        return new int[]{count, (int) (saved-nc)};
    }



}
