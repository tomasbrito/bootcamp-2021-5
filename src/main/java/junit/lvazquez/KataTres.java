package junit.lvazquez;

public class KataTres {

    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {

        //0. Establecer variables. Los autos van a mutar de int a double
        int meses = 0;
        int ahorros = 0;
        double autoViejo = startPriceOld;
        double autoNuevo = startPriceNew;
        double perdidaPorcent;

        //1. Fijarse que no disponga del dinero ya al comienzo
        if (startPriceOld >= startPriceNew) {
            int sobra = (int) (autoViejo - autoNuevo);
            return new int[]{0, sobra};
        }

        //2. ir aumentando de meses, ahorros y porcentajes y bajando de precios
        // hasta poder comprar el auto nuevo
        while (ahorros + autoViejo < autoNuevo) {
            meses = meses + 1;
            ahorros = ahorros + savingperMonth;
            perdidaPorcent = aumentarPerdida(meses, percentLossByMonth);
            autoViejo = depreciarAuto(autoViejo, perdidaPorcent);
            autoNuevo = depreciarAuto(autoNuevo, perdidaPorcent);
        }

        //3. Redondear el precio y calcular cuanto sobra despues de la compra
        double sobra = Math.round(ahorros + autoViejo - autoNuevo);
        return new int[]{meses, (int) sobra};

    }

    private static double aumentarPerdida(int meses, double porcentPorMes){
        return porcentPorMes + meses / 2 * 0.5;
    }

    private static double depreciarAuto(double precioAuto, double perdidaPorcent){
        return precioAuto - precioAuto * perdidaPorcent / 100;
    }

}

