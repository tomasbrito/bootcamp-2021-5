package junit.sespinoza;

public class KataTres {
    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        double cuentaFinal = -startPriceNew + startPriceOld;
        boolean alcanza = false;
        int iterador = 0;
        int iteradorDiferencia = 0;

        double priceNewPercent = 0;
        double priceOldPercent = 0;
        double priceNew = startPriceNew;
        double priceOld = startPriceOld;

        if(startPriceOld >= startPriceNew){
            alcanza = true;
            cuentaFinal = startPriceOld - startPriceNew;
        }
        while(!alcanza){
            iterador += 1;
            if(iterador == iteradorDiferencia + 2){
                percentLossByMonth += 0.5;
                iteradorDiferencia = iterador;
            }
            priceNewPercent = ((percentLossByMonth * priceNew)/100);
            priceOldPercent = ((percentLossByMonth * priceOld)/100);
            priceNew = priceNew - priceNewPercent;
            priceOld = priceOld - priceOldPercent;
            cuentaFinal = ((cuentaFinal +  priceNewPercent) - priceOldPercent) + savingperMonth;
            //System.out.println("Mes " + iterador + " :" +cuentaFinal);

            if(cuentaFinal >= 0){alcanza = true;}
        }
        cuentaFinal = Math.round(cuentaFinal);
        return new int[]{iterador, (int)cuentaFinal} ;
    }
}
