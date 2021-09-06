package junit.gozimisa;

import java.util.Arrays;

public class KataCuatro {
    public static String sortCsvColumns(String csvFileContent)  {
        String[] columna = csvFileContent.split("\n");
        String[] primerafila = new String[columna[0].split(";").length];

        //llenar un arreglo juntando los datos de las columnas
        Arrays.fill(primerafila, "");
        for (int i=0;i<columna.length;i++){
            String[] celda = columna[i].split(";");
            for (int j = 0; j < celda.length; j++) {
                primerafila[j] += celda[j] + ";";
            }
        }

        //ordenar
        System.out.println(Arrays.asList(primerafila));
        Arrays.sort(primerafila, String.CASE_INSENSITIVE_ORDER);

        //rehacer el arreglo y agregar los \n y ,
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < columna.length; i++) {
            for(int j=0; j<primerafila.length;j++){
                String[] temp = primerafila[j].split(";");
                sb.append(temp[i]).append(";");
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);

        return String.valueOf(sb);
    }
}

