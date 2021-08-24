package junit.lkelly;

import java.util.*;
public class KataSortFiles {
    public static Object SortCsvColumns(String preSorting) {
       String[] lineas = preSorting.split("\n");
     //String[][] tabla;
        ArrayList<ArrayList<String>> tabla = new ArrayList<>();
        for (int i=0; i<= lineas.length-1;i++){
            tabla.add(separarLineas(lineas,i));
        }

        HashMap<String,ArrayList<String>> columnas = new HashMap<>();
        for (int i=0; i<=tabla.get(0).size()-1;i++){
            columnas.put(tabla.get(0).get(i),new ArrayList<String>());
        }
        ArrayList<String> columna = new ArrayList<>();
        // FALTA AGREGAR
        ArrayList<String> filaCero = tabla.get(0);
        filaCero.sort(String::compareToIgnoreCase);


        Object resultado ="";

        for (int i=0; i<= tabla.get(0).size()-1;i++ ){
            if(i == tabla.get(0).size()-1) resultado =  resultado + tabla.get(0).get(i) +"\n";
            else resultado =  resultado + tabla.get(0).get(i) +" | ";
        }



        return resultado;
    }

    private static ArrayList<String> separarLineas(String[] lineas, int i){
       String s = lineas[i];
       return new ArrayList<String>(Arrays.asList(s.split(";")));
    }

}