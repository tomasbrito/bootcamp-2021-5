package junit.lkelly;

import java.util.*;
public class KataSortFiles {
    public static Object SortCsvColumns(String preSorting) {
        ArrayList<String> lineas = new ArrayList<>(Arrays.asList(Arrays.toString(preSorting.split("\n"))));
     //String[][] tabla;
        ArrayList<ArrayList<String>> tabla = new ArrayList<>();
        for (int i=0; i<= lineas.size()-1;i++){
            tabla.add(separarLineas(lineas,i));
        }

        HashMap<String,ArrayList<String>> columnas = new HashMap<>();
        for (int i=0; i<=tabla.get(0).size()-1;i++){
            columnas.put(tabla.get(0).get(i),new ArrayList<String>());
        }
        ArrayList<String> columna = new ArrayList<>();
        for (int i=1; i<=tabla.size()-1;i++){
          /*  for (int j=0;tabla.get(i).size()-1;j++){
                String key = tabla.get(0).get(i);
                columna = columnas.get(key);
                columna.add(columnas.get(i).get(j));
                columnas.put(key,columna);
            }*/
        }
        ArrayList<String> filaCero = tabla.get(0);
        for (int i=0; i<=filaCero.size()-1;i++){
            filaCero.get(i).toLowerCase();
        }

        Collections.sort(filaCero);

        Object resultado ="";

        for (int i=0; i<= tabla.get(0).size()-1;i++ ){
            resultado =  resultado + tabla.get(0).get(i) +"\n";
        }


        return resultado;
    }

    private static ArrayList<String> separarLineas(ArrayList<String> lineas, int i){
       String s = lineas.get(i);
       return new ArrayList<String>(Arrays.asList(s.split(";")));
    }

}