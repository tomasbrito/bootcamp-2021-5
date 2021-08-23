package junit.lkelly;

import org.junit.Assert;
import org.junit.Test;

public class OrdenarTest {
    @Test
    public void test(){
        Assert.assertEquals("Es1ta e2s un3a oraci4on",Ordenar.ordenarCadena("oraci4on un3a e2s Es1ta"));
    }
}
