package junit.gozimisa;

public class KataTres {
    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {

        int month=0;
        int saving=0;
        double money=startPriceOld-startPriceNew;
        double Old=startPriceOld;
        double New=startPriceNew;

        while (money<0) {
            month++; //nuevo mes
            saving = saving + savingperMonth; //se suma lo ahorrado
            if (month % 2 == 0) {
                percentLossByMonth = percentLossByMonth + 0.5; //cada 2 meses aumenta el porcentaje
            }
            Old = (Old - (Old * percentLossByMonth / 100)); //nuevo precio
            New = (New - (New * percentLossByMonth / 100)); //nuevo precio
            money = Old - New + saving; //precio del antiguo - precio del nuevo + ahorros
        }
        if(money-(int)money>0.5)//redondeo
            money=(int)money+1;

        System.out.print("mes:"+month+" plata:"+(int)money);
        int[] r = new int[] { month, (int)money };
        return r;
    }
}
