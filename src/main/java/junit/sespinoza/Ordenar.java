package junit.sespinoza;

public class Ordenar {

    /**
     * Code Kata: junit.sespinoza.Ordenar Cadena.
     * Cada palabra de la cadena contendrá un solo número.
     * Este número es la posición que debería tener la palabra en el resultado.
     * <p>
     * Nota: Los números pueden ser del 1 al 9.
     * Por lo tanto, 1 será la primera palabra (no 0).
     * <p>
     * Si la cadena de entrada está vacía,
     * devuelve una cadena vacía.
     * Las palabras en la cadena de entrada solo contendrán números consecutivos válidos.
     * <p>
     * Ejemplos:
     * "oraci4on un3a e2s Es1ta" -> "Es1ta e2s un3a oraci4on"
     */
    public static void main(String[] args) {
        KataCuatro.sortCsvColumns("myjinxin2015;raulbc777;smile67;Dentzil;SteffenVogel_79\n"
                + "17945;10091;10088;3907;10132\n"
                + "2;12;13;48;11");
    }
}

        /*String oracion = "oraci4on un3a e2s Es1ta";
        String newOracion = "";
        String palabraActual = "";

        String posPalabras[];
        posPalabras = new String[10];

        oracion += " ";

        if (oracion == ""){
            newOracion = "";
        }else {
            for (int i = 0; i < oracion.length() ; i++) {
                palabraActual += oracion.charAt(i);
                if(oracion.charAt(i) == ' '){
                    for (int j = 1; j <=9 ; j++) {
                        if (palabraActual.contains(String.valueOf(j))){
                            posPalabras[j] = palabraActual;
                            //break;
                        }
                    }
                    palabraActual = "";
                }
            }
            for (int i = 1; i < posPalabras.length ; i++) {
                while (posPalabras[i] != null){
                    newOracion += posPalabras[i];
                    break;
                }

            }
            System.out.println("input: " + oracion);
            System.out.println("output: " + newOracion);
        }
    }


}*/

