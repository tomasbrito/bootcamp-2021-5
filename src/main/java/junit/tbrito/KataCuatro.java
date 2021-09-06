package junit.tbrito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class KataCuatro {

    public static String sortCsvColumns(String csvFileContent) {
        String resultado = "";
        String[] filas = csvFileContent.split("\n");
        String[] columnas = filas[0].split(";");
        String[] fila1Presortes = filas[0].split(";");
        String[][] matriz = new String[filas.length][columnas.length];
        Arrays.sort(columnas,String.CASE_INSENSITIVE_ORDER);
        String [] acomodar;

        for (int i = 0; i < columnas.length; i++) {
            matriz[0][i] = columnas[i];
            int posOrig = buscarPosicion(matriz[0][i],fila1Presortes);
            for (int j = 1; j < filas.length; j++) {

                acomodar = filas[j].split(";");
                matriz[j][i] =  acomodar[posOrig];

            }
        }
        
        resultado = pasarMatrizAString(matriz);

        return resultado;

    }

    private static String pasarMatrizAString(String[][] matriz) {
        String resultado = "";
        for(int i = 0;i<=matriz.length-1;i++){
            for(int j = 0;j<=matriz[0].length-1;j++){
                if (j!=matriz[0].length-1) resultado += matriz[i][j] + ";"; else resultado += matriz[i][j];
            }

            if(i != matriz.length-1) resultado += "\n";

        }
        return resultado;
    }


    public static int buscarPosicion (String nombre, String []fila1PreSorted){
        boolean found = false;
        int resultado = -1;
        int i = 0;
        while (!found) {
            if (fila1PreSorted[i].equals(nombre)) {
                found = true;
                resultado = i;
            } else {
                i++;
            }
        }
        return resultado;
    }
}
