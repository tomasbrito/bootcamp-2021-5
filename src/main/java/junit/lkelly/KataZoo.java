package junit.lkelly;

import java.util.ArrayList;
import java.util.Arrays;

public class KataZoo {

    private static final ArrayList<String[]> animals = new ArrayList<>();

    public static String[] whoEatsWho(String input) {
        setAnimals();
       ArrayList<String> eatList = new ArrayList<>();
        eatList.add(input);
       ArrayList<String> listAnimals = new ArrayList<>(Arrays.asList(input.split(",")));
        int right =0;
        int left = 0;
       for (int i=0; i<listAnimals.size();i++){
           int actual = i;
           if(actual < listAnimals.size()-1){
               left = actual + 1;
           }
          if(actual > 0) {
               right = actual - 1;
          }
           if(eats(listAnimals.get(i),listAnimals.get(left))){
               eatList.add(listAnimals.get(i) + " eats " + listAnimals.get(left));
               System.out.println(listAnimals.get(i) + " eats " + listAnimals.get(left));
           }else{
               if((right>0) && (eats(listAnimals.get(i),listAnimals.get(right)))) {
                   eatList.add(listAnimals.get(i) + " eats " + listAnimals.get(right));
                   System.out.println(listAnimals.get(i) + " eats " + listAnimals.get(right));
               }
           }
           if (i== listAnimals.size()-1){
               eatList.add(listAnimals.get(i));
           }
       }
        String[] result = new String[eatList.size()];
       for (int i=0; i< eatList.size(); i++){
           result[i] = eatList.get(i);
       }
       return result;
    }
    private static void setAnimals(){
        String[] antelope = {"antelope","grass"}; animals.add(antelope);
        String[] bigFish = {"bigFish","little-fish"}; animals.add(bigFish);
        String[] bug = {"bug","leaves"}; animals.add(bug);
        String[] bear = {"bear","big-fish","bug","chicken","cow","leaves","sheep"}; animals.add(bear);
        String[] chicken = {"chicken","bug"};  animals.add(chicken);
        String[] cow = {"cow","grass"}; animals.add(cow);
        String[] fox = {"fox","chicken","sheep"}; animals.add(fox);
        String[] giraffe = {"giraffe","leaves"}; animals.add(giraffe);
        String[] lion = {"lion","antelope","cow"}; animals.add(lion);
        String[] panda = {"panda","leaves"}; animals.add(panda);
        String[] sheep = {"sheep"}; animals.add(sheep);
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
       //NO FUNCIONA --> Ver por qué?
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
