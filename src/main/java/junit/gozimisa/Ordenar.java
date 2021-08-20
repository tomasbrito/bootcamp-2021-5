package junit.gozimisa;

public class Ordenar {

    /**
     * Code Kata: Ordenar Cadena.
     * Cada palabra de la cadena contendrá un solo número.
     * Este número es la posición que debería tener la palabra en el resultado.
     *
     * Nota: Los números pueden ser del 1 al 9.
     * Por lo tanto, 1 será la primera palabra (no 0).
     *
     * Si la cadena de entrada está vacía,
     * devuelve una cadena vacía.
     * Las palabras en la cadena de entrada solo contendrán números consecutivos válidos.
     *
     * Ejemplos:
     *    "oraci4on un3a e2s Es1ta" -> "Es1ta e2s un3a oraci4on"
     *
     */

    public static String ordenacion(String oracion){
        String ordenado="";
        String[] palabras = oracion.split(" ");
        boolean banPalabra;

        for(int j=1;j<=palabras.length;j++){
            banPalabra=false;

            for(int i=0;i<palabras.length && banPalabra==false;i++){
                if(palabras[i].indexOf(Character.forDigit(j, 10))!=-1){
                    ordenado+=palabras[i]+' ';
                    banPalabra=true;
                }
            }
        }
        return ordenado;
    }
}

