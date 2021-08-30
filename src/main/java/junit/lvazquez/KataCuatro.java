package junit.lvazquez;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

public class KataCuatro {

    public static String sortCsvColumns(String csvFileContent) {

        //1. Extraer los renglones, separar los titulos y ordenarlos
        String[] rawData = csvFileContent.split("\n");
        String[] titles = rawData[0].split(";");
        String[] sortedTitles = rawData[0].split(";");
        Arrays.sort(sortedTitles, String.CASE_INSENSITIVE_ORDER);

        //2. Unir los titulos en orden
        StringJoiner sortedTitlesJoiner = new StringJoiner(";");
        for (String title : sortedTitles) {
            sortedTitlesJoiner.add(title);
        }
        String sortedTitlesStr = sortedTitlesJoiner.toString();

        //3. Buscar el orden en que aparecen los titulos al estar ordenados en la secuencia original
        //3a. Buscar el indice que tiene una palabra ordenada en el array desordenado
        ArrayList<Integer> order = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            int num = Arrays.asList(titles).indexOf(sortedTitles[i]);
            order.add(num);
        }

        //4. Crear arrays de strings con las lineas de datos
        //4.a empieza en -1 porque no se cuenta el titulo
        String[] dataLines = new String[rawData.length - 1];
        for (int i = 0; i < dataLines.length; i++) {
            dataLines[i] = rawData[i + 1];
        }

        //5. Separar los arrays de lineas de texto en arrays de arrays de palabras
        String[][] dataArrays = new String[dataLines.length][];

        for (int i = 0; i < dataLines.length; i++) {
            dataArrays[i] = dataLines[i].split(";");
        }

        //6. ordenar las palabras en cada array de palabras segun el orden extraido antes
        ArrayList<ArrayList<String>> orderedDataArrays = new ArrayList<ArrayList<String>>();

        for (int i = 0; i < dataArrays.length; i++) {
            ArrayList<String> helper = new ArrayList<>();

            for (int j = 0; j < dataArrays[i].length; j++) {
                helper.add(dataArrays[i][order.get(j)]);
            }

            orderedDataArrays.add(helper);
        }

        //7. unir las palabras ordenadas en lineas, ordenar las lineas en strings completas
        //7a. primero agregar el titulo ordenado previamente extraido
        StringJoiner CSVstringJoiner = new StringJoiner("\n");
        CSVstringJoiner.add(sortedTitlesStr);

        for (ArrayList<String> dataArray : orderedDataArrays) {
            StringJoiner innerStringJoiner = new StringJoiner(";");
            for (String data : dataArray) {
                innerStringJoiner.add(data);
            }
            CSVstringJoiner.add(innerStringJoiner.toString());
        }

        return CSVstringJoiner.toString();
    }
}