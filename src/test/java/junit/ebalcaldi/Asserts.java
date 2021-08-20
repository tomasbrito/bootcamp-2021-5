package junit.ebalcaldi;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Asserts {

    @Test
    public void numeros(){

        Assert.assertEquals(4, 4);
        Assert.assertNotEquals(4, 3);
        Assert.assertEquals(2.56, 2.69, 0.1);
    }

    @Test
    public void cadenas(){
        String aux = "bootCamp";
        String aux2 = "Tsoft";
        Assert.assertNotEquals(aux, aux2);
        Assert.assertEquals("Esto es un mensaje", "Hola", "Hola");
    }
    @Test
    public void arrays(){
        ArrayList<String> arr = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            String a = " "+(1+i);
            arr.add(i, a);
            arr2.add(i, a);

        }

        String[] array = arr.toArray(new String[arr.size()]);
        String[] array2 = arr.toArray(new String[arr2.size()]);

        Assert.assertEquals(arr, arr2);
        Assert.assertArrayEquals(array, array2);



    }
}
