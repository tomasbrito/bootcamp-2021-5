package junit.lkelly;

import java.util.ArrayList;
import java.util.Arrays;

public class KataZoo {

    private static final ArrayList<String[]> animals = new ArrayList<>();

    public static String[] whoEatsWho(String input) {
        setAnimals();
        ArrayList<String> eatList = new ArrayList<>();
        eatList.add(input);
        if(!input.equals("")){
            ArrayList<String> listAnimals = new ArrayList<>(Arrays.asList(input.split(",")));
            int     right = 0,
                    left = 0,
                    i = 0 ,
                    intentos=0;
            while (listAnimals.size() > 1  && intentos < listAnimals.size()) {

                int actual = i;
                if (actual < listAnimals.size()-1) right = actual + 1;
                if (actual > 0) left = actual - 1;
                String animal = listAnimals.get(actual);
                if(searchAnimal(animal) != -1){
                    if ((left >= 0) && (eats(listAnimals.get(i), listAnimals.get(left)))) {
                        eatList.add(listAnimals.get(i) + " eats " + listAnimals.get(left));
                        listAnimals.remove(left);
                        intentos =0;
                        i=0;
                    } else if ((eats(listAnimals.get(i), listAnimals.get(right)))&& (right < listAnimals.size())) {
                        eatList.add(listAnimals.get(i) + " eats " + listAnimals.get(right));
                        listAnimals.remove(right);
                        i++;
                        intentos=0;
                    } else {
                        i++;
                        intentos++;
                    }
                }else{
                    i++;
                    if(i== listAnimals.size()) intentos++;
                }
                //right=0;
                left=0;
                if(i== listAnimals.size()) i=0;
            }
            String finLista = "";
            if(intentos >= listAnimals.size()) {
                for (int k = 0; k < intentos; k++) {
                    if(k==0) finLista = listAnimals.get(k);
                    else finLista = finLista +"," + listAnimals.get(k);
                }
            }else{
                finLista = listAnimals.get(i);
            }
            if(!finLista.equals(eatList.get(0))) eatList.add(finLista);
        }
        String[] result = new String[eatList.size()];
       for (int j=0; j< eatList.size(); j++){
           result[j] = eatList.get(j);
       }
       return result;
    }
    private static void setAnimals(){
        String[] antelope = {"antelope","grass"}; animals.add(antelope);
        String[] bigFish = {"big-fish","little-fish"}; animals.add(bigFish);
        String[] bug = {"bug","leaves"}; animals.add(bug);
        String[] bear = {"bear","big-fish","bug","chicken","cow","leaves","sheep"}; animals.add(bear);
        String[] chicken = {"chicken","bug"};  animals.add(chicken);
        String[] cow = {"cow","grass"}; animals.add(cow);
        String[] fox = {"fox","chicken","sheep"}; animals.add(fox);
        String[] giraffe = {"giraffe","leaves"}; animals.add(giraffe);
        String[] lion = {"lion","antelope","cow"}; animals.add(lion);
        String[] panda = {"panda","leaves"}; animals.add(panda);
        String[] sheep = {"sheep","grass"}; animals.add(sheep);
    }
    private static boolean eats(String animal, String food) {
        boolean eat = false;
        int animalIndex = searchAnimal(animal);
        if( animalIndex!= -1){
            for (int i=1; i< animals.get(animalIndex).length;i++){
                if (food.equals(animals.get(animalIndex)[i])){
                    eat = true;
                }
            }
        }
        return eat;
    }


    private static int searchAnimal(String animal){
        int result = -1;
       if(!animal.equals(null)){
           for (int i=0; i< animals.size();i++){
               if (animal.equals(animals.get(i)[0])) {
                   result = i;
               }
           }
       }
        return result;
    }
}
