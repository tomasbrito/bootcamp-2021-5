package junit.imiguez;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

public class Dinglemouse {

    private static HashMap<String, String[]> foodChain = new HashMap<>();

    public static String[] whoEatsWho(final String zoo) {
        // Your code here
        loadFoodChain();
        ArrayList<String> animals = new ArrayList<String>(Arrays.asList(zoo.split(",")));
        ArrayList<String> eatenAnimals = new ArrayList<>();
        String eatenAnimal;
        for (int i = 0; i < animals.size(); i++) {
            if (i > 0 && canEat(animals.get(i), animals.get(i-1))) { // Si tiene un animal a su izquierda y se lo puede comer
                eatenAnimal = animals.get(i)+" eats "+animals.get(i-1);
                System.out.println(eatenAnimal);
                eatenAnimals.add(eatenAnimal);
                animals.remove(i-1);
                i -= 3;
            } else if (i+1 < animals.size() && canEat(animals.get(i), animals.get(i+1))) { // Si tiene un animal a su derecha y se lo puede comer
                eatenAnimal = animals.get(i)+" eats "+animals.get(i+1);
                System.out.println(eatenAnimal);
                eatenAnimals.add(eatenAnimal);
                animals.remove(i+1);
                i--;
            }
        }
        String[] results = new String[eatenAnimals.size()+2];
        results[0] = zoo;
        for (int i = 0; i < eatenAnimals.size(); i++)
            results[i+1] = eatenAnimals.get(i);
        results[eatenAnimals.size()+1] = animals.get(0);
        return results;
    }

    public static boolean canEat(String predator, String prey) {
        String[] preys = foodChain.get(predator.toLowerCase());
        if (preys == null)
            return false;
        for (int i = 0; i < preys.length; i++) {
            if (preys[i].equals(prey.toLowerCase()))
                return true;
        }
        return false;
    }

    private static void loadFoodChain() {
        foodChain.put("antelope", new String[]{"grass"});
        foodChain.put("big-fish", new String[]{"little-fish"});
        foodChain.put("bug", new String[]{"leaves"});
        foodChain.put("bear", new String[]{"big-fish", "bug", "chicken", "cow", "leaves", "sheep"});
        foodChain.put("chicken", new String[]{"bug"});
        foodChain.put("cow", new String[]{"grass"});
        foodChain.put("fox", new String[]{"chicken", "sheep"});
        foodChain.put("giraffe", new String[]{"leaves"});
        foodChain.put("lion", new String[]{"antelope", "cow"});
        foodChain.put("panda", new String[]{"leaves"});
        foodChain.put("sheep", new String[]{"grass"});
    }

}