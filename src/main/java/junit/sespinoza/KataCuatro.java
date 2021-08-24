package junit.sespinoza;

import java.util.Arrays;

public class KataCuatro {
    public static String sortCsvColumns(String csvFileContent) {
        String resultado = "";
        String filas[] = csvFileContent.split("\n");
        String fila0[] =filas[0].split(";");
        String filasSeparadas[][] = new String[filas.length][fila0.length];
        for (int i = 0; i < filas.length; i++) {
            filasSeparadas[i] = filas[i].split(";");
        }

        boolean intercambio = true;
        while (intercambio){
            intercambio = false;
            int i = 1;
            while (i < fila0.length -1){
                if(fila0[i - 1].compareTo(fila0[i])>0){
                    String temp = filasSeparadas[0][i-1];
                    filasSeparadas[0][i-1] = filasSeparadas[0][i];
                    filasSeparadas[0][i] = temp;
                    intercambio= true;
                }
                i += 1;
            }
        }
        for (int i = 0; i < fila0.length; i++) {
            System.out.println(fila0[i]);
            System.out.println(filasSeparadas[1][i]);
            System.out.println(filasSeparadas[2][i]);
        }


        String arr1 = "";
        String arr2 = "";
        String arr3 = "";
        for (int i = 0; i < fila0.length; i++) {
            arr1 += fila0[i];
            //arr2 += fila1[i];
            //arr3 += fila2[i];
            if (i != fila0.length -1){
                arr1 += ";";
                arr2 += ";";
                arr3 += ";";
            }
        }
        arr1 += "\n";
        arr2 += "\n";
        resultado = arr1 + arr2 + arr3;

        return resultado;
    }
}
