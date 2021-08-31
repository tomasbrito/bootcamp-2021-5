package junit.earaya;

import java.util.*;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toMap;

public class Ordenar {
    /**
     * Code Kata: junit.earaya.Ordenar Cadena.
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
     *    "oraci4on un3a e2s Es1ta" -> "Es1ta e2s un3a oraci4on" // caso feliz
     *    "Esto1 no2 funciona4" -> "errornumeros" // negocio
     *    "" -> "" -> "errorvacio"// negocio
     *    "este tambien es un valor vacio" -> "errorvacioletras" // negocio
     *    " 1este 2es 3un 4string 5largo 6que 7necesita 8sobre 9diez 9palabras 9para 9fallar" -> "error" //negocio
     *
     *
     */


    public String order(String s) {

        //atributos
        int caracterNumero=0;
        String res="";

        //1. guardar la cadena en un array
        String[] palabrasSeparadas = s.split(" ");
        //2. buscar y ordenar las palabras en otro array
        HashMap palabraOrdenada = new HashMap();
        //busqueda de numeros en palabras
        for (String palabra:
                palabrasSeparadas) {
            //contar y guardar las palabras que contiene un numero dentro de ella
            for (int i = 0; i <palabra.length() ; i++) {
                char caracter = palabra.charAt(i);
                if (caracter == '1' || caracter == '2' || caracter == '3' || caracter == '4' ||
                        caracter == '5' ||caracter == '6' || caracter == '7' ||caracter == '8' ||
                        caracter == '9'){
                    caracterNumero++;
                    palabraOrdenada.put(Integer.parseInt(String.valueOf(caracter)),palabra);
                }
            }
        }
        //validar si en cada palabra existe la misma cantidad de numeros
        if(palabrasSeparadas.length == caracterNumero){
            //validar si el largo es mayor a 10
            if (caracterNumero >9){
                return "errorlargo";
            }
            //ordenar data
            palabraOrdenada= (HashMap) sortMapByKey(palabraOrdenada);
            //guardar Values en un String
            for (int i = 0; i <palabraOrdenada.size() ; i++) {
                //validar si palabra viene con un valor null
                if(palabraOrdenada.get(i+1)!= null){
                    res = res+palabraOrdenada.get(i+1) +" ";
                }else{
                    return "errornumeros";
                }

            }
            return res.trim();


        }else{
            if (caracterNumero==0 && palabrasSeparadas.length > 1){
                return "errorvacioletras";
            }
            return "errorvacio";
        }
    }

    private static Map<Integer, String> sortMapByKey(Map<Integer, String> map)
    {
        return map.entrySet().stream()
                .sorted(comparingInt(e -> e.getKey() ))
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError();},
                        LinkedHashMap::new
                ));
    }
}


