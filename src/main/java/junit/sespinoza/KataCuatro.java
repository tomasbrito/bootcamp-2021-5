package junit.sespinoza;

import java.util.Arrays;

public class KataCuatro {
    public static String sortCsvColumns(String csvFileContent) {
        String resultado = "";
        String filas[] = csvFileContent.split("\n");
        String titleCopy[] =filas[0].split(";");
        String filasSeparadas[][] = new String[filas.length][titleCopy.length];
        for (int i = 0; i < filas.length; i++) {
            filasSeparadas[i] = filas[i].split(";");
        }
        Arrays.sort(titleCopy,String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < titleCopy.length; i++) {
            for (int j = 0; j < titleCopy.length; j++) {
                if(titleCopy[i].equals(filasSeparadas[0][j])){
                    for (int k = 0; k < filas.length; k++) {
                        String aux = filasSeparadas[k][i];
                        filasSeparadas[k][i] = filasSeparadas[k][j];
                        filasSeparadas[k][j] = aux;
                    }
                }
            }
        }
        for (int i = 0; i < filas.length; i++) {
            for (int j = 0; j < titleCopy.length; j++) {
                resultado += filasSeparadas[i][j];
                if(j != titleCopy.length-1) {
                    resultado += ";";
                }
            }
            if(i != filas.length - 1){
                resultado += "\n";
            }
        }
        return resultado;
    }
}
