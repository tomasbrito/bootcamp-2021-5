package junit.gastonb;

public class KataCuatro {
    public static Object SortCsvColumns(String preSorting) {
        String []fil = obtenerFilas(preSorting);//fil[0]=Dentzil;myjinxin2015;raulbc777;smile67;SteffenVogel_79...
        String [][]tabla= new String[fil.length][];
        for (int i = 0; i < fil.length; i++) {
            // for (int j = 0; j <= (contarCaracteres(fil[0], ';')); j++) {
            tabla[i]= fil[i].split(";");
        }
        // }
        tabla = ordAlf(tabla);
        String csvFileContent = acomodarMat(tabla);
        return csvFileContent;
    }

    private static String acomodarMat(String[][] tabla) {
        String cad= " ";
        String []vec = new String[tabla.length];
        for (int i = 0; i < vec.length; i++) {
            vec[i] = "\n" ;
        }
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[0].length-1; j++) {
                vec[i]= vec[i]+tabla[i][j]+";";
            }
            vec[i]= vec[i]+tabla[i][tabla[0].length-1];
        }
        for (int i = 0; i < tabla.length; i++) {
            cad = cad+vec[i];
        }

        StringBuilder fin = new StringBuilder(cad);
        fin = fin.deleteCharAt(0);
        fin = fin.deleteCharAt(0);
        cad =String.valueOf(fin);
        return cad;
    }

    public static String[] obtenerFilas(String cad){
        String[] fil = cad.split("\n");
        return  fil;
    }
    public static int contarCaracteres(String cadena, char caracter) {
        int posicion, contador = 0;
        //se busca la primera vez que aparece
        posicion = cadena.indexOf(caracter);
        while (posicion != -1) { //mientras se encuentre el caracter
            contador++;           //se cuenta
            //se sigue buscando a partir de la posición siguiente a la encontrada
            posicion = cadena.indexOf(caracter, posicion + 1);
        }
        return contador;
    }
    public static String[] obtenerColumnas(String cad){
        String[] col = cad.split(";");
        return col;
    }
    public static String[][] ordAlf(String[][] tab){
        int cont = 0;
        int tam= tab[0].length;
        while(cont<tab.length){
            for (int i = 0; i < tam-1; i++) {
                if (tab[0][i].compareToIgnoreCase(tab[0][i+1])>0){
                    for (int j = 0; j < tab.length;  j++) { //aaaaaaaaaaaaaa
                        String aux = tab[j][i];
                        tab[j][i]= tab[j][i+1];
                        tab[j][i+1] = aux;
                    }
                }
            }
            tam--;
            cont++;
        }
        return tab;
    }
}
