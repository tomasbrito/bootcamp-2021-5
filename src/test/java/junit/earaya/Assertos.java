package junit.earaya;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Assertos {

    @Test
    public void numeros(){
        //enteros
        assertEquals(4,4); // positiva
        assertNotEquals(4,3); //negativa - correcto - ok
        //numeros decimales
        assertEquals(2.56,2.50,0.1);
    }

    @Test
    public void cadenas(){
        String s1 = "bootCamp";
        String s2 = "Tsoft";
        assertEquals("Este es un mensaje","Hola","Hola");
        assertNotEquals(s1,s2);

    }

    @Test
    public void arrays(){

        ArrayList<String> arrayList1 = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();

        for (int i = 0; i <10 ; i++) {
            String elemtoArray = ""+(i+1);
            arrayList1.add(i,elemtoArray);
            arrayList2.add(i,elemtoArray);
        }

        //Convertir a Arrays
        String[] array1 = arrayList1.toArray(new String[arrayList1.size()]);
        String[] array2 = arrayList2.toArray(new String[arrayList2.size()]);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));

        assertEquals(arrayList1,arrayList2); //valida size de objeto arrayList
        assertArrayEquals(array1,array2); // valida
    }

    @Test
    public void objetos() throws InterruptedException {
        Date objetoFecha1= new Date();
        Date objetoFecha2= new Date();
        assertEquals(objetoFecha1.toString(),objetoFecha2.toString());
        assertNotSame(objetoFecha1,objetoFecha2);
    }

}










