package junit.gozimisa;


/*
antelope eats grass
big-fish eats little-fish
bug eats leaves
bear eats big-fish
bear eats bug
bear eats chicken
bear eats cow
bear eats leaves
bear eats sheep
chicken eats bug
cow eats grass
fox eats chicken
fox eats sheep
giraffe eats leaves
lion eats antelope
lion eats cow
panda eats leaves
sheep eats grass
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KataSeis {
    public static String[] whoEatsWho(final String zoo) {
        String[] food=zoo.split(",");
        String[] eat = new String[food.length+1];
        eat[0]=zoo;
        int h=1;
        System.out.println(eat[0]);

        for(int i=0; i<food.length;i++){
            if(food.length==1){
                eat[h]=food[i];
                System.out.println(food[i]);
                break;
            }
                switch (food[i]){
                    case "fox": {
                        if(i-1>0)
                        {
                            if (food[i-1].equals("chicken") || food[i-1].equals("sheep") ) {

                                eat[h] = (food[i] + " eats " + food[i-1]);
                                System.out.println(eat[h]);
                                h++;
                                food=removeElement(food,i-1);
                                i=-1;
                                break;
                            } else
                                break;
                        }
                        if(i+1 < food.length){
                            if (food[i+1].equals("chicken") || food[i+1].equals("sheep") ) {

                                eat[h] = (food[i] + " eats " + food[i+1]);
                                System.out.println(eat[h]);
                                h++;
                                food=removeElement(food,i+1);
                                i=-1;
                                break;
                            } else
                                break;
                        }
                    }

                    case "chicken": {
                        if (i - 1 > 0) {
                            if (food[i - 1].equals("bug")) {
                                eat[h] = (food[i] + " eats " + food[i - 1]);
                                System.out.println(eat[h]);
                                h++;
                                food=removeElement(food,i-1);
                                i=-1;
                                break;
                            } else
                                break;
                        }
                        if (i + 1 < food.length) {
                            if (food[i + 1].equals("bug")) {
                                eat[h] = (food[i] + " eats " + food[i + 1]);
                                System.out.println(eat[h]);
                                h++;
                                food=removeElement(food,i+1);
                                i=-1;

                            break;}
                        else
                            break;
                    }

                    }
                    case "grass": {
                        break;
                    }

                    case "sheep":{
                        if (i - 1 > 0) {
                            if(food[i-1].equals("grass") ){
                                eat[h] = (food[i] + " eats " + food[i-1]);
                                System.out.println(eat[h]);
                                h++;
                                food=removeElement(food,i-1);
                                i=-1;
                                break;
                            }
                            else
                                break;
                        }
                        if(i+1< food.length){
                            if(food[i+1].equals("grass") ){
                                eat[h] = (food[i] + " eats " + food[i+1]);
                                System.out.println(eat[h]);
                                h++;
                                food=removeElement(food,i+1);
                                i=-1;
                                break;
                            }
                            else
                                break;
                        }

                    }
                    case "antelope": {
                        if (i - 1 > 0) {
                            if (food[i - 1].equals("grass")) {
                                eat[h] = (food[i] + " eats " + food[i - 1]);
                                System.out.println(eat[h]);
                                h++;
                                food=removeElement(food,i-1);
                                i=-1;
                                break;
                            } else
                                break;
                        }
                        if (i + 1 < food.length) {
                            if (food[i + 1].equals("grass")) {
                                eat[h] = (food[i] + " eats " + food[i + 1]);
                                System.out.println(eat[h]);
                                h++;
                                food=removeElement(food,i+1);
                                i=-1;

                                break;}
                            else
                                break;
                        }

                    }
                    case "big-fish": {
                        if (i - 1 > 0) {
                            if (food[i - 1].equals("little-fish")) {
                                eat[h] = (food[i] + " eats " + food[i - 1]);
                                System.out.println(eat[h]);
                                h++;
                                food=removeElement(food,i-1);
                                i=-1;
                                break;
                            } else
                                break;
                        }
                        if (i + 1 < food.length) {
                            if (food[i + 1].equals("little-fish")) {
                                eat[h] = (food[i] + " eats " + food[i + 1]);
                                System.out.println(eat[h]);
                                h++;
                                food=removeElement(food,i+1);
                                i=-1;

                                break;}
                            else
                                break;
                        }

                    }
                    case "bug": {
                        if (i - 1 > 0) {
                            if (food[i - 1].equals("leaves")) {
                                eat[h] = (food[i] + " eats " + food[i - 1]);
                                System.out.println(eat[h]);
                                h++;
                                food=removeElement(food,i-1);
                                i=-1;
                                break;
                            } else
                                break;
                        }
                        if (i + 1 < food.length) {
                            if (food[i + 1].equals("leaves")) {
                                eat[h] = (food[i] + " eats " + food[i + 1]);
                                System.out.println(eat[h]);
                                h++;
                                food=removeElement(food,i+1);
                                i=-1;

                                break;}
                            else
                                break;
                        }

                    }
                    case "bear": {
                        if (i - 1 > 0) {
                            if (food[i - 1].equals("big-fish")||food[i - 1].equals("bug") || food[i - 1].equals("chicken") || food[i - 1].equals("sheep") || food[i - 1].equals("cow") || food[i - 1].equals("leaves")) {
                                eat[h] = (food[i] + " eats " + food[i - 1]);
                                System.out.println(eat[h]);
                                h++;
                                food=removeElement(food,i-1);
                                i=-1;
                                break;
                            } else
                                break;
                        }
                        if (i + 1 < food.length) {
                            if (food[i + 1].equals("big-fish")||food[i + 1].equals("bug") || food[i + 1].equals("chicken") || food[i + 1].equals("sheep") || food[i + 1].equals("cow") || food[i + 1].equals("leaves")) {
                                eat[h] = (food[i] + " eats " + food[i + 1]);
                                System.out.println(eat[h]);
                                h++;
                                food=removeElement(food,i+1);
                                i=-1;

                                break;}
                            else
                                break;
                        }

                    }
                    case "cow": {
                        if (i - 1 > 0) {
                            if (food[i - 1].equals("grass")) {
                                eat[h] = (food[i] + " eats " + food[i - 1]);
                                System.out.println(eat[h]);
                                h++;
                                food=removeElement(food,i-1);
                                i=-1;
                                break;
                            } else
                                break;
                        }
                        if (i + 1 < food.length) {
                            if (food[i + 1].equals("grass")) {
                                eat[h] = (food[i] + " eats " + food[i + 1]);
                                System.out.println(eat[h]);
                                h++;
                                food=removeElement(food,i+1);
                                i=-1;

                                break;}
                            else
                                break;
                        }

                    }
                    case "giraffe": {
                        if (i - 1 > 0) {
                            if (food[i - 1].equals("leaves")) {
                                eat[h] = (food[i] + " eats " + food[i - 1]);
                                System.out.println(eat[h]);
                                h++;
                                food=removeElement(food,i-1);
                                i=-1;
                                break;
                            } else
                                break;
                        }
                        if (i + 1 < food.length) {
                            if (food[i + 1].equals("leaves")) {
                                eat[h] = (food[i] + " eats " + food[i + 1]);
                                System.out.println(eat[h]);
                                h++;
                                food=removeElement(food,i+1);
                                i=-1;

                                break;}
                            else
                                break;
                        }

                    }
                    case "lion": {
                        if (i - 1 > 0) {
                            if (food[i - 1].equals("antelope") || food[i - 1].equals("cow")) {
                                eat[h] = (food[i] + " eats " + food[i - 1]);
                                System.out.println(eat[h]);
                                h++;
                                food=removeElement(food,i-1);
                                i=-1;
                                break;
                            } else
                                break;
                        }
                        if (i + 1 < food.length) {
                            if (food[i + 1].equals("antelope") || food[i + 1].equals("cow")) {
                                eat[h] = (food[i] + " eats " + food[i + 1]);
                                System.out.println(eat[h]);
                                h++;
                                food=removeElement(food,i+1);
                                i=-1;

                                break;}
                            else
                                break;
                        }

                    }
                    case "panda": {
                        if (i - 1 > 0) {
                            if (food[i - 1].equals("leaves")) {
                                eat[h] = (food[i] + " eats " + food[i - 1]);
                                System.out.println(eat[h]);
                                h++;
                                food=removeElement(food,i-1);
                                i=-1;
                                break;
                            } else
                                break;
                        }
                        if (i + 1 < food.length) {
                            if (food[i + 1].equals("leaves")) {
                                eat[h] = (food[i] + " eats " + food[i + 1]);
                                System.out.println(eat[h]);
                                h++;
                                food=removeElement(food,i+1);
                                i=-1;

                                break;}
                            else
                                break;
                        }

                    }


                }


        }

            return eat;
    }

    public static String[] removeElement(String[] a, int del) {
        List b = new ArrayList(Arrays.asList(a));
        b.remove(del);
        String [] c= new String[b.size()];
        for (int i=0; i<b.size();i++){
            c[i]= (String) b.get(i);
        }
        return c;
    }


}

/*
if(food[i].equals("fox") && (food[j].equals("chicken") || food[j].equals("sheep") )){
                    eat[h]=(food[i]+" eats "+food[j]);
                    System.out.println(eat[h]);
                    h++;}
                if(food[i].equals("bug") && (food[j].equals("leaves"))){
                    eat[h]=(food[i]+" eats "+food[j]);
                    System.out.println(eat[h]);
                    h++;}
                if(food[i].equals("chicken") && (food[j].equals("bug") )){
                    eat[h]=(food[i]+" eats "+food[j]);
                    System.out.println(eat[h]);
                    h++;}
                if(food[i].equals("sheep") && (food[j].equals("grass") )){
                    eat[h]=(food[i]+" eats "+food[j]);
                    System.out.println(eat[h]);
                    h++;}
                if(food[i].equals("antelope") && (food[j].equals("grass") )){
                    eat[h]=(food[i]+" eats "+food[j]);
                    System.out.println(eat[h]);
                    h++;}
                if(food[i].equals("big-fish") && (food[j].equals("little-fish") )){
                    eat[h]=(food[i]+" eats "+food[j]);
                    System.out.println(eat[h]);
                    h++;}
                if(food[i].equals("bear") && (food[j].equals("bug") || food[j].equals("chicken") ||food[j].equals("cow") || food[j].equals("leaves") || food[j].equals("sheep"))){
                    eat[h]=(food[i]+" eats "+food[j]);
                    System.out.println(eat[h]);
                    h++;}
                if(food[i].equals("cow") && (food[j].equals("grass") )){
                    eat[h]=(food[i]+" eats "+food[j]);
                    System.out.println(eat[h]);
                    h++;}
                if(food[i].equals("giraffe") && (food[j].equals("leaves") )){
                    eat[h]=(food[i]+" eats "+food[j]);
                    System.out.println(eat[h]);
                    h++;}
                if(food[i].equals("lion") && (food[j].equals("antelope") || food[j].equals("cow") )){
                    eat[h]=(food[i]+" eats "+food[j]);
                    System.out.println(eat[h]);
                    h++;}
                if(food[i].equals("panda") && (food[j].equals("leaves") )){
                    eat[h]=(food[i]+" eats "+food[j]);
                    System.out.println(eat[h]);
                    h++;}
 */