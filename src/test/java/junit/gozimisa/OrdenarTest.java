package junit.gozimisa;

import junit.gozimisa.Ordenar;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrdenarTest {
    @Test
    public void test1() {
        assertEquals("Es1ta e2s un3a oraci4on", Ordenar.ordenacion("oraci4on un3a e2s Es1ta"));
    }

    @Test
    public void test2() {
        assertEquals("errornumeros", Ordenar.ordenacion("Esto1 no2 funciona4"));
    }

    @Test
    public void test3() {
        assertEquals("errorvacio", Ordenar.ordenacion(""));
    }
    @Test
    public void test4() {
        assertEquals("errorvacioletras", Ordenar.ordenacion("este tambien es un valor vacio"));
    }
    @Test
    public void test5() {
        assertEquals("errorLargo", Ordenar.ordenacion("1este 2es 3un 4string 5largo 6que 7necesita 8sobre 9diez 9palabras 9para 9fallar"));
    }
    @Test
    public void test6() {
        assertEquals("1este 2es 3un 4string 5largo 6que 7necesita 8sobre 9diez", Ordenar.ordenacion("1este 2es 3un 4string 5largo 6que 7necesita 8sobre 9diez"));
    }
}
