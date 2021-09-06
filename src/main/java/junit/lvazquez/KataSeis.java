package junit.lvazquez;

import java.util.*;

public class KataSeis {

    public static String[] whoEatsWho(final String zoo) {
        String[] zooArr = zoo.split(",");
        List<String> animalsOrder = new ArrayList<>();

        Collections.addAll(animalsOrder, zooArr);

        HashMap<String, String> eatList = new HashMap<>();
        eatList.put("antelope", "grass");
        eatList.put("big-fish", "little-fish");
        eatList.put("bug", "leaves");
        eatList.put("bear", "big-fish,bug,chicken,cow,leaves,sheep");
        eatList.put("chicken", "bug");
        eatList.put("cow", "grass");
        eatList.put("fox", "chicken,sheep");
        eatList.put("giraffe", "leaves");
        eatList.put("lion", "antelope,cow");
        eatList.put("panda", "leaves");
        eatList.put("sheep", "grass");

        List<String> theKilling = new ArrayList<>();
        theKilling.add(zoo);

        int i = 0;
        boolean someoneAte;

        while (i < animalsOrder.size()) {

            someoneAte = false;

            if (eatList.containsKey(animalsOrder.get(i))) {

                if (i > 0 && eatList.get(animalsOrder.get(i)).contains(animalsOrder.get(i - 1))) {
                    theKilling.add(animalsOrder.get(i) + " eats " + animalsOrder.get(i - 1));
                    animalsOrder.remove(i - 1);
                    someoneAte = true;
                } else if (i + 1 < animalsOrder.size() && eatList.get(animalsOrder.get(i)).contains(animalsOrder.get(i + 1))) {
                    theKilling.add(animalsOrder.get(i) + " eats " + animalsOrder.get(i + 1));
                    animalsOrder.remove(i + 1);
                    someoneAte = true;
                }

                if (someoneAte) i = 0;
                else i++;

            } else {
                i++;
            }
        }

        StringJoiner stringJoiner = new StringJoiner(",");

        for (String animal : animalsOrder) {
            stringJoiner.add(animal);
        }

        theKilling.add(stringJoiner.toString());

        return theKilling.toArray(new String[theKilling.size()]);
    }
}
