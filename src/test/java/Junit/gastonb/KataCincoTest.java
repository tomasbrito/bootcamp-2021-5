package junit.gastonb;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class KataCincoTest {
    @Test
    public void basicTests1() {
        assertEquals("Lew", KataCinco.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Lew"));
        }
    @Test
    public void basicTests2(){
        assertEquals("Harry", KataCinco.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Harry"));
    }
    @Test
    public void basicTests3(){
        assertEquals("Harald", KataCinco.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));

    }
    @Test
    public void basicTests4(){
        assertEquals("Harald", KataCinco.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald"));
    }
    @Test
    public void basicTests5(){
        assertEquals("Harald", KataCinco.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry"));
    }
    @Test
    public void basicTests6(){
        assertEquals("Harald", KataCinco.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald"));

    }

}
