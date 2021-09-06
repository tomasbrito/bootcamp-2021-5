package junit.lkelly;

import java.util.*;
public class KataSortFiles {

    public static Object SortCsvColumns(String preSorting) {
        HashMap<String,ArrayList<String>> columnas;
        String[] lineas = preSorting.split("\n");
        ArrayList<ArrayList<String>> tabla = new ArrayList<>();
        for (int i=0; i<= lineas.length-1;i++){
            tabla.add(separarLineas(lineas,i));
        }

        columnas = new HashMap<>();
        for (int i=0; i<=tabla.get(0).size()-1;i++){
            columnas.put(tabla.get(0).get(i), new ArrayList<>());
        }
        for (int i=1; i<lineas.length;i++){
            for (int j=0; j< columnas.size();j++){
                addColumn(columnas,tabla.get(0).get(j), tabla.get(i).get(j));
            }
        }

        ArrayList<String> filaCero = tabla.get(0);
        filaCero.sort(String::compareToIgnoreCase);
        Object resultado = "";
        String key = null;
        int indice = 0;
        for (int i=0; i<= lineas.length-1;i++){
            for (int j=0; j<= columnas.size()-1;j++){
                if(i==0){ //Primera linea de las columnas fila 0
                    if(j == columnas.size()-1) resultado =  resultado + tabla.get(0).get(j) +"\n";
                    else resultado =  resultado + tabla.get(0).get(j)+";";
                }else{
                    key = tabla.get(0).get(j);
                    if(i == lineas.length-1 && (j == columnas.size()-1)){
                        resultado =  resultado + columnas.get(key).get(indice);
                    }else{
                        if(j == columnas.size()-1) resultado =  resultado + columnas.get(key).get(indice) +"\n";
                        else resultado =  resultado + columnas.get(key).get(indice)+";";
                    }

                }
            }
            if(key != null){
                if(indice == columnas.get(key).size()-1) indice = 0;
                else indice++;
            }

        }


        return resultado;
    }



    private static ArrayList<String> separarLineas(String[] lineas, int i){
       String s = lineas[i];
       return new ArrayList<String>(Arrays.asList(s.split(";")));
    }
    private static void addColumn(HashMap<String, ArrayList<String>> columnas, String key, String value) {
        ArrayList<String> tempList;
        if (columnas.containsKey(key)) {
            tempList = columnas.get(key);
            tempList.add(value);
        } else {
            tempList = new ArrayList<>();
            tempList.add(value);
        }
        columnas.put(key,tempList);
    }
}