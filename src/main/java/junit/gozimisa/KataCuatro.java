package junit.gozimisa;

/*
Dentzil;myjinxin2015;raulbc777;smile67;SteffenVogel_79\n
3907;17945;10091;10088;10132\n
48;2;12;13;11

considerar que todos tengan la misma cantidad de columna
 */

import java.util.Arrays;

public class KataCuatro {
    public static String sortCsvColumns(String csvFileContent)  {
        String[] fila = csvFileContent.split("\n");
        String[] primeracolumna = new String[fila[0].split(";").length];

        Arrays.fill(primeracolumna, "");
        System.out.println(Arrays.asList(primeracolumna));
        for (String s : fila) {
            String[] line = s.split(";");
            for (int j = 0; j < line.length; j++) {
                primeracolumna[j] += line[j] + ",";
            }
        }
        Arrays.sort(primeracolumna, String.CASE_INSENSITIVE_ORDER);


        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < fila.length; i++) {
            for (String column : primeracolumna) {
                String[] temp = column.split(",");
                sb.append(temp[i]).append(";");
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);

        return String.valueOf(sb);
    }
}
