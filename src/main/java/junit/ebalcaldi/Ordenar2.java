package junit.ebalcaldi;


import java.util.ArrayList;
public class Ordenar2 {
    public String ordenar() {
        boolean flag = false;
        String text = "";
        ArrayList<String> palabras = new ArrayList<String>();
        palabras.add("oraci4on");
        palabras.add("un3a");
        palabras.add("e2s");
        palabras.add("Es1ta");




        Integer contador = 1;
        while(!flag) {
            for(String s: palabras) {
                if(s.contains(Integer.toString(contador))) {

                    text += s + " ";
                    contador++;
                    if(contador == 5) {
                        flag = true;
                    }
                }


            }
        }


        return text;
    }

}
