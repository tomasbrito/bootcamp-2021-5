package junit.lkelly;

public class Ordenar {

    /**
     * Code Kata: junit.lkelly.Ordenar Cadena.
     * Cada palabra de la cadena contendrá un solo número.
     *      * Este número es la posición que debería tener la palabra en el resultado.
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
    public  static void main(String args[]){
        Ordenar o = new Ordenar();
        System.out.println(o.ordenarCadena("oraci4on un3a e2s Es1ta"));
    }

    public static String ordenarCadena(String cadena) {
        String cadenaOrdenada ="";
        int i = 0;
        int pos = 1; // Número de posición de las palabras
        int ordenadas = 0; // Cantidad de palabras ordenadas
        boolean ordenada = false;
        if (!cadena.isEmpty()) {
            String[] subCadena = cadena.split(" ");
            while (!ordenada) {
                if(i== subCadena.length) i=0;
                if (subCadena[i].contains(Integer.toString(pos))) {
                    cadenaOrdenada = cadenaOrdenada + " " + subCadena[i];
                    pos++;
                    ordenadas++;
                }
                i++;
                if (ordenadas == subCadena.length) ordenada = true;
            }
        }
        return cadenaOrdenada.trim();
    }
}
