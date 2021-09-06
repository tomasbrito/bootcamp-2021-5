package junit.imiguez;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(value = Parameterized.class)
public class FighterTest {

    private Fighter f1, f2;
    private String res;

    public FighterTest(Fighter f1, Fighter f2, String res) {
        this.f1 = f1;
        this.f2 = f2;
        this.res = res;
    }

    @Test
    public void fightTest() {
        Assert.assertEquals(res, f1.declareWinner(f1, f2, f2.name));
    }

    @Parameterized.Parameters
    public static Iterable<Object []> getParams() {
        List<Object []> params = new ArrayList<>();
        params.add(new Object[]{new Fighter("Pepe", 5, 1), new Fighter("Juan", 5, 1), "Juan"});
        params.add(new Object[]{new Fighter("Pepe", 0, 1), new Fighter("Juan", 0, 2), "Both are dead."});
        return params;
    }

}
