package junit.lkelly;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class KataGanadorTest {
    private Fighter fighter1, fighter2;
    private String firstAttacker, winner;

    public KataGanadorTest(Fighter f1, Fighter f2, String fA, String winner) {
        this.fighter1 = f1;
        this.fighter2 = f2;
        this.firstAttacker = fA;
        this.winner = winner;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> establecerDatosDePrueba() {
        List<Object[]> datosDePrueba = new ArrayList<>();
        datosDePrueba.add(new Object[]{new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4),"Lew","Lew"});
        datosDePrueba.add(new Object[]{new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4),"Harry","Harry"});
        datosDePrueba.add(new Object[]{new Fighter("Harald", 20, 5),new Fighter("Harry", 5, 4),"Harry","Harald"});
        datosDePrueba.add(new Object[]{new Fighter("Harald", 20, 5),new Fighter("Harry", 5, 4),"Harald","Harald"});
        datosDePrueba.add(new Object[]{new Fighter("Jerry", 30, 3),new Fighter("Harald", 20, 5),"Jerry","Harald"});
        datosDePrueba.add(new Object[]{new Fighter("Jerry", 30, 3),new Fighter("Harald", 20, 5),"Harald","Harald"});
        return datosDePrueba;
    }

    @Test
    public void test(){
       assertEquals(winner,KataGanador.declareWinner(fighter1,fighter2, firstAttacker));
    }

}
