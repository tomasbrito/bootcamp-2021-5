package junit.lkelly;
/*
Un hombre tiene un coche bastante viejo que vale $ 2000. Vio un automóvil de segunda mano que valía $ 8000. Quiere quedarse con su coche viejo hasta que pueda comprar uno de segunda mano.

Él cree que puede ahorrar $ 1000 cada mes, pero los precios de su automóvil viejo y del nuevo disminuyen un 1.5 por ciento por mes.
Además, este porcentaje de pérdida aumenta en un 0.5porcentaje al final de cada dos meses.
A nuestro hombre le resulta difícil hacer todos estos cálculos.

¿Puedes ayudarlo?

¿Cuántos meses le llevará ahorrar suficiente dinero para comprar el coche que quiere y cuánto dinero le sobrará?

Parámetros y retorno de función:

parameter (positive int or float, guaranteed) startPriceOld (Old car price)
parameter (positive int or float, guaranteed) startPriceNew (New car price)
parameter (positive int or float, guaranteed) savingperMonth
parameter (positive float or int, guaranteed) percentLossByMonth

nbMonths(2000, 8000, 1000, 1.5) should return [6, 766] or (6, 766)
Detalle del ejemplo anterior:
end month 1: percentLoss 1.5 available -4910.0
end month 2: percentLoss 2.0 available -3791.7999...
end month 3: percentLoss 2.0 available -2675.964
end month 4: percentLoss 2.5 available -1534.06489...
end month 5: percentLoss 2.5 available -395.71327...
end month 6: percentLoss 3.0 available 766.158120825...
return [6, 766] or (6, 766)
donde 6 es el número de meses al final de los cuales puede comprar el auto nuevo
y 766 es el número entero más cercano a 766.158...(el redondeo 766.158da 766).

Nota:

La venta, la compra y el ahorro se realizan normalmente a fin de mes.
Los cálculos se procesan al final de cada mes considerado, pero si, por casualidad desde el inicio,
el valor del automóvil viejo es mayor que el valor del nuevo o igual, no hay ningún ahorro que hacer,
no es necesario esperar, por lo que ¿Puede comprar el coche nuevo a principios de mes ?:

nbMonths(12000, 8000, 1000, 1.5) should return [0, 4000]
nbMonths(8000, 8000, 1000, 1.5) should return [0, 0]
No nos ocupamos de un depósito de ahorros en un banco :-)
* */

public class KataBuyCar {
    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        int month = 0;
        double priceOld = startPriceOld;
        double priceNew = startPriceNew;
        double diferencia = priceOld - priceNew;
        int save = 0;
        double total = 0;
        while (diferencia < 0.0){
            save += savingperMonth;
            month++;
            if(((month % 2) == 0) && (month>1)){
                percentLossByMonth += 0.5;
            }
            priceOld = (int) (priceOld - (priceOld*(percentLossByMonth/100)));
            priceNew = (int) (priceNew - (priceNew*(percentLossByMonth/100)));
            total = priceOld + save;
            diferencia = total - priceNew;
        }

        return  new int[] {month, (int) Math.round(diferencia)};
    }
}
