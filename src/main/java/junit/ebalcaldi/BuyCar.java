package junit.ebalcaldi;

public class BuyCar {
    public static int[] nbMonths(int precioViejo, int precioNuevo, int ahorroPorMes, double porcentaje) {
        int ahorros = 0;
        int meses = 0;
        int[] resultado = new int[2];

        while(precioViejo + ahorros < precioNuevo){
            meses++;
            if(meses % 2 == 0)
                porcentaje += 0.5;

            precioViejo -= precioViejo *(porcentaje / 100);
            precioNuevo -= precioNuevo *(porcentaje / 100);
            ahorros += ahorroPorMes;
        }

        int sobras = ahorros + precioViejo - precioNuevo;


        resultado[0] = meses;
        resultado[1] = sobras;


        return resultado;
    }
}
