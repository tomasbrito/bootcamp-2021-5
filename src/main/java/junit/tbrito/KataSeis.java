package junit.tbrito;

import java.util.ArrayList;

public class KataSeis {

    public static String[] whoEatsWho(final String zoo) {
        String [] canEatList = new String[] {"antelope eats grass",
                "big-fish eats little-fish",
                "bug eats leaves",
                "bear eats big-fish",
                "bear eats bug",
                "bear eats chicken",
                "bear eats cow",
                "bear eats leaves",
                "bear eats sheep",
                "chicken eats bug",
                "cow eats grass",
                "fox eats chicken",
                "fox eats sheep",
                "giraffe eats leaves",
                "lion eats antelope",
                "lion eats cow",
                "panda eats leaves",
                "sheep eats grass"
        };
        String [] animalesArray = zoo.split(",");
        ArrayList<String> animales;
        animales = arrayToList(animalesArray);
        ArrayList<String> finalList = new ArrayList<>();
        finalList = canEat(animales, canEatList);
        String [] resultado = finalList.toArray(new String[finalList.size()]);

        return resultado;
    }



    private static ArrayList<String> canEat(ArrayList<String> animales, String[] canEatList) {
        ArrayList<String> listaFinal = new ArrayList<>();
        // agregar la lista de animales al resultado
        String primerLinea = "";
        primerLinea += animales.get(0);
        for (int i = 1;i < animales.size();i++){
              primerLinea +=  "," + animales.get(i);
        }
        listaFinal.add(primerLinea);

        int i = 0;
        boolean comio = false;
        while(animales.size() != 1){
            comio = false;
            // si es el primero de la lista solo intenta comer a la derecha
            if(i == 0){
                String test = animales.get(i) + " eats " + animales.get(i+1);
                if(compare(test, canEatList)){
                    animales.remove(i+1);
                    i = 0;
                    comio = true;
                    listaFinal.add(test);
                }
            } else {
                // si no es el primero de la lista solo intenta comer a la izquierda y dsp derecha
                String test = animales.get(i) + " eats " + animales.get(i-1);
                // si come se vuelve al primer animal en la lista y se agrega al resultado final que animal comio a otro
                if (compare(test,canEatList)){
                    animales.remove(i-1);
                    i = 0;
                    comio = true;
                    listaFinal.add(test);
                }
                if(i < animales.size()-1){
                    test = animales.get(i) + " eats " + animales.get(i+1);
                    // si no comio a la izquierda intenta en la derecha.
                    if(i != 0 && compare(test,canEatList)){
                        animales.remove(i+1);
                        i = 0;
                        comio = true;
                        listaFinal.add(test);
                    }
                }


            }
                if (!comio){
                    i++;
                }
        }
        listaFinal.add(animales.get(0));
        return listaFinal;
    }

    // comparar el string con la lista de posibilidades.
    private static boolean compare(String test, String[] canEatList) {
        boolean found = false;
        int i = 0;
        while (!found && i + 1 <= canEatList.length) {
            if (test.equals(canEatList[i])) {
                found = true;
            } else {
                i++;
            }
        }
        return found;
    }


    // funcion para pasar un Array a lista - BUSCAR FUNCION DE JAVA.
    private static ArrayList<String> arrayToList(String[] animalesArray) {
        ArrayList<String> animales = new ArrayList<>();
        for(String a : animalesArray){
            animales.add(a);
        }
        return animales;
    }
}