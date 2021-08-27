package junit.imiguez;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class CSVFileSort {

    /*myjinxin2015;raulbc777;smile67;Dentzil;SteffenVogel_79\n
    17945;10091;10088;3907;10132\n
    2;12;13;48;11*/


    public static String sortCsvColumns(String file) {
        String table = "";
        String [] rows = file.split("\n");
        String [] thead = rows[0].split(";");
        HashMap<Integer, Integer> order = getOrder(thead);
        for (int i = 0; i < rows.length; i++) {
            table += sortLine(rows[i], order);
            if (i+1 < rows.length)
                table += "\n";
        }
        tablevisualization(rows);
        return table;
    }

    private static void tablevisualization(String [] rows) {
        String table = "";
        String [] cols;
        for (int i = 0; i < rows.length; i++) {
            table += "|";
            cols = rows[i].split(";");
            for (int j = 0; j < cols.length; j++)
                table += cols[j]+" | ";
            table += "\n";
        }
        System.out.println(table);
    }

    private static String sortLine(String line, HashMap<Integer, Integer> order) {
        String sortedLine = "";
        String [] cols = line.split(";");
        for (int i = 0; i < cols.length; i++) {
            sortedLine += cols[order.get(i)];
            if (i+1 < cols.length)
                sortedLine += ";";
        }
        return sortedLine;
    }

    private static HashMap<Integer, Integer> getOrder(String [] th) {
        HashMap<String, Integer> origin = new HashMap<>();
        HashMap<Integer, String> sorted = new HashMap<>();
        HashMap<Integer, Integer> index = new HashMap<>();
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < th.length; i++) {
            origin.put(th[i].toLowerCase(), i);
            words.add(th[i].toLowerCase());
        }
            Collections.sort(words);
        for (int i = 0; i < th.length; i++)
            sorted.put(i, words.get(i).toLowerCase());
        for (int i = 0; i < th.length; i++)
            index.put(i, origin.get(sorted.get(i)));
        return index;
    }

}
